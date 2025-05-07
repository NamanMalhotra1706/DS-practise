// Hackerrank Question Link : https://www.hackerrank.com/challenges/balanced-brackets/problem

import java.io.*;
import java.util.*;
import java.util.stream.*;

class ResultBalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {

        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    return "NO";
                }
                else if(s.charAt(i)==']' && st.peek()=='[' ){
                    st.pop();
                }
                else if(s.charAt(i)=='}' && st.peek()=='{' ){
                    st.pop();
                }
                else if(s.charAt(i)==')' && st.peek()=='(' ){
                    st.pop();
                }
                else{
                    return "NO";
                }
            }
        }
        if(st.isEmpty()){
            return "YES";
        }
        else return "NO";

    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = ResultBalancedBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
