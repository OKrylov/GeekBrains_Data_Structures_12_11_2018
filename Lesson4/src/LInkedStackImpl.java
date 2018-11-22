public class LInkedStackImpl implements Stack {

    private LinkedList linkedList;

    public LInkedStackImpl() {
        this.linkedList = new SimpleLinkedListImpl();
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

    @Override
    public void push(int value) {
        linkedList.add(value);
    }

    @Override
    public int pop() {
        return linkedList.remove();
    }

    @Override
    public int peek() {
        return linkedList.getFirstElement();
    }
}
