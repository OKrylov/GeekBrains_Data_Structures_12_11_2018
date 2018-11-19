package queue;

public interface Queue {

    void insert(int value);
    int remove();

    boolean isEmpty();
    boolean isFull();

    int getSize();
}
