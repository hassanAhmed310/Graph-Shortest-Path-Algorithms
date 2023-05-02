package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    static Graph graph;
    static String test = "B:\\test.txt";
    static String floydGraph = "B:\\floyd.txt";
    static String cycleGraph = "B:\\cycle.txt";
    static int[] costs;
    static int[] parents;
    static int[][] warshallCosts;
    static int[][] predecessors;
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
        predecessors = new int[4][4];
        warshallCosts = new int[4][4];
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
    @Test
    void testFloydWarshall(){
        var floyd = new Graph(floydGraph);
        floyd.floydWarshall(warshallCosts,predecessors);
        int[][] expectedCosts = {
                {0, 3, 7, 5},
                {2, 0, 6, 4},
                {3, 1, 0, 5},
                {5, 3, 2, 0}
        };
        int[][] expectedParents = {
                {-1, 0, 3, 0},
                {1, -1, 3, 1},
                {1, 2, -1, 1},
                {1, 2, 3, -1}
        };
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                assertEquals(expectedCosts[i][j],warshallCosts[i][j]);
                assertEquals(expectedParents[i][j],predecessors[i][j]);
            }
        }
    }
}