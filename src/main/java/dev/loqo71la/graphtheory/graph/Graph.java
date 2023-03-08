package dev.loqo71la.graphtheory.graph;

import dev.loqo71la.graphtheory.Edge;

import java.util.List;

/**
 * Implements a mathematical graph definition.
 *
 * @param <T> Type of the Vertex.
 */
public interface Graph<T> {

    /**
     * Returns the list of added vertices.
     *
     * @return the list of vertices.
     */
    List<T> getVertices();

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex to be added.
     */
    void addVertex(T vertex);

    /**
     * Returns the list of edges for a specified vertex.
     *
     * @param vertex to be evaluated.
     * @return the list of edges.
     */
    List<Edge<T>> getEdges(T vertex);

    /**
     * Adds an edge between the source and target vertices of the graph.
     *
     * @param source source vertex.
     * @param target target vertex.
     */
    void addEdge(T source, T target);

    /**
     * Adds a weighted edge between the source and target vertices of the graph.
     *
     * @param source source vertex.
     * @param target target vertex.
     * @param weight weight of the edge.
     */
    void addEdge(T source, T target, double weight);
}
