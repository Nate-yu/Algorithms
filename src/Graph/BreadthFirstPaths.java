package Graph;

import Search.Queue;

import javax.swing.text.StyledEditorKit;
import java.util.Stack;

/**
 * @author Nate yu
 * @date 2020/1/30 - 19:23
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s; //起点

    public BreadthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true; // 标记起点
        queue.enqueue(s); // 将它加入队列
        while (!queue.isEmpty()){
            int v = queue.dequeue(); // 从队列中删去下一顶点
            for (int w:G.adj(v))
                if (!marked[w]){ // 对于每个未被标记的相邻顶点
                    edgeTo[w] = v; // 保存最短路径的最后一条边
                    marked[w] = true; // 标记它，因为最短路径已知
                    queue.enqueue(w); // 并将它添加到队列中
                }
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
