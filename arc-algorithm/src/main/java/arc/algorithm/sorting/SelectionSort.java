package arc.algorithm.sorting;

import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Stopwatch;
import arc.algorithm.utils.Utils;

/**选择排序(Selection Sort)：
 * 1.找到数组中最小的元素
 * 2.将它和数组中第一个元素交换位置
 * 3.在剩下的元素当中找到最小元素，与数组中第二个元素交换位置
 * 4.重复步骤3知道数组有序
 * 算法性能：对于长度为N的数组，选择排序需要~N^2/2次比较和N次交换
 * 时间复杂度：最差、平均都是O(N^2)
 * 空间复杂度：1
 * Created by Swin on 2016/12/21.
 */
public class SelectionSort {


    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i = 0;i<n;++i){
            int min = i;
            //遍历i+1~n-1的元素获取其中最小元素的位置
            for(int j = i+1;j<n;++j){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            //讲最小元素，与第i个元素交换
            exch(a,i,min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    //测试用例
    public static void main(String[] args) {
        String[] a = Utils.getStringArray("tiny.txt");
        Stopwatch sw = new Stopwatch();
        sort(a);
        sw.elapsedTime();
        assert(isSorted(a));
        show(a);
    }
}
