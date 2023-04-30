package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTestTime3 {
    //test3   1000 V, 199800 E
    static Graph graph;
    static String test = "B:\\time\\test3.txt";
    static int[] costs;
    static int[] parents;
    static int[][] predecessors;
    static int[][] warshallCosts;
    long startTime, endTime;
    @BeforeAll
    static void init(){
        graph = new Graph(test);

    }
    @BeforeEach
    void initArrays(){
        costs = new int[1000];
        parents = new int[1000];
        predecessors = new int[1000][1000];
        warshallCosts = new int[1000][1000];
    }
    @Test
    void testTimeDijkstra(){
        startTime = System.nanoTime();
        graph.dijkstra(0,costs,parents);
        endTime = System.nanoTime();
        System.out.println("Time taken by Dijkstra = " + (endTime-startTime)/1000000 + " ms for input 1000 V, 199800 E");
    }
    @Test
    void testTimeBellmanFord(){
        startTime = System.nanoTime();
        graph.bellmanFord(0,costs,parents);
        endTime = System.nanoTime();
        System.out.println("Time taken by Bellman Ford = " + (endTime-startTime)/1000000 + " ms for input 1000 V, 199800 E");
    }
    @Test
    void testTimeFloydWarshall(){
        startTime = System.nanoTime();
        graph.floydWarshall(warshallCosts,predecessors);
        endTime = System.nanoTime();
        System.out.println("Time taken by Floyd Warshall = " + (endTime-startTime)/1000000 + " ms for input 1000 V, 199800 E");
    }
}
