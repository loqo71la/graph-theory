package dev.loqo71la.graphtheory.graph;

import dev.loqo71la.graphtheory.Edge;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Implement a graph using an adjacency list to represent vertices and edges.
 *
 * @param <T> Type of the Vertex.
 */
public class AdjacencyListGraph<T> implements Graph<T> {

    private static final String NOT_FOUND = "Vertex '%s' was not found";
    private static final double DEFAULT_WEIGHT = 1;
    private final Map<T, List<Edge<T>>> vertices;

    /**
     * Default constructor to initialize the vertices.
     */
    public AdjacencyListGraph() {
        vertices = new LinkedHashMap<>();
    }

    /**
     * Returns the list of added vertices.
     *
     * @return the list of vertices.
     */
    @Override
    public List<T> getVertices() {
        return new ArrayList<>(vertices.keySet());
    }

    /**
     * Adds a vertex to the graph.
     *
     * @param vertex to be added.
     */
    @Override
    public void addVertex(T vertex) {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, new LinkedList<>());
        }
    }

    /**
     * Returns the list of edges for a specified vertex.
     *
     * @param vertex to be evaluated.
     * @return the list of edges.
     */
    @Override
    public List<Edge<T>> getEdges(T vertex) {
        validateVertex(vertex);
        return vertices.get(vertex);
    }

    /**
     * Adds an edge between the source and target vertices of the graph.
     *
     * @param source source vertex.
     * @param target target vertex.
     */
    @Override
    public void addEdge(T source, T target) {
        addEdge(source, target, DEFAULT_WEIGHT);
    }

    /**
     * Adds a weighted edge between the source and target vertices of the graph.
     *
     * @param source source vertex.
     * @param target target vertex.
     * @param weight weight of the edge.
     */
    @Override
    public void addEdge(T source, T target, double weight) {
        validateVertex(source);
        validateVertex(target);

        if (vertices.get(source).stream().noneMatch(edge -> edge.getTarget().equals(target))) {
            vertices.get(source).add(new Edge<>(target, weight));
        }
    }

    /**
     * Validates if the vertex is contained in the graph.
     *
     * @param vertex to be evaluated
     */
    private void validateVertex(T vertex) {
        if (!vertices.containsKey(vertex)) {
            throw new InvalidParameterException(String.format(NOT_FOUND, vertex.toString()));
        }
    }
}
