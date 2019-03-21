try:
    from StringIO import StringIO
except ImportError:
    from io import StringIO

from io import BytesIO
import csv
import sys, os, base64, datetime, hashlib, hmac
from chalice import Chalice
from chalice import NotFoundError, BadRequestError


import sys, os, base64, datetime, hashlib, hmac
app = Chalice(app_name='titanic')
app.debug = True

try:
    from urlparse import urlparse, parse_qs
except ImportError:
    from urllib.parse import urlparse, parse_qs

import boto3
sagemaker = boto3.client('sagemaker-runtime')

@app.route('/', methods=['POST'], content_types=['application/x-www-form-urlencoded'])
def handle_data():
    d = parse_qs(app.current_request.raw_body)
    # data to csv

    try:
        my_dict = {k:float(v[0]) for k, v in d.iteritems()}
    except AttributeError:
        my_dict = {k:float(v[0]) for k, v in d.items()}
    f = StringIO()
    w = csv.DictWriter(f, my_dict.keys())
    #w.writeheader()
    w.writerow(my_dict)

    input_csv = "23,{},1,0,0,3.625,0,0,1,0,0,{},0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0".format(my_dict['Sex'], my_dict['1stClass'])

    res = sagemaker.invoke_endpoint(
                    EndpointName='prod-sm-endpoint',
                    #Body=f.getvalue(),
                    Body=input_csv
                    ContentType='text/csv',
                    Accept='Accept'
                )
    return res['Body'].read()
