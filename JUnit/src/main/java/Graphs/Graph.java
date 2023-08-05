package Graphs;

import java.util.ArrayList;

public class Graph {

    public int v;
    private final ArrayList<Integer>[] verticesInfo;

    Graph(int v) {
        this.v = v;
        this.verticesInfo = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            verticesInfo[i] = new ArrayList<>();
        }

    }

    public void addEdge(int a, int b) {

        verticesInfo[a].add(b);
        verticesInfo[b].add(a);

    }

    public ArrayList<Integer> nexts(int v) {
        return verticesInfo[v];
    }

    public int[] vertices() {

        int[] vertices = new int[v];

        for (int i = 0; i < v; i++) {
            vertices[i] = 0;
        }

        return vertices;
    }

    public int size() {
        return v;
    }
}
