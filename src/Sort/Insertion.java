package Sort;

/**
 * @author Nate yu
 * @date 2019/10/30 - 22:19
 */
public class Insertion { // 按a[]升序排列
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++){ // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exchange(a,j,j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w){ // 当v < w时才返回true
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i , int j){ // 交换数据
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
