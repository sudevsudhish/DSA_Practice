package DataStructures.graph;

import java.util.ArrayList;

public class bridgeingraph {
    
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
        //graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        //graph[4].add(new Edge(4,5));

        //graph[5].add(new Edge(5,3));
        //graph[5].add(new Edge(5,4));
    }
    public static void dfs(ArrayList<Edge> graph[], int curr,boolean[] visited, int[] discovoryTime, int[] lowestTime, int time, int parent){
        visited[curr] = true;
        discovoryTime[curr] = lowestTime[curr] = ++time;

        for(Edge e: graph[curr]){
            if(e.dest == parent){
                continue;
            }else if(!visited[e.dest]){
                dfs(graph, e.dest, visited, discovoryTime, lowestTime, time, curr);
                lowestTime[curr] = Math.min(lowestTime[curr], lowestTime[e.dest]);
                if(discovoryTime[curr] < lowestTime[e.dest]){
                    System.out.println("Bridge is : " + curr + "----"+e.dest);
                }
            }else{
                lowestTime[curr] = Math.min(lowestTime[curr], discovoryTime[e.dest]);
            }
        }
        
    }

    public static void trajensAlgo(ArrayList<Edge> graph[],int V){
        int discovoryTime[] = new int[V];
        int lowestTime[] = new int[V];
        boolean visited[] = new boolean[V];
        int time=0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(graph,i, visited, discovoryTime, lowestTime, time, -1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        /*
         *  1 -- 0 ---- 3 
         *  |   /       | \
         *  |  /        |  5
         *  | /         | /  
         *  2           4
         *                   
        */
        trajensAlgo(graph,V);
    }
}
