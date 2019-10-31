package Sort;

import org.omg.CORBA.INTERNAL;

import java.time.format.SignStyle;

/**
 * @author Nate yu
 * @date 2019/10/31 - 21:17
 */
public class SortCompare {

    public static double time(String alg,Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg,int N,int T){ // 使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++){ // 进行一次测试（生成一个数组并排序）
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1,N,T); // 算法1的总时间
        double t2 = timeRandomInput(alg2,N,T); // 算法2的总时间
        System.out.printf("For %d random Doubles\n    %s is",N,alg1);
        System.out.printf(" %lf times faster than %s\n",t2/t1,alg2);
    }
}
