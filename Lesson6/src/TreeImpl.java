import java.util.Stack;

public class TreeImpl implements Tree {

    private final class NodeAndParent {
        Node currentNode;
        Node parent;

        public NodeAndParent(Node currentNode, Node parent) {
            this.currentNode = currentNode;
            this.parent = parent;
        }
    }

    private Node root;


    @Override
    public void add(Person data) {
        NodeAndParent nodeAndParent = findLeafNode(data);
        Node parent = nodeAndParent.parent;

        Node newNode = new Node(data);

        if (parent == null) {
            root = newNode;
            return;
        }

        if (parent.isLeftChild(data.getId())) {
            parent.setLeftChild(newNode);
        } else {
            parent.setRightChild(newNode);
        }
    }

    public NodeAndParent findLeafNode(Person data) {
        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            current = current.getChild(data.getId());
        }
        return new NodeAndParent(null, parent);
    }

    @Override
    public Person remove(int id) {
        NodeAndParent nodeAndParent = findNodeAndParent(id);
        Node removedNode = nodeAndParent.currentNode;
        Node parent = nodeAndParent.parent;

        if (removedNode == null) {
            return null;
        }

        if (removedNode.isLeaf()) {
            removeLeafNode(removedNode, parent);
        }
        else if (removedNode.hasOnlyOneChildNode()) {
            removeNodeWithOneChild(removedNode, parent);
        }
        else {
            removeNodeWithBothChildren(removedNode, parent);
        }

        return removedNode.getData();
    }

    private void removeNodeWithBothChildren(Node removedNode, Node parent) {
        Node successor = getSuccessor(removedNode);
        successor.setLeftChild(removedNode.getLeftChild());
        if (removedNode == root) {
            root = successor;
        }
        else {
            if (parent.isLeftChild(removedNode.getKey())) {
                parent.setLeftChild(successor);
            }
            else {
                parent.setRightChild(successor);
            }
        }
    }

    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node.getRightChild();
        Node current = successor;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }

        return successor;

    }

    private void removeNodeWithOneChild(Node removedNode, Node parent) {
        Node removedChildNode = removedNode.getLeftChild() != null ? removedNode.getLeftChild() : removedNode.getRightChild();
        if (removedNode == root) {
            this.root = removedChildNode;
        } else if (parent.isLeftChild(removedNode.getKey())) {
            parent.setLeftChild(removedChildNode);
        } else {
            parent.setRightChild(removedChildNode);
        }
    }

    private void removeLeafNode(Node removedNode, Node parent) {
        if (removedNode == root) {
            root = null;
        }
        else if (parent.isLeftChild(removedNode.getKey())) {
            parent.setLeftChild(null);
        }
        else {
            parent.setRightChild(null);
        }
    }

    @Override
    public Person find(int id) {
        Node node = findNodeAndParent(id).currentNode;
        return node == null ? null : node.getData();
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER:
                inOrder(root);
                break;
            case PRE_ORDER:
                preOrder(root);
                break;
            case POST_ORDER:
                postOrder(root);
                break;
            default:
                throw new IllegalArgumentException("Unknown travers mode: " + mode);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeftChild());
            postOrder(root.getRightChild());
            displayNode(root);
        }
    }

    private void displayNode(Node root) {
        System.out.println(root.getData());
    }

    private void preOrder(Node root) {
        if (root != null) {
            displayNode(root);
            preOrder(root.getLeftChild());
            preOrder(root.getRightChild());
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeftChild());
            displayNode(root);
            inOrder(root.getRightChild());
        }

    }

    public NodeAndParent findNodeAndParent(int id) {
        Node current = root;
        Node parent = null;
        while (current != null) {
            if (id == current.getKey()) {
                return new NodeAndParent(current, parent);
            }
            parent = current;
            current = current.getChild(id);
        }

        return new NodeAndParent(null, parent);
    }

    @Override
    public void displayTree() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getKey());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
