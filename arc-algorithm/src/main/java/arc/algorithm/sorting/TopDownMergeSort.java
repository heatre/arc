package arc.algorithm.sorting;


import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Stopwatch;
import arc.algorithm.utils.Utils;

/**
 * 归并排序(merge sort):将两个有序的数组归并成一个更大的有序数组，其主要体现的了算法设计中的分治思想
 * 自顶向下归并排序：递归调用将两个子数组排序，在将两个子数组归并成一个数组，从而将整个数组排序
 * 算法性能：长度为N的任意数组，需要1/2NlgN~NlgN次比较，最多6NlgN次数组访问
 * 性能提升：1.小规模子数组使用插入排序 2.测试数组是否已经有序(a[mid]<a[mid+1]) 3.不将元素复制到辅助数组
 * 时间复杂度：最好、最坏、平均都是O(NlogN)
 * 空间复杂度：O(N)
 * Created by Swin on 2016/12/22.
 */
public class TopDownMergeSort {

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
        //左子数组索引,表示有序的左子数组最小值
        int i = lo;
        //右子数组索引，表示有序右子数组最小值
        int j = mid + 1;
        //将需要归并的两个数组复制到辅助数组；
        for (int k = lo; k <= hi; k++) {
            //a[lo...hi]左右子数组归并后的大小,辅助数组
            ax[k] = a[k];
        }
        //归并两个子数组
        for (int k = lo; k <= hi; k++) {
            //i>mid表示左边子数组归并完成,直接复制右边子数组剩余的元素到a
            if (i > mid)
            {
                a[k] = ax[j++];
                //j>hi表示右边子数组归并完成,直接复制左边子数组剩余的元素到a
            } else if (j > hi) {
                a[k] = ax[i++];
            }
            //对比左右子数组当前位置的最小值，右子数组当前索引元素较小取当前值，索引后移
            else if (less(ax[j], ax[i]))
            {
                a[k] = ax[j++];
                //对比左右子数组当前位置的最小值，左子数组当前索引元素较小取当前值，索引后移
            } else {
                a[k] = ax[i++];
            }
            show(ax);
            show(a);
        }
    }

    public static void sort(Comparable[] a) {
         ax = new Comparable[a.length];
        sort(a,0,a.length-1);
    }


    /**
     * 将数组分割为左右两部分数组
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) {
            return;
        }
        //获取中间索引
        int mid = lo+(hi-lo)/2;
        //归并左半边
        sort(a,lo,mid);
        //归并右半边
        sort(a,mid+1,hi);
        //归并结果
        merge(a,lo,mid,hi);
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

    public static void main(String[] args) {
        String[] a = Utils.getStringArray("tiny.txt");
        Stopwatch sw = new Stopwatch();
        sort(a);
        sw.elapsedTime();
        assert (isSorted(a));
        show(a);
    }
}
