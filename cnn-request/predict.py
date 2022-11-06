
import sys
import tensorflow as tf
import numpy as np
import pickle
from tensorflow.keras.utils import array_to_img, img_to_array, load_img


TYPES = ["Mar", "Banana", "Pruna", "Ardei", "Cirese", "Struguri", "Rosie", "Cartof", "Para", "Piersica"]
filePath = sys.argv[1]
infile = filePath + "/test_sample.jpg"

images_as_array2 = []
images_as_array2.append(img_to_array(load_img(infile,target_size=(32, 32))))
images_as_array2.append(img_to_array(load_img(infile,target_size=(32, 32))))
images_as_array2 =  np.array(images_as_array2)
x_test = images_as_array2



with open(filePath + '/model_pkl' , 'rb') as f:
    lr = pickle.load(f)


y_pred = lr.predict(x_test)

pred_idx = np.argmax(y_pred[0])


with open(filePath + "/filename.txt",'w') as f:
    f.write(TYPES[pred_idx])

# print(TYPES[pred_idx])