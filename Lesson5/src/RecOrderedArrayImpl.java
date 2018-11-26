public class RecOrderedArrayImpl extends OrderedArrayImpl {

    private int indexOf(int value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (data[mid] == value) {
            return mid;
        }

        if (data[mid] < value) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }

        return indexOf(value, low, high);
    }

    @Override
    protected int indexOf(int value) {
        return indexOf(value, 0, currentSize - 1);
    }

    public static void main(String[] args) {
        Array arr = new RecOrderedArrayImpl();
        arr.add(4);
        arr.add(6);
        arr.add(2);
        arr.add(1);
        arr.add(5);
        arr.add(3);



        System.out.println(arr);

        System.out.println("Find 5: " + arr.find(5));
        System.out.println("Find 3: " + arr.find(3));
        System.out.println("Find 31: " + arr.find(31));
    }
}
