package Sort;

/**
 * @author Nate yu
 * @date 2019/11/1 - 15:44
 */
public class Shell {
    public static void sort(Comparable[] a){ // 将a[]按升序排列
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h + 1; // 1,4,13,121,364,1093...
        }
        while (h >= 1){ // 将数组变为h有序
            for (int i = h; i < N; i++){ // 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j],a[j-h]); j-=h){
                    exchange(a,j,j-h);
                }
                h = h/3;
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
