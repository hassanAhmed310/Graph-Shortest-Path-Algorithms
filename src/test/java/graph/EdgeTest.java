package graph;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class EdgeTest {
    static private Edge edge;
    static Random random;
    static int src, destination, weight;
    @BeforeAll
    static void init(){
        random = new Random();
        src = random.nextInt();
        destination = random.nextInt();
        weight = random.nextInt();
        edge = new Edge(src, destination, weight);
    }
    @Test
    void testSourceConstruction(){
        System.out.println("Random source = "+ src + ", Already Created = " + edge.src);
        assertEquals(src, edge.src);
    }
    @Test
    void testDestinationConstruction(){
        System.out.println("Random destination = "+ destination + ", Already Created = " + edge.dest);
        assertEquals(destination, edge.dest);
    }
    @Test
    void testWeightConstruction(){
        System.out.println("Random weight = "+ weight + ", Already Created = " + edge.weight);
        assertEquals(weight, edge.weight);
    }

}