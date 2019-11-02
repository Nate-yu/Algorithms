package Sort;

/**
 * @author Nate yu
 * @date 2019/11/2 - 19:53
 */
public class MergeBU {
    private static Comparable[] aux;

    public static void sort(Comparable[] a){ // 进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int size = 1; size < N; size = size + size){
            for (int low = 0; low < N-size; low+=size+size){
                merge(a,low,low+size-1,Math.min(low+size+size-1,N-1));
            }
        }
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
