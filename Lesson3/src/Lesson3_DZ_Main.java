import queue.Deque;
import queue.DequeImpl;

import java.util.Stack;

public class Lesson3_DZ_Main {
    public static void main(String[] args) {
        //TASK 1
        String str = "abcd";

        Stack st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        while ( !st.isEmpty() ) {
            System.out.print(st.pop());
        }
        System.out.println();


        //TASK 2
        Deque deq = new DequeImpl(6);

        insertRight(deq, 1);
        insertRight(deq, 2);
        insertRight(deq, 3);
//        insertRight(deq, 4);// 1 2 3 4
        insertLeft(deq, 5); // 5 1 2 3 4
        insertLeft(deq, 6); // 6 5 1 2 3 4

//        removeLeft(deq); //5 1 2 3 4
//        removeRight(deq); // 5 1 2 3
        displayLeftToRight(deq); // Queue
//        displayRightToLeft(deq); //Stack
    }

    private static void insertRight(Deque deq, int value) {
        if ( !deq.isFull() ) {
            deq.insertRight(value);
        }
    }

    private static void insertLeft(Deque deq, int value) {
        if ( !deq.isFull() ) {
            deq.insertLeft(value);
        }
    }

    private static void removeRight(Deque deq) {
        if ( !deq.isEmpty() ) {
            deq.removeRight();
        }
    }

    private static void removeLeft(Deque deq) {
        if ( !deq.isEmpty() ) {
            deq.removeLeft();
        }
    }

    private static <T> void displayRightToLeft(Deque deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeRight());
        }
    }

    private static <T> void displayLeftToRight(Deque deq) {
        while ( !deq.isEmpty() ) {
            System.out.println(deq.removeLeft());
        }
    }
}