package DataStructures.graph;
import java.util.*;

public class graphTraversals {
    static class Edge{
        int src;
        int dest;
        
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
            
        }
    }

    public static void createGrpah(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    //TC = O(V+E)
    public static void bfs(ArrayList<Edge> graph[], int v,boolean visited[], int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(visited[curr] == false){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(Edge e: graph[curr]){
                    q.add(e.dest);
                }
            }
        }
    }

    //TC = O(V+E)
    public static void dfs(ArrayList<Edge>[] graph,int curr, boolean[] visited){
        System.out.print(curr + " ");
        visited[curr] = true;

        for(Edge e: graph[curr]){
            if(visited[e.dest] == false){
                dfs(graph, e.dest, visited);
            }
        }
    }

    //TC = O(V^V)
    public static void printAllPaths(ArrayList<Edge>graph[],boolean[] visited, int curr, String path, int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for(Edge e: graph[curr]){
            if(!visited[e.dest]){
                visited[curr] = true;
                printAllPaths(graph, visited, e.dest, path+" "+e.dest, target);
                visited[curr] = false;
            }
        }
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> stack){
        visited[curr] = true;

        for(Edge e: graph[curr]){
            if(!visited[e.dest]){
                topologicalSort(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }

    public static void topologicalSortPrint(ArrayList<Edge> graph[], int v){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                topologicalSort(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        /*
         *    1 --- 3
         *   /      | \
         *  0       |  5 -- 6 
         *   \      | /
         *    2 --- 4
        */

        ArrayList<Edge> graph[] = new ArrayList[v];
        createGrpah(graph);
        //boolean visited[] = new boolean[v];
        // for(int i=0;i<v;i++){
        //     if(visited[i] == false){
        //         dfs(graph, i,visited);
        //     }
        // }
        //int src = 0,dest = 5;
        //printAllPaths(graph, visited, src, "0", dest);

        topologicalSortPrint(graph, v);
    }
}
