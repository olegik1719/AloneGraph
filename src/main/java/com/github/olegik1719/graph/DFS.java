package com.github.olegik1719.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public interface DFS<T> extends Graph<T> {

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
                getNeighbours(current).forEach(s -> {if(notUsedDFS.get(s))forCheck.push(s);});
        }
        return current.equals(end);
    }
}
