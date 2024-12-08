package DataStructures.graph;
import java.util.ArrayList;

public class cycleDetection {
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
        //Directed graph creation
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 0));

        
        //Undirected graph creation
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));
        
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }

    //Directed graph
    public static boolean isCycleDetected(ArrayList<Edge> graph[], boolean[] visited, int curr, boolean[] recursionStack){
        visited[curr] = true;
        recursionStack[curr] = true;

        for(Edge e : graph[curr]){
            if(recursionStack[e.dest]){
                return true;
            }else if(!visited[e.dest]){
                if(isCycleDetected(graph, visited, e.dest, recursionStack)){
                    return true;
                }
            }
        }

        recursionStack[curr] = false;
        return false;

    }

    //Undirected graph
    public static boolean isCycleDetectedUndirected(ArrayList<Edge> graph[], boolean[] visited, int curr,int parent){
        visited[curr] = true;
        for(Edge e:graph[curr]){
            if(visited[e.dest] && e.dest != parent){ 
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycleDetectedUndirected(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }    

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGrpah(graph);
        boolean visited[] = new boolean[v];
        // boolean recursionStack[] = new boolean[v];
        // for(int i=0;i<v;i++){
        //     if(!visited[i]){
        //         boolean isCycle = isCycleDetected(graph, visited, 0, recursionStack);
        //         if(isCycle){
        //             System.out.println("Graph contains cycle");
        //             break;
        //         }else{
        //             System.out.println("Graph doesn't contain cycle");
        //         }
        //     }
        // }

        System.out.println( isCycleDetectedUndirected(graph, visited, 0, -1));
    }
}
