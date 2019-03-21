#!/usr/bin/env python

import boto3
import sagemaker as sage


sagemaker_client = boto3.client('sagemaker')

dev_endpoint = sagemaker_client.describe_endpoint(
        EndpointName='dev-sm-endpoint'
    )



print (dev_endpoint['ProductionVariants'])


dev_endpoint_config = sagemaker_client.describe_endpoint_config(
  EndpointConfigName=dev_endpoint['EndpointConfigName']
)
model_name = dev_endpoint_config['ProductionVariants'][0]['ModelName']
sess = sage.Session()
endpoint_config = sess.create_endpoint_config("qa-sm-endpoint", model_name, 1, "ml.m4.xlarge")
sess.create_endpoint("qa-sm-endpoint", "qa-sm-endpoint", wait=True)
