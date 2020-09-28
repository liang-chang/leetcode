package lintcode;

import java.util.Arrays;

public class P119_Edit_Distance_2 {

    public static void main(String[] args) {

        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("b", ""));
        System.out.println(minDistance("a", "a"));
    }

    /**
     * LCS 算法的变种
     */
    public static int minDistance(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (aLen == 0 || bLen == 0) {
            if (a == b) {
                return 0;
            }
            return Math.max(aLen, bLen);
        }

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                dp[i][j] = -1;
            }
        }

        int ret = dp(dp, a, a.length(), b, b.length());
        System.out.println(Arrays.deepToString(dp));
        return ret;
    }


    /**
     * 字符 a 变成 b 需要步骤
     *
     * @param dp
     * @param a
     * @param i
     * @param b
     * @param j
     * @return
     */
    public static int dp(int[][] dp, String a, int i, String b, int j) {

        if (i <= 0) {
            return j;
        }

        if (j <= 0) {
            return i;
        }

        int distance = dp[i][j];
        if (distance >= 0) {
            return distance;
        }

        char ca = a.charAt(i - 1);
        char cb = b.charAt(j - 1);
        if (ca == cb) {
            dp[i][j] = dp(dp, a, i - 1, b, j - 1);
        } else {
            //增, a字符当前位置插入一个与b相等的字符,a 字符变长但当前下标不变,b 字符向前移一格
            int x = dp(dp, a, i, b, j - 1);

            //删, a字符当前位置删除一个字符,a 字符变短但当前下标前移一下,b 不会
            int y = dp(dp, a, i - 1, b, j);

            //改 ,a字符当前位置改成与了一样, 字符 a ,b 都向前移一位
            int z = dp(dp, a, i - 1, b, j - 1);

            dp[i][j] = Math.min(x, Math.min(y, z)) + 1;
        }

        return dp[i][j];
    }
}
