//Hacker Rank Question Link : https://www.hackerrank.com/challenges/ctci-ransom-note/problem


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {

        boolean isContain = false;
        for(int i=0;i<note.size();i++){
            if(magazine.contains(note.get(i))){
                isContain = true;
                magazine.remove(note.get(i));
            }
            else{
                isContain = false;
                break;
            }
        }

        if(isContain){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

}

public class RansomeNote{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
