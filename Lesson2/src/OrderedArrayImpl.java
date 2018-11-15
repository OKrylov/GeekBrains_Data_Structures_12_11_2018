public class OrderedArrayImpl extends ArrayImpl implements Array {

    @Override
    public void add(int value) {
        int index;
        for (index = 0; index < currentSize; index++) {
            if (data[index] > value) {
                break;
            }
        }

        for (int i = currentSize; i > index; i--) {
            data[i] = data[i - 1];
        }


        data[index] = value;
        currentSize++;
    }

    @Override
    protected int indexOf(int value) {//O(log(N))
       int low, high;
       low = 0;
       high = currentSize - 1;

       while (low <= high) {
           int mid = (low + high) / 2;
           if (data[mid] == value) {
               return mid;
           }

           if (data[mid] < value) {
               low = mid + 1;
           }
           else {
               high = mid - 1;
           }
       }

       return -1;
    }
}
