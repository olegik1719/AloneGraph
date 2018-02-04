package com.github.olegik1719.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public interface BFS<T> extends Graph<T> {
    default boolean isAccessible(T begin, T end){
        if (!isVertex(begin)||!isVertex(end))return false;
        if(begin.equals(end)) return true;
        Map<T,Boolean> notUsedBFS = new HashMap<>();
        vertices().forEach(t-> notUsedBFS.put(t,true));
        Queue<T> forCheck = new LinkedBlockingQueue();
        //Stack<T> forCheck = new Stack<>();
        T current = begin;
        forCheck.add(current);
        while (!(forCheck.isEmpty())){
            current = forCheck.poll();
            if (current.equals(end)) return true;
            if (notUsedBFS.put(current, false))
                getNeighbours(current).forEach(s -> {if(notUsedBFS.get(s))forCheck.add(s);});
        }
        return current.equals(end);
    }
}
