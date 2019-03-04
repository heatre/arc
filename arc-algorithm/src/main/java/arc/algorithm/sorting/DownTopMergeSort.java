package arc.algorithm.sorting;


import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Stopwatch;
import arc.algorithm.utils.Utils;

/**归并排序(merge sort):将两个有序的数组归并成一个更大的有序数组，其主要体现的了算法设计中的分治思想
 * 自底向上归并排序：归并微型数组，得到子数组，在归并子数组，得到排序好的数组，(一一归并，二二归并，四四归并，8，8归并 ...)
 * 算法性能：长度为N的任意数组，需要1/2NlgN~NlgN次比较，最多6NlgN次数组访问
 * Created by Swin on 2016/12/22.
 */
public class DownTopMergeSort {

    /**
     * 归并排序辅助数组
     */
    private static Comparable[] ax;


    /**
     * 原地归并抽象方法,将a[lo..mid]和a[mid..hi]归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //将需要归并的两个数组复制到辅助数组；
        for (int k = lo; k <= hi; k++) {
            ax[k] = a[k];
        }
        //归并两个子数组
        for (int k = lo; k <= hi; k++) {
            //i>mid表示左边子数组归并完成,直接复制右边子数组剩余的元素到a
            if (i > mid) {
                a[k] = ax[j++];
                //j>hi表示右边子数组归并完成,直接复制左边子数组剩余的元素到a
            } else if (j > hi) {
                a[k] = ax[i++];
                //对比左右子数组当前位置的最小值，右子数组当前索引元素较小取当前值，索引后移
            } else if (less(ax[j], ax[i])) {
                a[k] = ax[j++];
                //对比左右子数组当前位置的最小值，左子数组当前索引元素较小取当前值，索引后移
            } else {
                a[k] = ax[i++];
            }
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        ax = new Comparable[n];
        //sz子数组大小
        for(int sz = 1;sz<n;sz = sz+sz)
        {
            //lo子数组索引
            for(int lo = 0;lo<n-sz;lo += sz+sz) {
                //lo两个小数组归并后的索引位置
                merge(a,lo,lo+sz-1, Math.min(lo+sz+sz-1,n-1));
            }
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
        assert (isSorted(a));
        show(a);
    }
}
