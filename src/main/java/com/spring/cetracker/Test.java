package com.spring.cetracker;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Graph map = graph.randomGraph();
        map.matchCenters();

        System.out.println("Centros: " + map.getCenters().length);
        System.out.println("Vertices: " + map.getVertices().length);

        System.out.println(map.getCenters()[1].isDistributes());
    }
}
