import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class TreeAppDZ {

    public static void main(String[] args) {
        Random rand = new Random();
        int treeCount = 20;
        int maxLevel = 6;
        int nodeCount = (int) (Math.pow(2, maxLevel) - 1);

        int maxValue = 100;

        int balancedTreeCount = 0;

        boolean treeView = false;

        for (int i = 0; i < treeCount; i++) {
            Tree theTree = new TreeImpl(maxLevel);
            initTree(rand, nodeCount, maxValue, theTree);
            if (theTree.isBalanced()) {
                balancedTreeCount++;
                if (!treeView) {
                    treeView = true;
                    theTree.displayTree();
                }
            }
        }

        TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getId).reversed());
        treeSet.add(new Person(5, "Oleg"));
        treeSet.add(new Person(3, "Oleg"));
        treeSet.add(new Person(9, "Oleg"));
        treeSet.add(new Person(2, "Oleg"));

        for (Person s : treeSet) {
            System.out.println(s);
        }


        System.out.println("Balanced Tree Count = " + ((balancedTreeCount / (treeCount * 1.0)) * 100) + "%");
    }

    private static void initTree(Random rand, int nodeCount, int maxValue, Tree theTree) {
        for (int j = 0; j < nodeCount; j++) {
            theTree.add(new Person(rand.nextInt(maxValue * 2 + 1) - maxValue, "Oleg"));
        }
    }
}
