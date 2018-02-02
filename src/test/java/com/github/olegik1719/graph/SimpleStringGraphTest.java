package com.github.olegik1719.graph;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class SimpleStringGraphTest {

    private static final String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};

    private SimpleStringGraph accessible = new SimpleStringGraph();
    private SimpleStringGraph unaccessible = new SimpleStringGraph();

    @Before
    public void setUp() throws Exception {
        accessible.addEdges(cities[0], cities[1], cities[2], cities[3])
            .addEdges(cities[1], cities[4], cities[5], cities[6])
            .addEdges(cities[7], cities[5]);
        unaccessible.addEdges(cities[0], cities[1], cities[2], cities[3])
            .addEdges(cities[1], cities[4], cities[5], cities[6])
            .addEdges(cities[7], cities[8])
            .addEdges(cities[8], cities[9])
            .addEdges(cities[10], cities[9]);
    }

    @Test
    public void isAccessible() {
        assertTrue(accessible.isAccessible(cities[0],cities[7]));
        assertFalse(unaccessible.isAccessible(cities[0],cities[7]));
    }


}