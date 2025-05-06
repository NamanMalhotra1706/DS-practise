
/*
Given a 6X6 2D array, an hourglass is a subset of values with indices falling in the following pattern:
a b c
  d
e f g

*/

// HackerRank Question Link: https://www.hackerrank.com/challenges/2d-array/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=arr.size()-3;i++){
            for(int j=0;j<=arr.size()-3;j++){
                int currentSum=0;
                int firstRow = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2);
                int secRow = arr.get(i+1).get(j+1);
                int thirRow = arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                currentSum = firstRow+secRow+thirRow;

                maxSum = Math.max(currentSum, maxSum);
            }
        }

        return maxSum;
    }

}

public class Array2DDS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}