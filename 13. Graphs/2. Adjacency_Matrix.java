class Adjacency_Matrix {
    private int[][] adjMatrix;
    private int numVertices;

    public Adjacency_Matrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;  // Uncomment this for an undirected graph
    }

    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Adjacency_Matrix graph = new Adjacency_Matrix(4);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        graph.printMatrix();
    }
}
