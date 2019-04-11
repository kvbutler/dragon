import json
from io import BytesIO
import boto3
import csv
import sys, os, base64, datetime, hashlib, hmac

def get_sagemaker_request(passengerGender, passengerClass):

    if passengerGender == "Male":
        genderValue = 1
    elif passengerGender == "Female":
        genderValue = 0

    class1st = passengerClass == 1
    class2nd = passengerClass == 2
    class3rd = passengerClass == 3

    input_csv = "6,{},1,0,0,3.625,0,0,1,0,0,{},{},{},0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0".format(genderValue,class1st,class2nd,class3rd )
    print(input_csv)
    res = sagemaker.invoke_endpoint(
                    EndpointName='dev-sm-endpoint',
                    Body=input_csv,
                    ContentType='text/csv',
                    Accept='Accept'
                )
    return res['Body'].read()



def lambda_handler(event, context):
    # TODO implement
    eventBody = json.loads(event['body'])
    print(eventBody)

    didPassengerSurvive = get_sagemaker_request(eventBody['gender'], eventBody['passengerClass'])

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