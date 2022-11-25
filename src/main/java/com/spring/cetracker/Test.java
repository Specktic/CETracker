package com.spring.cetracker;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Graph graph = new Graph();
        Graph map = new Graph(graph.randomizeGraph());
        map.printG(map);

    }
}
