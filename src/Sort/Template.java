package Sort;

import java.util.Scanner;

/**
 * @author Nate yu
 * @date 2019/10/29 - 18:37
 */
public class Template {
    public static void sort(Comparable[] a){

    }

    public static double time(String alg,Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
//        if (alg.equals("Shell")) Shell.sort(a);
//        if (alg.equals("Merge")) Merge.sort(a);
//        if (alg.equals("Quick")) Quick.sort(a);
//        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    private static boolean less(Comparable v, Comparable w){ // 当v < w时才返回true
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i , int j){ // 交换数据
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show (Comparable[] a){ // 在单行中打印数组
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a){ // 测试数组是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparable[] a = {1,2,56,8,6,4};
        sort(a);
        show(a);
    }
}
