import queue.Queue;

public class LinkedQueueImpl implements Queue {

    private TwoSideLinkedList linkedList;

    public LinkedQueueImpl() {
        this.linkedList = new TwoSideLinkedListImpl();
    }

    @Override
    public void insert(int value) {
        linkedList.addLast(value);
    }

    @Override
    public int remove() {
        return linkedList.remove();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }
}
