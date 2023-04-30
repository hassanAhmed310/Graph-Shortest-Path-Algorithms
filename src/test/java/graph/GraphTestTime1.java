package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTestTime1 {
    //test1   500 V, 74850 E
    static Graph graph;
    static String test = "B:\\time\\test1.txt";
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
        costs = new int[500];
        parents = new int[500];
        predecessors = new int[500][500];
        warshallCosts = new int[500][500];
    }
    @Test
    void testTimeDijkstra(){
        startTime = System.nanoTime();
        graph.dijkstra(0,costs,parents);
        endTime = System.nanoTime();
        System.out.println("Time taken by Dijkstra = " + (endTime-startTime)/1000000 + " ms for input 500 V, 74850 E");
    }
    @Test
    void testTimeBellmanFord(){
        startTime = System.nanoTime();
        graph.bellmanFord(0,costs,parents);
        endTime = System.nanoTime();
        System.out.println("Time taken by Bellman Ford = " + (endTime-startTime)/1000000 + " ms for input 500 V, 74850 E");
    }
    @Test
    void testTimeFloydWarshall(){
        startTime = System.nanoTime();
        graph.floydWarshall(warshallCosts,predecessors);
        endTime = System.nanoTime();
        System.out.println("Time taken by Floyd Warshall = " + (endTime-startTime)/1000000 + " ms for input 500 V, 74850 E");
    }
}