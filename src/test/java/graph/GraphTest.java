package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    static Graph graph;
    static String test = "B:\\test.txt";
    static String cycleGraph = "B:\\cycle.txt";
    static int[] costs;
    static int[] parents;
    long startTime, endTime;
    @BeforeAll
    static void init(){
        graph = new Graph(test);
    }
    @Test
    void testCorrectSize(){
        assertEquals(8, graph.size());
    }
    @BeforeEach
    void initializeCostsAndParentsArrays(){
        costs = new int[8];
        parents = new int[8];
        for (int i=0;i<8;i++){
            costs[i] = Integer.MAX_VALUE;
            parents[i] = -1;
        }
    }
    @Test
    void testDijkstra(){
        graph.dijkstra(0,costs,parents);
        int[] expectedCosts = {0, 5, 2, 6, 4, 9, 13, 13};
        int[] expectedParents = {-1, 0, 0, 1, 0, 1, 4, 5};
        for(int i=0;i<8;i++){
            assertEquals(expectedCosts[i],costs[i]);
            assertEquals(expectedParents[i], parents[i]);
        }
    }
    @Test
    void testBellmanFord(){
        graph.bellmanFord(0,costs,parents);
        int[] expectedCosts = {0, 5, 2, 6, 4, 9, 13, 13};
        int[] expectedParents = {-1, 0, 0, 1, 0, 1, 4, 5};
        for(int i=0;i<8;i++){
            assertEquals(expectedCosts[i],costs[i]);
            assertEquals(expectedParents[i], parents[i]);
        }
    }
    @Test
    void testBellmanFordCycle(){
        var cycle = new Graph(cycleGraph);
        var cost = new int[4];
        var parent = new int[4];
        assertFalse(cycle.bellmanFord(0,cost,parent));
    }
}