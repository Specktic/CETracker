package com.spring.cetracker;

import java.util.Random;

public class Graph {
    private Vertex[] vertices;

    public Graph(int a) {
        vertices = new Vertex[a];

        for (int i = 0; i < a; i++) {
            vertices[i] =new Vertex(i);
        }
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        vertices[start].addEdge(edge);
    }

    public Graph randomGraph(){
        Random random = new Random();
        int graphSize = random.nextInt(5, 20);

        Graph map = new Graph(graphSize);

        for (int i = 0; i < graphSize; i++) {
            int start = random.nextInt(graphSize);
            int end = random.nextInt(graphSize);
            int weight = random.nextInt(1, 10);

            map.addEdge(start, end, weight);
        }

        return map;
    }

    static class Vertex {
        int id;
        Center center;
        LinkList adjacency = new LinkList();

        public Vertex(int id) {
            this.id = id;
        }

        public void addEdge(Edge edge) {
            adjacency.add(edge);
        }

        public Center getCenter() {return center;}
        public LinkList getAdjacency() {return adjacency;}
        public int getId() {return id;}
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
