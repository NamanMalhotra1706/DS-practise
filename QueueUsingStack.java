// Hackerrank Question Link : https://www.hackerrank.com/challenges/queue-using-two-stacks/problem?isFullScreen=true

import java.util.*;

class Queues<T> {
    Stack<T> st1 = new Stack<>();
    Stack<T> st2 = new Stack<>();

    public void enqueue(T val) {
        st1.push(val);
    }

    public T dequeue() {
        if (st1.isEmpty() && st2.isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.pop();
    }

    public T peek() {
        if (st1.isEmpty() && st2.isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }

        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop());
            }
        }

        return st2.peek();
    }
}

public class QueueUsingStack{
    public static void main(String[] args) {
        Queues<Integer> qu = new Queues<>();
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        while (cases-- > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                int val = sc.nextInt();
                qu.enqueue(val);
            } else if (op == 2) {
                qu.dequeue();
            } else if (op == 3) {
                System.out.println(qu.peek());
            }
        }
    }
}

