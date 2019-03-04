package arc.algorithm.sorting;


import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.StdRandom;
import arc.algorithm.utils.Stopwatch;
import arc.algorithm.utils.Utils;

/**
 * 快速排序(quick sort)：快速排序是一种分治的排序算法。它将一个数组分成两个子数组，将两部分独立的排序。
 * 算法性能：长度为N的无重复元素的数组，快速排序平均需要~NlgN次比较和N/6的交换,最多需要~N^2/2次比较，
 * 但随机打乱数组可预防这种状况
 * 改进：1.切换到插入排序 2.三取样切分 3.熵最优的排序
 * 时间复杂度：平均时间O(NlgN)
 * 空间复杂度：O(N)
 * Created by Swin on 2016/12/27.
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        //消除对输入的依赖
        StdRandom.shuffle(a);
        show(a);
        sort(a, 0, a.length - 1);
    }


    /**
     * 递归实现快速排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }



    /**
     * 快速排序的切分,将数组切分为a[lo..i-1],a[i],a[i+1..hi]
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        //左分区索引
        int i = lo;
        //右分区索引
        int j = hi + 1;
        //选择第一个元素作为切分元素
        Comparable v = a[lo];
        while (true) {
            //从左向右扫描，a[i]<v时,i增大,保证i左侧的比v小，
            while (less(a[++i], v)) {
                //向右扫描到尾部时结束
                if (i == hi)
                {
                    break;
                }
            }
            //从右向左扫描，v>a[j]时，j减少，保证j右侧的比v大
            while (less(v, a[--j])) {
                //向右扫描到开头时结束
                if (j == lo) {
                    break;
                }
            }
            //指针相遇
            if (i >= j) {
                break;
            }
            StdOut.println("a[i]:" + a[i] + " " + "a[j]:" + a[j]);
            //交换a[i],a[j]保证i左侧值不大于v，j右侧的值不小于v,此时a[j]<v&& a[i]>v，
            // 可保证a[i]<v,a[j]>v,即最终保证
            //切分点v左右两边有序，
            exch(a, i, j);
            show(a);
        }
        show(a);
        //当i==j时，指针相遇交换a[lo],a[j]切分结束，(切分值保留在a[j]当中)
        exch(a, lo, j);
        return j;
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
