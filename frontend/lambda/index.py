import json
from io import BytesIO
import boto3
import csv
import sys, os, base64, datetime, hashlib, hmac

def lambda_handler(event, context):
    # TODO implement
    # eventBody = json.loads(event['body'])
    # print(eventBody)

    print(event)

    return {
        'statusCode': 201,
        'body' : json.dumps({"passengerAlive": 0}),
        'headers' : {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }
    }
