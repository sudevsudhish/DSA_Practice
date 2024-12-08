package DataStructures.graph;

import java.util.ArrayList;

public class articulationPoint {

    public static class Edge{
        int src, dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }

    public static void dfs(ArrayList<Edge> graph[], int curr,int parent, int[] discovoryTime, int[] lowestTime,boolean[] visited, int time, boolean[] articulationPoint ){
        visited[curr] = true;
        discovoryTime[curr] = lowestTime[curr] = ++time;
        int children =0;

        for(Edge e : graph[curr]){
            if(parent == e.dest){
                continue;
            }else if(visited[e.dest]){
                lowestTime[curr] = Math.min(lowestTime[curr], discovoryTime[e.dest]);
                
            }else{
                dfs(graph, e.dest, curr, discovoryTime, lowestTime, visited, time, articulationPoint);
                lowestTime[curr] = Math.min(lowestTime[curr], lowestTime[e.dest]);
                if(discovoryTime[curr] <= lowestTime[curr] && parent != -1){
                    articulationPoint[curr] = true;
                }
                children++;
            }
        }
        if(parent == -1 && children > 1){
            articulationPoint[curr] = true;
        }
    }

    //same tragens algoritham for finding articulation point
    public static void getArticulationPoint(ArrayList<Edge> graph[], int V){
        int discovoryTime[] = new int[V];
        int lowestTime[] = new int[V];
        boolean visited[] = new boolean[V];
        boolean articulationPoint[] = new boolean[V];
        int time=0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph, i, -1,discovoryTime, lowestTime,visited, time, articulationPoint);
            }
        }

        for(int i=0;i<V;i++){
            if(articulationPoint[i]){
                System.out.println("Vertex "+i+" is an articulation point");
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        /*
         *  1 -- 0 ---- 3 
         *  |   /       | 
         *  |  /        |  
         *  | /         |   
         *  2           4
         *                   
        */

        getArticulationPoint(graph, V);
    }
}
