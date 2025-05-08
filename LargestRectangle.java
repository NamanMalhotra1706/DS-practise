// Hackerrank Question Link: https://www.hackerrank.com/challenges/largest-rectangle/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'largestRectangle' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY h as parameter.
     */

    public static long largestRectangle(List<Integer> h) {

        Long largestHeight = (long)1;
        int k=1;

        Stack<Integer> st = new Stack<>();
        List<Integer> rightGreater = new ArrayList<>();
        List<Integer> LeftGreater= new ArrayList<>();

        for(int i=0;i<h.size();i++){
            int j=i+1;
            int currentMax = 1;
            while(j<h.size() && h.get(j)>=h.get(i)){
                currentMax++;
                st.push(h.get(j));
                j++;
            }
            rightGreater.add(currentMax);
        }



        for(int i=h.size()-1;i>=0;i--){
            int j=i-1;
            int currentMax=0;
            while(j>=0 && h.get(j)>=h.get(i)){
                currentMax++;
                st.push(h.get(j));
                j--;
            }
            LeftGreater.add(currentMax);
        }

        Collections.reverse(LeftGreater);
        for(int i=0;i<h.size();i++){
            System.out.print(LeftGreater.get(i)+" ");
        }
        System.out.println();
        for(int i=0;i<h.size();i++){
            System.out.print(rightGreater.get(i)+" ");
        }

        for(int i=0;i<h.size();i++){

            largestHeight = Math.max(largestHeight, h.get(i)*(rightGreater.get(i)+LeftGreater.get(i)));
        }


        return largestHeight;

    }
}

public class LargestRectangle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        long result = Result.largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
