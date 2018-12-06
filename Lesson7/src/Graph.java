import java.util.*;

public class Graph {

    private List<Vertex> vertexes;
    private boolean[][] adjMat;

    private int size;

    public Graph(int maxSize) {
        this.vertexes = new ArrayList<>(maxSize);
        this.adjMat = new boolean[maxSize][maxSize];
        this.size = 0;
    }

    public void addVertex(String label) {
        vertexes.add(new Vertex(label));
        size++;
    }

    public boolean addEdge(String labelA, String labelB) {
        int indexA = indexOf(labelA);
        int indexB = indexOf(labelB);

        if (indexA == -1 || indexB == -1) {
            return false;
        }

        addEdge(indexA, indexB);
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            displayVertex(vertexes.get(i));
        }
    }

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexes.get(i).getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    private void addEdge(int indexA, int indexB) {
        adjMat[indexA][indexB] = true;
        adjMat[indexB][indexA] = true;
    }
    
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            return;
        }

        Vertex vertex = vertexes.get(startIndex);

        Stack<Vertex> stack = new Stack<>();

        visit(stack, vertex);

        while ( !stack.isEmpty() ) {
            vertex = getUnvisitedLinkedVertex(stack.peek());
            if (vertex != null) {
                visit(stack, vertex);
            }
            else {
                stack.pop();
            }
        }

        resetVertexStates();
    }

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            return;
        }

        Vertex vertex = vertexes.get(startIndex);

        Queue<Vertex> queue = new ArrayDeque<>();

        visit(queue, vertex);

        while ( !queue.isEmpty() ) {
            vertex = getUnvisitedLinkedVertex(queue.peek());
            if (vertex != null) {
                visit(queue, vertex);
            }
            else {
                queue.remove();
            }
        }

        resetVertexStates();
    }

    private void resetVertexStates() {
        for (int i = 0; i < size; i++) {
            vertexes.get(i).setVisited(false);
        }
    }

    private void visit(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        vertex.setVisited(true);
        stack.push(vertex);
    }

    private void visit(Queue<Vertex> queue, Vertex vertex) {
        displayVertex(vertex);
        vertex.setVisited(true);
        queue.add(vertex);
    }

    private Vertex getUnvisitedLinkedVertex(Vertex vertex) {
        int indexA = vertexes.indexOf(vertex);

        for (int indexB = 0; indexB < size; indexB++) {
            if (vertexes.get(indexB).isVisited())
                continue;

            if (adjMat[indexA][indexB]) {
                return vertexes.get(indexB);
            }
        }

        return null;
    }
}
