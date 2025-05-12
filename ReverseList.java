import java.io.*;
import java.util.*;
import java.util.stream.*;


class ResultReverseList {

    /*
     * Complete the 'reverse' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        SinglyLinkedListNode head = llist;
        Stack<Integer> st= new Stack<>();

        while(head!=null){
            st.push(head.data);
            head = head.next;
        }

        SinglyLinkedListNode firstNode = new SinglyLinkedListNode(st.pop());
        head = firstNode;
        SinglyLinkedListNode currNode = head;

        while(!st.isEmpty()){
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(st.pop());
            currNode.next = newNode;
            currNode = currNode.next;
        }


        return head;
    }

}

public class ReverseList{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tests = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, tests).forEach(testsItr -> {
            try {
                SinglyLinkedList llist = new SinglyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                SinglyLinkedListNode llist1 = ResultReverseList.reverse(llist.head);

                SinglyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
