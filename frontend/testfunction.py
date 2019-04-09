import json
def lambda_handler(event, context):
    # TODO implement
    eventBody = json.loads(event['body'])
    print(eventBody)
    passengerGender = eventBody['gender']
    return {
        'statusCode': 201,
        'body' : json.dumps({"passengerGender": passengerGender}),
        'headers' : {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*'
        }
        
    }
k