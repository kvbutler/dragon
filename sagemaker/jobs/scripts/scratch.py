#!/usr/bin/env python

import os,argparse
from sagemaker import get_execution_role
import sagemaker as sage
from sagemaker.predictor import csv_serializer
import boto3
import json


parser=argparse.ArgumentParser()

parser.add_argument('--image', required=True, help='name of the docker image')
parser.add_argument('--version', default="latest", help='version/tag to pull from ecr')
parser.add_argument('--workspace', default=os.getcwd())
parser.add_argument('--modeluri', default="")
parser.add_argument('--buildid', default="")

args=parser.parse_args()

# S3 prefix
sess = sage.Session()


ssm_client = boto3.client('ssm')

response = ssm_client.put_parameter(
    Name='/sagemaker/train_model/sagemaker-job-1111/training_job_name',
    Description='training job name for the jenkins build id',
    Value='mytestvalue',
    Overwrite=True,
    Type='String')


parameter = ssm_client.get_parameter(
    Name="/sagemaker/train_model/sagemaker-job-1111/training_job_name")

print (parameter['Parameter']['Value'])
