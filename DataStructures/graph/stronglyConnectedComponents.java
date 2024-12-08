package DataStructures.graph;

import java.util.ArrayList;
import java.util.Stack;

public class stronglyConnectedComponents {
    

    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGrpah(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean[] visited, Stack<Integer> stk){
        visited[curr] = true;
        for(Edge e : graph[curr]){
            if(!visited[e.dest]){
                topologicalSort(graph, e.dest, visited, stk);
            }
        }
        stk.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visited){
        visited[curr] = true;
        System.out.print(curr + " ");
        for(Edge e : graph[curr]){
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    @SuppressWarnings({"unchecked" })

    public static void kosarajuAlgo(ArrayList<Edge> graph[], int V){
        //step - 1 O(E+V)
        Stack<Integer> stk = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topologicalSort(graph, i, visited, stk);
            }
        }

        //step - 2 O(E+V)
        ArrayList<Edge> revGraph[] = new ArrayList[V];
        for(int i=0;i<V;i++){
            visited[i] = false;
            revGraph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(Edge e : graph[i]){
                revGraph[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step - 3 O(E+V)
        while (!stk.isEmpty()) {
            int curr = stk.pop();
            if(!visited[curr]){
                dfs(revGraph, curr, visited);
            }
            System.out.println();
        }
    }

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGrpah(graph);
        kosarajuAlgo(graph, V);
        
    }
}
