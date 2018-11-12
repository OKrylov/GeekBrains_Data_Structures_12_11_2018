public class Main1 {

    private static int globalA;
    private static String globalStr;

    public static void main(String[] args) {
        int a = 5;
        System.out.println(a);

        String str = "str1";
        System.out.println(str);

        Main1 m = new Main1();

        int b = 10;
        System.out.println("a == b?");
        System.out.println(a == b);
        a = b;
        System.out.println(a == b);

//        String str1 = new String("1");
//        String str1 = new String("2");//001
//        String str2 = new String("2");//002
        String str1 = "2";
        String str2 = "2";

        System.out.println("str1 == str2?");
        System.out.println(str1 == str2);//001 == 002
        System.out.println(str1.equals(str2));//001 == 002
        str1 = str2;
        System.out.println(str1 == str2);//002 == 002

        System.out.println("Test Person");

        String str3 = str1.replace("2", "3");
        System.out.println(str1);
        System.out.println(str3);

        Person p1 = new Person("Petr", 32);
        Person p2 = new Person("Petr", 32);

        System.out.println(p1.equals(p2));
//        Person p2 = new Person("Olga", 28);

//        System.out.println(p1.getName());
//        System.out.println(p2.getName());
//
//        System.out.println(p1 == p2);
//        p1 = p2;
//
//
//        System.out.println(p1.getName());
//        System.out.println(p2.getName());
//
//        p1.setName("Alex");
//
//        System.out.println(p1.getName());
//        System.out.println(p2.getName());

        System.out.println("testPrimitive");
        int c = 7;
        System.out.println("Before c = " + c);
        c = testPrimitive(c);
        System.out.println("After c = " + c);


        System.out.println("testObject");
        Person p = new Person("Oleg", 29);
        System.out.println("Before p = " + p);
        testObject(p);
        System.out.println("After p = " + p);



    }

    private static void testObject(Person p) {
//        p = new Person("Petr", 32);
        p.setAge(18);
        System.out.println(p);
    }

    private static int testPrimitive(int c) {
        c = 10;
        System.out.println(c);
        return c;
    }
}
