package leetcode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Max_In_Window {

    public static void main(String[] args) throws UnknownHostException {
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};

        ArrayList<Integer> integers = maxInWindows(arr, 3);

        System.out.println(integers);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        java.util.ArrayList<Integer> list = new ArrayList<>();//存滑动窗口最大值
        ArrayDeque<Integer>          q    = new ArrayDeque<>();//

        q.add(0);    //存入的是下标
        for (int i = 0; i < num.length; i++) {

            //如果加入的元素大于队列中已有的元素，已有元素就出队列
            while (!q.isEmpty() && num[q.peekLast()] < num[i]) {
                q.pollLast();
            }

            //每次遍历数组，都要加入一个元素
            q.add(i);

            if (i - q.peekFirst() >= size) { //超过滑动窗口大小了，从队头取出元素
                q.pollFirst();
            }

            //从第三个数字开始
            if (i >= size - 1) {
                //从尾巴开始取出
                list.add(num[q.peekFirst()]);
            }
        }
        return list;
    }
}
