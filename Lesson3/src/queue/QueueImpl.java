package queue;

public class QueueImpl implements Queue {

    public static final int DEFAULT_FRONT = 0;
    public static final int DEFAULT_REAR = -1;

    protected int[] data;
    protected int size;

    protected int front;
    protected int rear;

    public QueueImpl(int maxSize) {
        this.data = new int[maxSize];
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    @Override
    public void insert(int value) {
        if (rear == data.length - 1) {
            rear = DEFAULT_REAR;
        }

        data[++rear] = value;
        size++;
    }

    @Override
    public int remove() {
        int temp = data[front++];

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }

        size--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }
}
