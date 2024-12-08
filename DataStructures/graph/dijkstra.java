package DataStructures.graph;

import java.util.*;

public class dijkstra {
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

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 2, 5));
    }

    public static class Pair implements Comparable<Pair>{ 
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p) {
            return this.dist - p.dist; // ascending order
            //return p.node - this.dist; // descending order 
        }

    }
    //TC = O(E + ElogV)
    //ElogV for priority queue
    public static void shortestPath(ArrayList<Edge> graph[], int src, int V){
        int dist[] = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < V; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean visited[] = new boolean[V];

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node] = true;

                for(Edge e : graph[curr.node]){
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] +e.wt < dist[v]){
                        dist[v] = dist[u] + e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.println("Vertex " + i + " -> Distance from Source: " + dist[i]);
        }    

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGrpah(graph);

        shortestPath(graph, 0, v);
    }
}
