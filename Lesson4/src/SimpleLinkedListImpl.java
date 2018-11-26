import java.util.Iterator;

public class SimpleLinkedListImpl implements LinkedList {

    protected Node firstElement;//null
    protected int currentSize;

    @Override
    public void add(int value) {
        Node node = new Node(value);//001
        node.setNextNode(firstElement);//null
        firstElement = node;//001
        currentSize++;
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            return -1;
        }

        int removedValue = firstElement.getValue();
        firstElement = firstElement.getNextNode();

        currentSize--;
        return removedValue;
    }

    @Override
    public boolean remove(int value) {
        Node currentNode = firstElement;
        Node previousNode = null;

        while (currentNode != null) {
            if (value == currentNode.getValue()) {
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        if (currentNode == null) {
            return false;
        }

        previousNode.setNextNode(currentNode.getNextNode());
        currentSize--;
        return true;
    }

    @Override
    public boolean find(int value) {
        Node currentNode = firstElement;

        while (currentNode != null) {
            if (value == currentNode.getValue()) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0 || firstElement == null;
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public void display() {
        Node currentNode = firstElement;

        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public int getFirstElement() {
        return firstElement != null ? firstElement.getValue() : null;
    }

    public Node getFirstNode() {
        return firstElement;
    }

    public void setFirstNode(Node node) {
        firstElement = node;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new LinkedListIterator(this);
    }
}
