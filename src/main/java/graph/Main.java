package graph;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to graph file: ");
        String path = scanner.nextLine();
        Graph g = new Graph(path);

        int[] costs = new int[g.size()];
        int[] parents = new int[g.size()];
        boolean result;

        // Test Dijkstra's algorithm
        int source = 0;
        //int[] costs = new int[g.size()];
        //int[] parents = new int[g.size()];
        g.dijkstra(source, costs, parents);
        System.out.println("Dijkstra's algorithm results:");
        System.out.println("Costs: " + Arrays.toString(costs));
        System.out.println("Parents: " + Arrays.toString(parents));

        // Test Bellman-Ford algorithm
        //int[] costs2 = new int[g.size()];
        //int[] parents2 = new int[g.size()];
        boolean hasNegativeCycle = g.bellmanFord(source, costs, parents);
        System.out.println("bellmanFord's algorithm results:");
        if (hasNegativeCycle) {
            System.out.println("No negative cycle found");
            System.out.println("Costs: " + Arrays.toString(costs));
            System.out.println("Parents: " + Arrays.toString(parents));
        } else {
            System.out.println("Negative cycle found");
        }

        // Floyd-Warshall algorithm
        int[][] costsMatrix = new int[g.size()][g.size()];
        int[][] predecessorsMatrix = new int[g.size()][g.size()];
        result = g.floydWarshall(costsMatrix, predecessorsMatrix);
        if (result) {
            for (int i = 0; i < g.size(); i++) {
                for (int j = 0; j < g.size(); j++) {
                    System.out.print(costsMatrix[i][j] + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < g.size(); i++) {
                for (int j = 0; j < g.size(); j++) {
                    System.out.print(predecessorsMatrix[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Negative cycle found");
        }
    }
}
