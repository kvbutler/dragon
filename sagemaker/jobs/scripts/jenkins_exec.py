#!/usr/bin/env python

import os
from sagemaker import get_execution_role
import sagemaker as sage
from sagemaker.predictor import csv_serializer


# S3 prefix
common_prefix = "DEMO-sean-test"
training_input_prefix = common_prefix + "/training-input-data"
batch_inference_input_prefix = common_prefix + "/batch-inference-input-data"

sess = sage.Session()

#role = get_execution_role()

role = "arn:aws:iam::x:role/service-role/AmazonSageMaker-ExecutionRole-20190103T142553"

TRAINING_WORKDIR = "data/training"

training_input = sess.upload_data(TRAINING_WORKDIR, key_prefix=training_input_prefix)
print ("Training Data Location " + training_input)

account = sess.boto_session.client('sts').get_caller_identity()['Account']
region = sess.boto_session.region_name
image = '{}.dkr.ecr.{}.amazonaws.com/logistic-regression:latest'.format(account, region)

tree = sage.estimator.Estimator(image,
                       role, 1, 'ml.c4.2xlarge',
                       output_path="s3://{}/output".format(sess.default_bucket()),
                       sagemaker_session=sess)
tree.fit(training_input)

model = tree.create_model()

print(model)

predictor = tree.deploy(1, 'ml.m4.xlarge', serializer=csv_serializer)
