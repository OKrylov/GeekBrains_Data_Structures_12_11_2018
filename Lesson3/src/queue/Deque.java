package queue;

public interface Deque extends Queue {

    int removeLeft();
    void insertLeft(int value);

    int removeRight();
    void insertRight(int value);
}