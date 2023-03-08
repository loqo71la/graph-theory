package dev.loqo71la.graphtheory.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdjacencyListGraphTest {
    private Graph<Character> graph;

    @BeforeEach
    public void setup() {
        graph = new AdjacencyListGraph<>();
    }


    @Test
    public void getVertices_byDefault_ReturnsAnEmptyList() {
        assertTrue(graph.getVertices().isEmpty());
    }

    @Test
    public void getVertices_WithASpecialOrder_ReturnsAListInTheSameOrder() {
        graph.addVertex('A');
        graph.addVertex('D');
        graph.addVertex('B');

        assertEquals(Arrays.asList('A', 'D', 'B'), graph.getVertices());
        assertNotEquals(Arrays.asList('A', 'B', 'D'), graph.getVertices());
        assertNotEquals(Arrays.asList('a', 'd', 'b'), graph.getVertices());
    }

    @Test
    public void addEdge_WithoutSourceVertex_ThrowsAnInvalidParameterException() {
        Exception exception = assertThrows(RuntimeException.class, () -> graph.addEdge('B', 'C'));

        assertEquals("Vertex 'B' was not found", exception.getMessage());
    }

    @Test
    public void addEdge_WithoutTargetVertex_ThrowsAnInvalidParameterException() {
        graph.addVertex('A');
        Exception exception = assertThrows(RuntimeException.class, () -> graph.addEdge('A', 'D'));

        assertEquals("Vertex 'D' was not found", exception.getMessage());
    }

    @Test
    public void getEdges_WithoutVertices_ThrowsAnInvalidParameterException() {
        Exception exception = assertThrows(RuntimeException.class, () -> graph.getEdges('A'));

        assertEquals("Vertex 'A' was not found", exception.getMessage());
    }

    @Test
    public void getEdges_WithAnUnassignedVertex_ReturnsAnEmptyList() {
        graph.addVertex('A');
        assertTrue(graph.getEdges('A').isEmpty());
    }

    @Test
    public void getEdges_WithAnAssignedVertex_ReturnsAListOfEdges() {
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C', 2.4);
        graph.addEdge('B', 'C', 1.5);

        // A -> (B, 1), (C, 2.4)
        assertEquals(2, graph.getEdges('A').size());
        // .. (B, 1)
        assertEquals('B', graph.getEdges('A').get(0).getTarget());
        assertEquals(1, graph.getEdges('A').get(0).getWeight());
        // .. (C, 2.4)
        assertEquals('C', graph.getEdges('A').get(1).getTarget());
        assertEquals(2.4, graph.getEdges('A').get(1).getWeight());

        // B -> (C, 1.5)
        assertEquals(1, graph.getEdges('B').size());
        // .. (C, 1.5)
        assertEquals('C', graph.getEdges('B').get(0).getTarget());
        assertEquals(1.5, graph.getEdges('B').get(0).getWeight());

        // C -> _
        assertEquals(Collections.emptyList(), graph.getEdges('C'));
    }
}
