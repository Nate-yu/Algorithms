package Graph;

import java.nio.file.Path;

/**
 * @author Nate yu
 * @date 2020/1/29 - 18:58
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public int count(){
        return count;
    }

    public boolean marked(int w){
        return marked[w];
    }

    private void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for (int w:G.adj(v))
            if (!marked[w])
                dfs(G,w);
    }

    public DepthFirstSearch(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
}
