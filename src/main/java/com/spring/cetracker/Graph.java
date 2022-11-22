package com.spring.cetracker;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<List<Node>> graphList = new ArrayList();

    public Graph(List<Edge> edges) {

    }

    static class Node {
        Center center;
        LinkList adjacency = new LinkList();

        public Node(Center center) {
            this.center = center;
        }

        public void addEdge(Edge edge) {
            adjacency.add(edge);
        }

        public LinkList getAdjacency() {return adjacency;}

        public Center getCenter() {return center;}

        public void setCenter(Center center) {this.center = center;}

    }

    static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
