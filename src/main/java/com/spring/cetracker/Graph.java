package com.spring.cetracker;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Graph {

    List<List<Node>> adjList = new ArrayList<>();

    public Graph (){}

    public Graph(List<Edge1> edges) {

        for (int i = 0; i < edges.size(); i++) {
            adjList.add(i, new ArrayList<>());
        }

        for (Edge1 edge: edges) {
            if (edge.start < adjList.size()) {
                adjList.get(edge.start).add(new Node(edge.end, edge.weight));
            }
        }
    }

    public List<Edge1> randomizeGraph() {
        Random random = new Random();
        int edgeAmount = random.nextInt(10, 20);
        List<Edge1> edges = new LinkedList<>();

        while (edgeAmount > 0) {
            int start = random.nextInt(edgeAmount);
            int end = random.nextInt(edgeAmount);
            int weight = random.nextInt(1, 10);

            if (start != end){
                Edge1 edge1 = new Edge1(start, end, weight);
                edges.add(edge1);
            }
            edgeAmount--;
        }

        return edges;

    }

    public void printG(Graph graph) {
        int srcV = 0;
        int listSize = graph.adjList.size();

        while (srcV < listSize) {
            for (Node edge : graph.adjList.get(srcV)) {
                System.out.println("V" + srcV + "("+ graph.adjList.get(srcV).get(0).getCenter().isDistributes() +")" + " ==> " + "V" + edge.id + "("+ edge.getCenter().isDistributes() +")" + " " + "weight: " + edge.weight);
            }
            System.out.println();
            srcV++;
        }
    }

    static class Node {
        int id;
        int weight;
        Center center;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
            this.center = new Center("Centro " + id);
        }

        public Center getCenter() {
            return center;
        }
    }
}

class Edge1 {
    int start;
    int end;
    int weight;

    public Edge1(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
