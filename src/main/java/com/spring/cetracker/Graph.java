package com.spring.cetracker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {
    List<List<Node>> graphList = new ArrayList();

    public Graph(List<Edge> edges) {
        for (int i = 0; i < edges.size(); i++) {
            graphList.add(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            graphList.get(e.start).add(new Node(e.end, e.weight));
        }
    }

    static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
