package com.spring.cetracker;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Graph map = graph.randomGraph();
        map.makeCenters();

        System.out.println("Centros: " + map.getCenters().length);
        System.out.println("Vertices: " + map.getVertices().length);

        System.out.println("==========================================================================");

        map.printPaths(0, 4);



    }
}
