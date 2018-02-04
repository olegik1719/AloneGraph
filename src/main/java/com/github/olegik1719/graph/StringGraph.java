package com.github.olegik1719.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringGraph implements Graph<String>, BFS<String>, Dijkstra<String>{

    private Map<String, Collection <String>> graph;

    public StringGraph(){
        graph = new HashMap<>();
    }

    @Override
    public StringGraph addVertex(String vertex) {
        graph.computeIfAbsent(vertex, s-> new HashSet<>());
        return this;
    }

    @Override
    public Graph<String> removeVertex(String vertex) {
        graph.remove(vertex);
        return this;
    }

    @Override
    public StringGraph addEdge(String begin, String end) {
        graph.computeIfAbsent(begin, s-> new HashSet<>()).add(end);
        graph.computeIfAbsent(end, s-> new HashSet<>()).add(begin);
        return this;
    }

    @Override
    public Graph<String> RemoveEdge(String begin, String end) {
        graph.get(begin).remove(end);
        graph.get(end).remove(begin);
        return this;
    }

    @Override
    public Collection<String> vertices() {
        return new HashSet<>(graph.keySet());
    }

    @Override
    public Collection<String> getNeighbours(String vertex) {
        return new HashSet<>(graph.get(vertex));
    }

    @Override
    public boolean isEdge(String begin, String end) {
        return isVertex(begin) && graph.get(begin).contains(end);
    }

    @Override
    public boolean isVertex(String vertex) {
        return graph.containsKey(vertex);
    }
}
