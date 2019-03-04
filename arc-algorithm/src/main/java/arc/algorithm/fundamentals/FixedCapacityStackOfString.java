package arc.algorithm.fundamentals;


import arc.algorithm.utils.Constant;
import arc.algorithm.utils.StdIn;
import arc.algorithm.utils.StdOut;
import arc.algorithm.utils.Utils;

/**定容字符串栈
 * Created by Swin on 2016/9/2.
 */
public class FixedCapacityStackOfString {
    private String[] a;
    private int cap;
    private int N;

    public FixedCapacityStackOfString(int cap) {
        a = new String[cap];
        this.cap = cap;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }
    public boolean isCapacity(){
        return cap == N;
    }

    public int size() {
        return N;
    }

    public void push(String s) {
        a[N++] = s;
    }

    public String pop() {
        if (N == 0) {
            return null;
        }
        return a[--N];
    }

    public static void main(String[] args) {
        String fn = Constant.DATA_DIR + "tobe.txt";
        StdIn.setScanner(Utils.getScanner(fn));
        FixedCapacityStackOfString fs = new FixedCapacityStackOfString(1);
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-") && !fs.isCapacity()) {
                fs.push(s);
            } else if (!fs.isEmpty()) {
                StdOut.print(fs.pop() + " ");
            }
        }
        StdOut.println("(" + fs.size() + " left on stack)");
    }
}
