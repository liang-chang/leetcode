package CodingInterviewChinese2;

import java.util.LinkedList;

public class P31_StackPushPopOrder {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        System.out.println(match(a, b));

        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {4, 3, 5, 1, 2};
        System.out.println(match(a1, b1));

    }

    static boolean match(int[] a, int[] b) {
        LinkedList<Integer> stack = new LinkedList<>();
        int                 ai    = 0;
        int                 bi    = 0;
        boolean             r     = false;
        while (bi < b.length) {
            while (stack.isEmpty() || stack.peek() != b[bi]) {
                if (ai >= a.length) break;
                stack.push(a[ai++]);
            }
            if (stack.peek() != b[bi]) break;
            stack.pop();
            bi++;
        }
        if (stack.isEmpty() && bi == b.length) {
            r = true;
        }
        return r;
    }
}
