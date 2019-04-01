package arc.algorithm.fundamentals;

/**
 * 全排列算法
 *
 * @author Mustache Zhang
 * @version 1.0
 * @date 2019/3/24
 */
public class Permutation {
    public static void swap(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void permutation(String[] a, int begin, int end) {
        if (begin == end) {
            for (int i = 0; i < a.length; ++i) {
                System.out.print(a[i]);
            }
            System.out.println();
        } else {
            for (int i = begin; i < end; i++) {
                swap(a, i, begin);
                permutation(a, begin+ 1, end);
                swap(a, i, begin);
            }
        }


    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "c","d"};
        permutation(a, 0, a.length);
    }
}
