package lintcode;

import java.util.Arrays;

public class P119_Edit_Distance {

    public static void main(String[] args) {

        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("b", ""));
        System.out.println(minDistance("a", "a"));
    }

    /**
     * LCS 算法的变种
     * 自底向上
     */
    public static int minDistance(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            if (a.length() == b.length()) {
                return 0;
            }
            return Math.max(a.length(), b.length());
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0, len = a.length(); i <= len; i++) {
            for (int j = 0, len2 = b.length(); j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (i == j) ? 0 : Math.max(i, j);
                    continue;
                }
                // 相等则距离不变
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // word1 变为 word2
                // 改 ,a字符当前位置改成与b一样, 字符 a ,b 都向前移一位
                int x = dp[i - 1][j - 1];

                // 删, a字符当前位置删除字符,a 字符变短但当前下标前移一下,b 不会
                int y = dp[i - 1][j];

                // 增, a字符当前位置后面插入与b相等的字符,a字符后面与b相同,b 字符向前移一格
                int z = dp[i][j - 1];
                dp[i][j] = Math.min(x, Math.min(y, z)) + 1;
            }
        }
        return dp[a.length()][b.length()];
    }
}
