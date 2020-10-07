package leetcode;

class P1143_Longest_Common_Subsequence {

    public static void main(String[] args) {
        String a = "", b = "";

        a = "abcde";
        b = "ace";
        System.out.println(longestCommonSubsequence(a, b));


        a = "abc";
        b = "abc";
        System.out.println(longestCommonSubsequence(a, b));


    }


    public static int longestCommonSubsequence(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            if (a.isEmpty()) {
                return b.length();
            }
            if (b.isEmpty()) {
                return a.length();
            }
        }

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        dp(dp, a, a.length(), b, b.length());

        return dp[a.length()][b.length()];
    }

    public static int dp(int[][] table, String a, int i, String b, int j) {
        if (i == 0 || j==0) {
            return 0;
        }

        char ca = a.charAt(i - 1);
        char cb = b.charAt(j - 1);

        int max = 0;
        if (ca == cb) {

            max = dp(table,a, i - 1, b, j - 1)+1;

        } else {
            max = Math.max(
                    dp(table, a, i - 1, b, j),
                    dp(table, a, i, b, j - 1)
            );

        }
        table[i][j] = max;
        return max;
    }

}
