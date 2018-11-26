public class LinkedListIterator implements ListIterator {

    private SimpleLinkedListImpl list;
    private boolean firstIterate = true;

    private Node current;
    private Node previous;

    public LinkedListIterator(SimpleLinkedListImpl list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (firstIterate) {
            firstIterate = false;
            return list.getFirstNode() != null;
        }
        else {
            return current.getNextNode() != null;
        }
    }

    @Override
    public Integer next() {
        if (current == null) {
            current = list.getFirstNode();
        }
        else {
            previous = current;
            current = current.getNextNode();
        }
        return current.getValue();
    }

    @Override
    public void remove() {
        if (previous == null){
            list.setFirstNode(current.getNextNode());
            reset();
        } else {
            previous.setNextNode(current.getNextNode());
            if ( !hasNext() ) {
                reset();
            } else {
                current = current.getNextNode();
            }
        }
    }

    @Override
    public void reset() {
        firstIterate = false;
        current = list.getFirstNode();
        previous = null;
    }

    @Override
    public void insertBefore(int value) {
        Node newItem = new Node(value);
        if(previous == null) {
            newItem.setNextNode(list.getFirstNode());
            list.setFirstNode(newItem);
            reset();
        }
        else {
            newItem.setNextNode(previous.getNextNode());
            previous.setNextNode(newItem);
            current = newItem;
        }

    }

    @Override
    public void insertAfter(int value) {
        Node newItem = new Node(value);
        if (list.isEmpty()){
            list.setFirstNode(newItem);
            current = newItem;
        } else {
            newItem.setNextNode(current.getNextNode());
            current.setNextNode(newItem);
            next();
        }
    }

}