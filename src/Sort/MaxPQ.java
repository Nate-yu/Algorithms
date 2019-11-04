package Sort;

/**
 * @author Nate yu
 * @date 2019/11/4 - 19:48
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; // 基于堆的完全二叉树
    private int N = 0; // 储存于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    private void swim(int n) {
        while (n > 1 && less(n/2,n)) {
            exchange(n/2,n);
            n = n/2;
        }
    }

    private void exchange(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    public Key delMax(){
        Key max = pq[1]; // 从根节点得到最大元素
        exchange(1,N--); // 将其和最后一个结点交换
        pq[N+1] = null; // 防止对象游离
        sink(1); // 恢复堆的有序性
        return max;
    }

    private void sink(int i) {
        while (2*i <= N) {
            int j = 2*i;
            if (j < N && less(j,j+1)) j++;
            if (!less(i,j)) break;
            i = j;
        }
    }
}
