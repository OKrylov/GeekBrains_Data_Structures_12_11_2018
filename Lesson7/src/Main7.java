public class Main7 {

    public static void main(String[] args) {
        testA();

        testDfs();
        testBfs();



    }

    private static void testBfs() {
        Graph graph = new Graph(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "E");
        graph.addEdge("E", "H");

        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        System.out.println("---bfs---");
        graph.bfs("A");
    }

    private static void testDfs() {
        Graph graph = new Graph(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "E");

        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        System.out.println("--- DFS ---");
        graph.dfs("A");
    }

    private static void testA() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");

        System.out.println(graph.addEdge("Москва", "Тула"));
        System.out.println(graph.addEdge("Москва", "Тулула"));

        graph.display();
    }
}
