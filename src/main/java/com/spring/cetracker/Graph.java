package com.spring.cetracker;

import java.util.*;

public class Graph {
    private Center[] centers;

    private int vertices;
    private ArrayList<Integer>[] adjMatrix;

    public Graph () {}

    public Graph(int vertices) {
        this.vertices = vertices;
        initializeMatrix();
    }

    private void initializeMatrix() {
        adjMatrix = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjMatrix[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight) {
        adjMatrix[start].add(end);
    }

    public void printPaths(int start, int end) {
        boolean[] isVisited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(start);
        printPathsUtil(start, end, isVisited, pathList);
    }

    private void printPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
        if (u.equals(d)) {
            System.out.println(localPathList);
            return;
        }
        isVisited[u] = true;
        for (Integer i : adjMatrix[u]) {
            if (!isVisited[i]) {
                if (!localPathList.contains(i)) {
                    localPathList.add(i);
                }
                printPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[u] = false;
    }






















    //Utility methods

    public Graph randomGraph(){
        Random random = new Random();
        int graphSize = random.nextInt(10, 20);

        Graph map = new Graph(graphSize);

        for (int i = 0; i < (graphSize * 3); i++) {
            int start = random.nextInt(graphSize);
            int end = random.nextInt(graphSize);
            int weight = random.nextInt(1, 10);

            if (end != start){
                map.addEdge(start, end, weight);
            }
        }
        return map;
    }

    public void makeCenters() {
        setCenters(new Center[adjMatrix.length]);

        for (int i = 0; i < adjMatrix.length; i++) {
            centers[i] = new Center("Ciudad " + i);
        }
    }

    //Getters and setters
    public Center[] getCenters() {return centers;}
    public void setCenters(Center[] centers) {this.centers = centers;}

    public ArrayList<Integer>[] getVertices() {return adjMatrix;}

    //Vertex class
    class Vertex {
        int id;
        LinkedList adjacency = new LinkedList();

        public Vertex(int id) {
            this.id = id;
        }

        public LinkedList getAdjacency() {return adjacency;}
        public int getId() {return id;}
    }

    //Edge class
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
