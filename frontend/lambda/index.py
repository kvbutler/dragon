import json
from io import BytesIO
import boto3
import csv
import sys, os, base64, datetime, hashlib, hmac

def lambda_handler(event, context):
    # TODO implement
    eventBody = json.loads(event['body'])
    print(eventBody)
    passengerGender = eventBody['gender']

    didPassengerSurvive = sagemaker_request(eventBody['gendger'], eventBody['passengerClass'])

    if didPassengerSurvive == 1:
        passenger = "Alive"
    elif didPassengerSurvive == 0:
        passenger = "Dead"

    return {
        'statusCode': 201,
        'body' : json.dumps({"passengerStatus": passenger}),
        'headers' : {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }
        
    }

def sagemaker_request(passengerGender, passengerClass):

    sagemaker = boto3.client('sagemaker-runtime')

    input_csv = "23,{},1,0,0,3.625,0,0,1,0,0,{},0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0".format(passengerGender, passengerClass)

    res = sagemaker.invoke_endpoint(
                    EndpointName='prod-sm-endpoint',
                    #Body=f.getvalue(),
                    Body=input_csv,
                    ContentType='text/csv',
                    Accept='Accept'
                )
    return res['Body'].read()

