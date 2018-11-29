public class Node {

    private final Person data;

    private Node leftChild;
    private Node rightChild;


    public Node(Person data) {
        this.data = data;
    }

    public Person getData() {
        return data;
    }

    public int getKey() {
        return data.getId();
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getChild(int key) {
        if (isLeftChild(key)) {
            return getLeftChild();
        }
        else {
            return getRightChild();
        }
    }

    public boolean isLeftChild(int key) {
        return key < getKey();
    }

    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    public boolean hasOnlyOneChildNode() {
        return !isLeaf() && (getLeftChild() == null || getRightChild() == null);
    }
}
