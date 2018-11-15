import java.util.Arrays;

public class ArrayImpl implements Array {

    private static final int DEFAULT_CAPACITY = 16;

    protected int[] data;
    protected int currentSize;

    public ArrayImpl(int maxSize) {
        this.data = new int[maxSize];
//        this.currentSize = 0;
    }

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(int value) {//O(N)
        checkGrow();
        data[currentSize++] = value;
    }

    private void checkGrow() {
        if (currentSize == data.length) {
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

//            Arrays.copyOf(data, data.length * 2);

            data = temp;
        }
    }


    @Override
    public boolean remove(int value) {//O(N)
        int indexRemovedElement = indexOf(value);

        if ( indexRemovedElement == -1 ) {
            return false;
        }

        for (int i = indexRemovedElement; i < currentSize - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--currentSize] = value;
        return true;
    }

    @Override
    public boolean remove() {
        if ( !isEmpty() ) {
            currentSize--;
            return true;
        }

        return false;
    }

    @Override
    public boolean find(int value) {
        return indexOf(value) != -1;
    }

    protected int indexOf(int value) {//O(N)
        for (int i = 0; i < currentSize; i++) {
            if ( data[i] == value ) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public int get(int index) {//O(1)
        if (index < currentSize && index > -1) {
            return data[index];
        }

        throw new IllegalArgumentException("Invalid index value: " + index);
    }

    @Override
    public void sortBubble() {//O(N^2)
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    exchange(j, j + 1);
                }
            }
        }
    }


    @Override
    public void sortSelect() {//O(N^2)
        for (int i = 0; i < currentSize - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentSize; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            exchange(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        int in, out;
        for (out = 1; out < currentSize; out++) {
            int temp = data[out];
            in = out;
            while (in > 0 && data[in - 1] >= temp) {
                data[in] = data[in - 1];
                in--;
            }

            data[in] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < currentSize; i++) {
            sb.append(data[i] + " ");
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }


    private void exchange(int left, int right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
    }


}
