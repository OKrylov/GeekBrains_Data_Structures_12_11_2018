import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {
//        testArray();
        testMyArray();

//        testArrayList();
    }

    private static void testArrayList() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("2");
        arrayList.add("5");

        for (String s : arrayList) {
            System.out.println(s);
        }

        arrayList.remove(0);
        arrayList.remove("2");
    }

    private static void testMyArray() {
        Array arr = new ArrayImpl();
//        Array arr = new OrderedArrayImpl();
        arr.add(6);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(2);
        arr.add(1);

//        Arrays.sort();


        System.out.println(arr);
//        arr.sortBubble();
//        arr.sortSelect();
        arr.sortInsert();
        System.out.println(arr);

        Random r = new Random();

        long start= System.nanoTime();
//        TimeUnit.NANOSECONDS.toMillis(start);

//        System.out.println("Find 3:" + arr.find(3));
//        System.out.println("Find 33:" + arr.find(33));
//
//        System.out.println("Remove 2:" + arr.remove(2));
//        System.out.println("Find 2:" + arr.find(2));
//        System.out.println(arr);
    }

    private static void testArray() {
        //        int[] a = new int[5];
//        a[0] = 1;
//        a[1] = 2;
//        ...
//        int[] a = new int[] {1, 2, 3, 4, 5};
//        int[] a = {1, 2, 3, 4, 5};
        int[][] a = {{1, 2}, {3, 4, 5}};


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
