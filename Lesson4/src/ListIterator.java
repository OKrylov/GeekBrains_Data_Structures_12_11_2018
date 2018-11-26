import java.util.Iterator;

public interface ListIterator extends Iterator<Integer> {

    void reset();

    void insertBefore(int value);

    void insertAfter(int value);

}