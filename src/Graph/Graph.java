package Graph;

import java.util.Scanner;

/**
 * @author Nate yu
 * @date 2020/1/11 - 22:41
 */
public class Graph {

    private final int V; // the amount of vertexes
    private int E; // the amount of edges
    private Bag<Integer>[] adj; // adjacency list

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }
    public  Graph(In in){
        this(in.readInt()); // read the V and init the graph
        int E = in.readInt(); // read the E
        for (int i = 0; i < E; i++){ // add an edge
            int v = in.readInt(); // read a vertex
            int w = in.readInt(); // read another vertex
            addEdge(v,w); // add an edge which can link them
        }
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    private void addEdge(int v, int w) {
        adj[v].add(w); // add the w to the link list of v
        adj[w].add(v); // add the v to the link list of w
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public static int degree(Graph G,int v){ // calculate the degree of the v
        int degree = 0;
        for (int w : G.adj(v))
            degree++;
        return degree;
    }
    public static int maxDegree(Graph G){ // calculate the max of all degrees
        int max = 0;
        for (int v = 0; v < G.V(); v++){
            if (degree(G,v) > max){
                max = degree(G,v);
            }
        }
        return max;
    }
    public static double avgDegree(Graph G){ // calculate the average of all degrees
        return 2.0 * G.E() / G.V();
    }
    public static int numberOfSelfLoops(Graph G){ // calculate the number of self loops
        int count = 0;
        for (int v = 0; v < G.V(); v++){
            for (int w : G.adj(v)){
                if (v == w) {
                    count++;
                }
            }
        }
        return count/2; // because all edges are recorded twice
    }
    public String toString(){ // make the adjacency list of the graph to string
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++){
            s += v + ": ";
            for (int w : this.adj(v)){
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}