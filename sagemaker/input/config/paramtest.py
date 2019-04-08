#!/usr/bin/env python

import boto3
import json


param_path = 'hyperparameters.json'

## hyperparameter

# LogisticRegression(C=6, class_weight=None, dual=False, fit_intercept=True,
#           intercept_scaling=1, max_iter=100, multi_class='ovr', n_jobs=1,
#           penalty='l1', random_state=None, solver='liblinear', tol=0.0001,
#           verbose=0, warm_start=False)

#hyperparameters = dict(batch_size=32, data_augmentation=True, learning_rate=.0001,
#                       width_shift_range=.1, height_shift_range=.1, epochs=1)

print(param_path)

with open(param_path, 'r') as tc:
    hyperparameters = json.load(tc)


print(hyperparameters)

#mytest = dict(test="testval")

print(hyperparameters.get('test', None))
