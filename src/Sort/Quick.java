package Sort;

/**
 * @author Nate yu
 * @date 2019/11/3 - 19:25
 */
public class Quick {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a); // 消除对输入的依赖
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) { // 将数组切分为a[low..i-1],a[i],a[i+1..high]
        int i = low, j = high + 1; // 进行左右扫描的指针
        Comparable v = a[low]; // v为切分元素
        while (true) { // 扫描左右，检查是否结束并交换元素
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i > j) break;
            exchange(a, i, j);
        }
        exchange(a, low, j); // 将v=a[j]放入正确位置
        return j;
    }

    private static boolean less(Comparable v, Comparable w) { // 当v < w时才返回true
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) { // 交换数据
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}