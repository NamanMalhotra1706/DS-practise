import java.util.ArrayList;
import java.util.List;

public class Logs {
    public List<List<String>> extractErrorLogs(List<List<String>> logs){
        List<List<String>> ansLogs = new ArrayList<>();

        for(int i=0;i<logs.size();i++){
            List<String> list = logs.get(i);

            if(list.get(2).equals("ERROR") || list.get(2).equals("CRITICAL")){
                ansLogs.add(list);
            }
        }
        ansLogs.sort((a, b) -> {
            String dateTimeA = a.get(0) + " " + a.get(1);
            String dateTimeB = b.get(0) + " " + b.get(1);
            return dateTimeA.compareTo(dateTimeB);
        });
        return ansLogs;
    }
}
