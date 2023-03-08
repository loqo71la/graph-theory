package dev.loqo71la.graphtheory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EdgeTest {
    private Edge<Integer> edge;

    @BeforeEach
    public void setup() {
        edge = new Edge<>(0, 0);
    }

    @Test
    public void hashCode_WithZeroValue_ReturnsTheDefaultHashCode() {
        // Based on Arrays.hashCode(..) default prime value = 31
        assertEquals(961, edge.hashCode());
    }

    @Test
    public void equals_AfterUpdatingTarget_ReturnsTheValidation() {
        Edge<Integer> secondEdge = new Edge<>(14, 2.4);
        assertNotEquals(edge, secondEdge);

        edge.setTarget(14);
        edge.setWeight(2.4);
        assertEquals(edge, secondEdge);
    }
}
