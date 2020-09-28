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
     */
    public static int minDistance(String word1, String word2) {

        if (word1.length() == 0 || word2.length() == 0) {
            if (word1.length() == word2.length()) {
                return 0;
            }

            return Math.max(word1.length(), word2.length());
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0, len = word1.length(); i <= len; i++) {
            for (int j = 0, len2 = word2.length(); j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (i == j) ? 0 : Math.max(i, j);
                    continue;
                }

                // 相等则距离不变
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                // word1 变为 word2
                // 修改: 将word1的第i个字符修改成和word2的第j个字符相同的
                int a = dp[i - 1][j - 1];

                // 删除: 将word1的第i个字符删除
                int b = dp[i - 1][j];

                // 添加: 向word1添加一个和word2第j个字符相同的字符
                int c = dp[i][j - 1];

                dp[i][j] = Math.min(a, Math.min(b, c)) + 1;
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[word1.length()][word2.length()];
    }
}
