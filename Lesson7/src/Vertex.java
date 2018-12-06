public class Vertex {

    private final String label;
    private boolean isVisited;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}
