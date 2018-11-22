public class TwoSideLinkedListImpl extends SimpleLinkedListImpl implements TwoSideLinkedList {

    private Node lastElement;

    @Override
    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            firstElement = node;
        } else  {
            lastElement.setNextNode(node);
        }

        lastElement = node;
        currentSize++;
    }

    @Override
    public int getLast() {
        return lastElement != null ? lastElement.getValue() : -1;
    }

    @Override
    public void add(int value) {
        boolean empty = isEmpty();
        super.add(value);
        if (empty) {
            lastElement = firstElement;
        }
    }

    @Override
    public boolean remove(int value) {
        Node currentNode = this.firstElement;
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

        if (lastElement == currentNode) {
            lastElement = previousNode;
        }

        previousNode.setNextNode(currentNode.getNextNode());
        this.currentSize--;

        return true;
    }

    @Override
    public int remove() {
        if (firstElement != null && firstElement.getNextNode() == null) {
            lastElement = null;
        }
        return super.remove();
    }

}
