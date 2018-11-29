public class Main6 {


    public static void main(String[] args) {
        Tree tree = new TreeImpl();
        tree.add(new Person(60, "Andrey"));
        tree.add(new Person(25, "Andrey"));
        tree.add(new Person(66, "Andrey"));
        tree.add(new Person(15, "Andrey"));
        tree.add(new Person(45, "Andrey"));
        tree.add(new Person(5, "Andrey"));
        tree.add(new Person(20, "Andrey"));
        tree.add(new Person(30, "Andrey"));
        tree.add(new Person(55, "Andrey"));
        tree.add(new Person(69, "Andrey"));
//        tree.add(new Person(61, "Andrey"));
        tree.add(new Person(32, "Andrey"));

        System.out.println("Find 15: " + tree.find(15));
        System.out.println("Find 25: " + tree.find(25));
        System.out.println("Find 75: " + tree.find(75));

//        tree.traverse(TraverseMode.IN_ORDER);
        tree.displayTree();
        tree.remove(25);
        tree.displayTree();

    }
}
