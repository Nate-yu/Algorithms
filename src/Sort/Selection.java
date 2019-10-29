package Sort;

/**
 * @author Nate yu
 * @date 2019/10/29 - 19:24
 */
public class Selection {
    public static void sort(Comparable[] a){ // 将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) { // 将a[i]和a[i+1..N]中最小的元素进行交换
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j],a[min])) min = j;
                exchange(a,i,min);
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
