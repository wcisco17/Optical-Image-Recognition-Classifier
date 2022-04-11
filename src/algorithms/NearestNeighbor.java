package algorithms;

import java.io.IOException;
import java.util.*;

public class NearestNeighbor extends ReadData {
    // checks the pairs lists and ensures they are the same length. IF not we throw an error below.
    public static boolean checkPairList(List<Integer> featurePair, List<Integer> otherFeaturePair) {
        return (featurePair.size() != otherFeaturePair.size());
    }

    // calculates the euclidean distance of the two points
    public static double calculateEuclideanDistance(List<Integer> features, List<Integer> otherFeatures) {
        // check if both features are the same size, throws a system err if not. See method above.
        if (checkPairList(features, otherFeatures))
            System.err.printf("Features set are not the same size, X = %s, Y = %s", features.size(), otherFeatures.size());

        // start with a distance at 0
        double distance = 0;
        // go through all the values in the row not including the last.
        for (int featureIdx = 0; featureIdx < features.size() - 1; featureIdx++)
            distance += Math.pow(otherFeatures.get(featureIdx) - features.get(featureIdx), 2);

        return (Math.sqrt(distance));
    }

    // gets the nearest neighbors in our test and training dataset and returns the totalCorrect
    public static double getNeighbors(List<List<Integer>> train, List<List<Integer>> testSet) {
        // initialize our variables
        double distance;
        List<Integer> closestArray;
        int count = 0;
        double closestDistance;

        // loop over the testSetData to find the closestArray
        for (List<Integer> testSetData : testSet) {
            // reset the values once we've gone through the first testSetData ect..
            closestArray = new ArrayList<>(0);
            closestDistance = 0;

            // Go through the training data set and at each point we calculate the euclidean distance
            for (List<Integer> trainData : train) {
                distance = calculateEuclideanDistance(testSetData, trainData);

                // we then check the closestDistance which is initialized to 0 at first, then we
                // assign it a different value. We also change the values of the closestArray and we
                // count it later...
                if (closestDistance == 0 || distance < closestDistance) {
                    closestDistance = distance;
                    closestArray = trainData;
                }
            }

            // We check the testSetData and closestArray and count up all the values that are similar to each other.
            if (testSetData.get(TOTAL_ELEMENTS - 1).equals(closestArray.get(TOTAL_ELEMENTS - 1)))
                count++;
        }

        // we return the counts of each closest values in our dataset.
        return count;
    }

    // we calculate the average of overall values.
    private static double calculateAverage(double firstResult, double secondResult) {
        return ((firstResult + secondResult) / (TOTAL_ROWS * 2) * 100.0);
    }

    public void run() throws IOException {
        out.println("Running Nearest Neighbor Algorithm...");
        // we grab and read our datasetone from our folder
        List<List<Integer>> dataSetOne = readDataSet(HANDWRITTEN_DATA_SET_FILE_ONE);
        // we grab and read our datasettwo from our folder
        List<List<Integer>> dataSetTwo = readDataSet(HANDWRITTEN_DATA_SET_FILE_TWO);

        // values to assign total = percentage of the values closest to each other, totalCorrect 1 & 2 are the count of values for each neighbor
        double total;
        double totalCorrect1;
        double totalCorrect2;

        // Get the neighbors from the first dataSet
        totalCorrect1 = getNeighbors(dataSetOne, dataSetTwo);
        // get the percentage
        total = (totalCorrect1 / TOTAL_ROWS * 100.0);
        out.printf("Data set {dataSetOne used for training} {dataSetTwo used for accuracy} Percentage: %s \n", total);

        // Get the neighbors from the second dataSet
        totalCorrect2 = getNeighbors(dataSetTwo, dataSetOne);
        // get the percentage
        total = (totalCorrect2 / TOTAL_ROWS * 100.0);
        out.printf("Data set {dataSetTwo used for training} {dataSetOne used for accuracy} Percentage: %s \n", total);

        // getting the average of the dataset-one and dataset-two.
        double average = calculateAverage(totalCorrect1, totalCorrect2);
        out.printf("The average of the two data set is: %s", average);
    }
}