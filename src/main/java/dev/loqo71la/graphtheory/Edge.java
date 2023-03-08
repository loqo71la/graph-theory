package dev.loqo71la.graphtheory;

import java.util.Objects;

/**
 * Implements the edge between two vertices of a graph.
 *
 * @param <T> Type of the target Vertex.
 */
public class Edge<T> {

    /**
     * Stores the target vertex.
     */
    private T target;

    /**
     * Stores the weight of the edge.
     */
    private double weight;

    /**
     * Default constructor to initialize the properties.
     *
     * @param target target vertex.
     * @param weight weight of the edge.
     */
    public Edge(T target, double weight) {
        this.target = target;
        this.weight = weight;
    }

    /**
     * Return the value of the 'target' property.
     *
     * @return the target vertex.
     */
    public T getTarget() {
        return target;
    }

    /**
     * Sets the value of the 'target' property.
     *
     * @param target to be set.
     */
    public void setTarget(T target) {
        this.target = target;
    }

    /**
     * Return the value of the 'weight' property.
     *
     * @return the weight of the edge.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the 'weight' property.
     *
     * @param weight to be set.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns the hash code of all properties of an edge.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(weight, target);
    }

    /**
     * Returns true if all properties of an edge are equal to each other, otherwise false.
     *
     * @param other to be evaluated
     * @return true if equal, otherwise false.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return Boolean.TRUE;
        }
        if (!(other instanceof Edge<?>)) {
            return Boolean.FALSE;
        }
        Edge<?> edge = (Edge<?>) other;
        return weight == edge.weight && target.equals(edge.target);
    }
}
