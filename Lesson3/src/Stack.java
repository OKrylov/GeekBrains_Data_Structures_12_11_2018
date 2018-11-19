public interface Stack {

    boolean isEmpty();
    boolean isFull();

    int getSize();

    void push(int value);

    int pop();

    int peek();

}
