package arc.algorithm.sorting;


import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.StdRandom;
import arc.algorithm.utils.Stopwatch;
import arc.algorithm.utils.Utils;

/**
 * 三切分快速排序(quick sort with 3-way partitioning):从左至右修复数组一次，维护一个指针lt使得
 * a[lo..lt-1]中的元素都小于v，一个指针gt使得a[gt+1..hi]中的元素都大于v,一个指针i使得a[lt..i-1]
 * 中的元素等于v，a[i..gt]中的元素未确定。
 * 算法性能：三切分的快速排序的运行时间和输入信息量的N倍成正比
 * Created by Swin on 2016/12/27.
 */
public class Quick3WaySort {

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
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        Comparable v = a[lo];
        //遍历使a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]
        while (i <= gt) {
            if(less(a[i],v)) {
                exch(a,lt++,i++);
            } else if(less(v,a[i])) {
                exch(a,gt--,i);
            } else {
                i++;
            }
            show(a);
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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
            if (less(a[i], a[i - 1]))
                return false;
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
