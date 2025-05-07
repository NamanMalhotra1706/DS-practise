
// Hackerrank Question Link : https://www.hackerrank.com/challenges/java-hashset/problem
import java.util.*;


public class JavaHashset {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashMap<String, HashSet<String>> map = new HashMap<>();

        int setEleCounts = 0;

        for(int i=0;i< t ; i++){
            if(map.containsKey(pair_left[i])){
                HashSet<String> st = map.get(pair_left[i]);
                if(!st.contains(pair_right[i])){
                    st.add(pair_right[i]);
                    setEleCounts += 1;
                }
            }
            else{
                HashSet<String> newSet = new HashSet<>();
                newSet.add(pair_right[i]);
                map.put(pair_left[i], newSet);
                setEleCounts +=1;
            }

            System.out.println(setEleCounts);

        }


    }
}