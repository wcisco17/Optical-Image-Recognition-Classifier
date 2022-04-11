package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadData {
    public final static PrintStream out = System.out;
    public static final String HANDWRITTEN_DATA_SET_FILE_ONE = "src/data/cw2DataSet1.csv";
    public static final String HANDWRITTEN_DATA_SET_FILE_TWO = "src/data/cw2DataSet2.csv";
    public static final int TOTAL_ELEMENTS = 65;
    public static final int TOTAL_ROWS = 2810;

    // the purpose of this method is to read in the data using a Array stream.
    public static List<List<Integer>> readDataSet(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String testSetLine;
        List<List<Integer>> handwrittenData = new ArrayList<>();

        // at each iteration we map the values in our stream at the initial state these values are strings.
        // so first map -> to parse the values into doubles.
        // then we map -> to turn the values into integers
        // then we finally use collect to return the values into a list.
        while ((testSetLine = bufferedReader.readLine()) != null) {
            String[] value = testSetLine.split(",");
            List<Integer> values = Arrays.stream(value)
                    .map(Double::parseDouble)
                    .map(Double::intValue)
                    .collect(Collectors.toList());
            handwrittenData.add(values);
        }

        // we return the list as an Array<List> containing our data-set.
        return handwrittenData;
    }

}
