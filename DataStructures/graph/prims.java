package DataStructures.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class prims {
    
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGrpah(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 15));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 45));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    public static void PrimsAlgo(ArrayList<Edge> graph[],int V){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        boolean visited[] = new boolean[V];
        pq.add(new Pair(0, 0));
        int mstCost = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;
                mstCost += curr.cost;
                for(Edge e: graph[curr.node]){
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
            
        }
        System.out.println("Minimum Spanning Tree cost is: " + mstCost);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGrpah(graph);
        PrimsAlgo(graph, V);
    }
}
