// Hacker Rank Question Link : https://www.hackerrank.com/challenges/making-anagrams/problem

package day1;

import java.io.*;
import java.util.*;



class ResultAnagram {

    /*
     * Complete the 'makingAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static int makingAnagrams(String s1, String s2) {
        HashMap<Character,Integer>map1 = new HashMap<>();


        // for(int i=0;i<s1.length();i++){
        //     if(map1.containsKey(s1.charAt(i))){
        //         map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
        //     }
        //     else{
        //         map1.put(s1.charAt(i), 1);
        //     }
        // }

        // for(int i=0;i<s2.length();i++){
        //     if(map1.containsKey(s2.charAt(i))){
        //         map1.put(s2.charAt(i), map1.get(s2.charAt(i))-1);
        //     }
        //     else{
        //         map1.put(s2.charAt(i), -1);
        //     }
        // }


        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);

        }

        for(int i=0;i<s2.length();i++){
            map1.put(s2.charAt(i), map1.getOrDefault(s2.charAt(i), 0)-1);
        }

        int sum=0;

        for(Integer num : map1.values()){
            sum+=Math.abs(num);
        }


        return sum;
    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = bufferedReader.readLine();

        String s2 = bufferedReader.readLine();

        int result = ResultAnagram.makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
