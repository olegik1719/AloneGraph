package com.github.olegik1719.graph;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class SimpleStringGraphTest {

    private static final String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};

    private StringGraph accessible = new StringGraph();
    private StringGraph unaccessible = new StringGraph();

    @Before
    public void setUp() throws Exception {
        accessible.addNeighbours(cities[0], cities[1], cities[2], cities[3])
            .addNeighbours(cities[1], cities[4], cities[5], cities[6])
            .addNeighbours(cities[7], cities[5]);
        unaccessible.addNeighbours(cities[0], cities[1], cities[2], cities[3])
            .addNeighbours(cities[1], cities[4], cities[5], cities[6])
            .addNeighbours(cities[7], cities[8])
            .addNeighbours(cities[8], cities[9])
            .addNeighbours(cities[10], cities[9]);
    }

    @Test
    public void isAccessible() {
        assertTrue(accessible.isAccessible(cities[0],cities[7]));
        assertFalse(unaccessible.isAccessible(cities[0],cities[7]));
    }


}