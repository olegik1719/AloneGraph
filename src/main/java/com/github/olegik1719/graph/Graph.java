package com.github.olegik1719.graph;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public interface Graph<T>{
    /**
     * Add vertex to graph structure
     *
     * @param vertex to adding
     * @return updated graph.
     */

    Graph<T> addVertex(T vertex);
    Graph<T> removeVertex(T vertex);
    Graph<T> addEdge(T begin, T end);
    Graph<T> RemoveEdge(T begin, T end);
    Collection<T> vertices();

    boolean isEdge(T begin, T end);


    default Collection<T> getNeighbours(T vertex){
        Collection<T> result = new HashSet<>(vertices());
        result.removeIf(neighbour -> !isEdge(vertex,neighbour));
        return result;
    }

    default boolean isVertex(T vertex){
        return vertices().contains(vertex);
    }

    default Graph<T> addNeighbours(T vertex, T... neighbours){
        Arrays.asList(neighbours)
                .forEach(neighbour -> addEdge(vertex,neighbour));
        return this;
    }
}
