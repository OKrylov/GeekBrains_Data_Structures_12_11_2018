import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main4 {

    public static void main(String[] args) {
//        LinkedList list = new SimpleLinkedListImpl();
        TwoSideLinkedList list = new TwoSideLinkedListImpl();
        list.add(1);
        list.add(2);
        list.addLast(3);
        list.add(4);

        list.display();
        System.out.println("-------------");
        System.out.println("Find 2: " + list.find(2));
        System.out.println(list.remove(2));
        System.out.println("Find 2: " + list.find(2));

        System.out.println("-------------");

        while ( !list.isEmpty() ) {
            System.out.println(list.remove());
        }
        System.out.println("-------------");

        List<String> array = new LinkedList<>();
        array.add("s");
        array.add("t");
        array.add("r");

        for (String s : array) {
            System.out.println(s);
        }

        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

//        for (int value : list) {
//            System.out.println(value);
//        }



    }
}
