import json
from io import BytesIO
import boto3
import csv
import sys, os, base64, datetime, hashlib, hmac

def lambda_handler(event, context):

    eventBody = json.loads(event['body'])
    print(eventBody)
    return {
        'statusCode': 201,
        'body' : json.dumps({"passengerAlive": 0}),
        'headers' : {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }

    }
