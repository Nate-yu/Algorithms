import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Nate yu
 * @date 2019/10/26 - 15:22
 */

public class BinarySearch {
    public static int rank(int key,int[] a){
        // 数组必须有序
        int low = 0;
        int high = a.length-1;
        while (low<=high){ // 被查找的键要么不存在，否则必然存在于a[low...high]中
            int mid = low + (high-low)/2;
            if (key < a[mid]) high = mid-1;
            else if (key > a[mid]) low = mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] whitelist = {0,4,25,8,9,54,23,7};

        Arrays.sort(whitelist);

        while (scanner.hasNext()){ // 读取键值，如果不存在则将其打印
            int key = scanner.nextInt();
            if (rank(key,whitelist) == -1){
                System.out.printf("未在数组whitelist中找到key:%d！\n",key);
            } else if (rank(key,whitelist) >= 0){
                System.out.printf("key存在于数组whitelist中第%d位！\n",rank(key,whitelist)+1);
            }
        }
    }
}

