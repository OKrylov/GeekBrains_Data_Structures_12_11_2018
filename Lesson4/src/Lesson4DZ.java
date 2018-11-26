public class Lesson4DZ {

    public static void main(String[] args) {
        LinkedList list = new SimpleLinkedListImpl();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        displayAll(list);

        System.out.println("-----------");

        ListIterator iterator = (ListIterator) list.iterator();
        iterator.reset();//1! 2 3 4
        iterator.insertAfter(11);//1 11! 2 3 4
        iterator.next();//1 11 2! 3 4
        iterator.remove();//1 11 3! 4
        iterator.insertBefore(0);// 1 11 0! 3 4

        displayAll(list);
    }

    private static void displayAll(LinkedList list) {
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}