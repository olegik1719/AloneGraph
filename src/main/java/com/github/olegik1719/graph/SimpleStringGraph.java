package com.github.olegik1719.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SimpleStringGraph implements SimpleGraph<String> {

    private Map<String, Collection <String>> graph;

    public SimpleStringGraph(){
        graph = new HashMap<>();
    }

    @Override
    public SimpleStringGraph addVertex(String vertex) {
        graph.computeIfAbsent(vertex, s-> new HashSet<>());
        return this;
    }

    @Override
    public SimpleStringGraph addEdge(String begin, String end) {
        graph.computeIfAbsent(begin, s-> new HashSet<>()).add(end);
        graph.computeIfAbsent(end, s-> new HashSet<>()).add(begin);
        return this;
    }

    @Override
    public Collection<String> vertices() {
        return new HashSet<>(graph.keySet());
    }

    @Override
    public Collection<String> neighbours(String vertex) {
        return new HashSet<>(graph.get(vertex));
    }

    @Override
    public boolean isVertex(String vertex) {
        return graph.containsKey(vertex);
    }
}
