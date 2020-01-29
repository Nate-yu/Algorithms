package Graph;

import java.util.Stack;


/**
 * @author Nate yu
 * @date 2020/1/29 - 19:39
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo; // 从起点到一个顶点的已知路径上的最后一个顶点
    private final int s; // 起点

    public DepthFirstPaths(Graph G,int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        for (int w:G.adj(v))
            if (!marked[w]){
                dfs(G,w);
                edgeTo[w]=v;
            }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
