package queue;

public class PriorityQueue implements Queue {

    private int[] data;
    private int size;

    public PriorityQueue(int maxSize) {
        this.data = new int[maxSize];
    }

    @Override
    public void insert(int value) {
        if (isEmpty()) {
            data[size++] = value;
        }
        else {
            int index;
            for (index = size - 1; index >= 0; index--) {
                if (value > data[index]) {
                    data[index + 1] = data[index];
                }
                else {
                    break;
                }
            }

            data[index + 1] = value;
            size++;
        }
    }

    @Override
    public int remove() {
        return data[--size];
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
