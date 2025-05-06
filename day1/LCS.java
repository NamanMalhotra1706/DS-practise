package day1;

import java.io.*;

class ResultLCS {

    /*
     * Complete the 'commonChild' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int commonChild(String s1, String s2) {
        int arr[][] = new int[s1.length()+1][s2.length()+1];


        for(int i=0;i<s1.length();i++){
            arr[i][0] = 0;
        }

        for(int i=0;i<s2.length();i++){
            arr[0][i] = 0;
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                }
                else{
                    int ans1 = arr[i][j-1];
                    int ans2 = arr[i-1][j];
                    arr[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return arr[s1.length()][s2.length()];

    }

}

public class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = ResultLCS.commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

