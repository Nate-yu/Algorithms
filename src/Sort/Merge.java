package Sort;

/**
 * @author Nate yu
 * @date 2019/11/2 - 15:16
 */
public class Merge {
    private static Comparable[] aux; // 归并所需的辅助数组

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length]; // 一次性分配空间
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) { // 将数组a[low...high]排序
        if (high <= low){
            return;
        }
        int mid = low + (high - low)/2;
        sort(a,low,mid); // 将左半边排序
        sort(a,mid+1,high); // 将右半边排序
        merge(a,low,mid,high); // 归并结果
    }

    private static void merge(Comparable[] a, int low, int mid, int high) { // 将a[low...mid]和a[mid+1...high]归并
        int i = low,j = mid + 1;
        for (int k = low; k <= high; k++) // 将a[low...high]复制到aux[low...high]
            if (i > mid) a[k] = aux[j++]; // 左半边用尽-->取右半边元素
            else if (j > high) a[k] = aux[i++]; // 右半边用尽-->取左半边元素
            else if (less(aux[j],aux[i])) a[k] = aux[j++]; // 右半边当前元素小于左半边当前元素-->取右半边元素
            else a[k] = a[i++]; // 左半边当前元素小于右半边当前元素-->取左半边元素
    }

    private static boolean less(Comparable v, Comparable w){ // 当v < w时才返回true
        return v.compareTo(w) < 0;
    }
}
