# Optical-Image-Recognition-Classifier

## Nearest Neighbor

Using the Optical Handwritten Digit data set I produced a solution which satisfies the baseline - 
reported from the UCI website. 

For our analysis we used the Nearest Neighbor, it is a simple algorithm which gives an input vector, 
in our case would be the training data, calculate the approximate distance of the nearest vector (test set) and classify it. 
The Nearest Neighbor algorithm is regarded as a “simple” algorithm to use but can become ineffective when the data is in high-dimensional 
space, i.e “The curse of dimensionality”. 


Why is it so effective in our case? The answer always depends on the data set, in our case the 
Optical Handwritten Digit data set is partially classified and to our benefit gives us the closest pairing of the predicted position. 
Since we get a pairing which can lead us to the “best” assignment, the nearest-neighbor filter does its job by choosing the closest objects 
and adds its prediction to the given outcome. Our measure point for our system is the Euclidean distance which calculates the nearest path between two points. By point of measure the Euclidean distance is the best measure to use in our use case, as it closely pairs objects and simply defines the smallest distance between them. It is also the simplest for our algorithm. The underlying mathematical notation for our Euclidean distance can be described like so:

```dist((x, y), (a, b)) = √(x - a)2 + (y - b)2```

A simple solution for a simple dataset is the main reason I chose this algorithm, compared to other algorithms which 
required a complex set of requirements, the nearest neighbor performed the best out of all of them. 
Additionally, the fact that our data set avoided unnecessary biases given that our objects were approximate with one 
another gave such a strong result at the end.

The result of the algorithm is denoted below:
-----
```Data set {dataSetOne used for training} {dataSetTwo used for accuracy} Percentage: 98.04270462633453```

```Data set {dataSetTwo used for training} {dataSetOne used for accuracy} Percentage: 98.46975088967972```


```The average of the two data set is: 98.25622775800711```
