import json
from io import BytesIO
import boto3
import csv
import sys, os, base64, datetime, hashlib, hmac

def lambda_handler(event, context):
    # TODO implement
    eventBody = json.loads(event['body'])
    print(eventBody)


    # if passengerGender == "Male":
    #     genderValue = 1
    # elif passengerGender == "Female":
    #     genderValue = 0
    #
    # class1st = passengerClass == 1
    # print(class1st)
    # class2nd = passengerClass == 2
    # print(class2nd)
    # class3rd = passengerClass == 3
    # print(classrd)
    #
    # input_csv = "6,{},1,0,0,3.625,0,0,1,0,0,{},{},{},0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0".format(genderValue,class1st,class2nd,class3rd )
    # print(input_csv)
    # sagemaker = boto3.client('sagemaker-runtime')
    # res = sagemaker.invoke_endpoint(
    #                 EndpointName='dev-sm-endpoint',
    #                 Body=input_csv,
    #                 ContentType='text/csv',
    #                 Accept='Accept'
                )
    # return res['Body'].read()
   #
   #  return {
   #      'statusCode': 201,
   #      'body' : json.dumps({"passengerAlive": res['Body'].read()}),
   #      'headers' : {
   #          'Content-Type': 'application/json',
   #          'Access-Control-Allow-Origin': '*'
   #      }
   #
   # }

    return {
        'statusCode': 201,
        'body' : json.dumps({"passengerAlive": "0"}),
        'headers' : {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }

   }
