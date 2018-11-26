public interface LinkedList extends Iterable<Integer> {

    void add(int value);

    boolean remove(int value);

    int remove();

    boolean find(int value);

    boolean isEmpty();

    int getSize();

    void display();

    int getFirstElement();

}
