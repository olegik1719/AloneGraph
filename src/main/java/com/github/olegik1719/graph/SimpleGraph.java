package com.github.olegik1719.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public interface SimpleGraph<T>{
    /**
     *
     * @param vertex
     * @return
     */

    boolean addVertex(T vertex);
    boolean addEdge(T begin, T end);

    Collection<T> vertices();
    Collection<T> neighbours(T vertex);

    boolean isVertex(T vertex);

    default boolean isNeighbour(T vertex, T neighbour){
        return neighbours(vertex).contains(neighbour);
    }

    default boolean isEdge(T begin, T end){
        return isNeighbour(begin,end);
    }

    default boolean isAccessible(T begin, T end){
        if (!isVertex(begin)||!isVertex(end))return false;
        if(begin.equals(end)) return true;
        Map<T,Boolean> notUsedDFS = new HashMap<>();
        vertices().forEach(t-> notUsedDFS.put(t,true));
        Stack<T> forCheck = new Stack<>();
        T current = begin;
        forCheck.push(current);
        while (!(forCheck.empty())){
            current = forCheck.pop();
            if (current.equals(end)) return true;
            if (notUsedDFS.put(current, false))
                neighbours(current).forEach(s -> {if(notUsedDFS.get(s))forCheck.push(s);});
        }
        return current.equals(end);
    }
}
