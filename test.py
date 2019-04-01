#!/usr/bin/env python

import boto3
import sagemaker.predictor


client = boto3.client('sagemaker-runtime')

#csv_text = '5.1,3.5,1.4,0.2'

#mypredictor = sagemaker.predictor.RealTimePredictor(
#    endpoint="decision-trees-sample-2019-03-19-04-10-12-776",content_type="text/csv")

#print (mypredictor.predict(csv_text).decode('utf-8'))

    #input_csv = "{},{},1,0,0,3.625,0,0,1,0,0,{},0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0".format(my_dict['Age'], my_dict['Sex'], my_dict['1stClass'])

#input_csv = "23,1,1,0,0,3.625,0,0,1,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0"
#input_csv = "38,0,1,0,0,35.64165,0,0,0,1,0,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0"
input_csv = "35,0,1,1,0,6.75,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0"
mypredictor = sagemaker.predictor.RealTimePredictor(
    endpoint="prod-sm-endpoint",content_type="text/csv")

print (mypredictor.predict(input_csv).decode('utf-8'))

# res = client.invoke_endpoint(
#                     EndpointName='dev-sm-endpoint',
#                     #Body=f.getvalue(),
#                     Body=input_csv,
#                     ContentType='text/csv',
#                     Accept='Accept'
#                 )
#
# res['Body'].read()
# print (res['Body'].read())
