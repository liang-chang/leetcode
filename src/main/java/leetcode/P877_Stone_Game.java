package leetcode;

import javax.sound.midi.Soundbank;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class P877_Stone_Game {

    public static void main(String[] args) {
        int[] i = {5, 3, 4, 5};
        System.out.println(stoneGame(i));

    }

    public static boolean stoneGame(int[] piles) {
        if (piles.length == 1 || piles.length == 2) {
            return true;
        }
        int n = piles.length;

        Pair[][] dp = new Pair[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i].first = piles[i];
            dp[i][i].second = 0;
        }

        // n = 4
        for (int l = n - 1; l > 0; l--) { //行控制 3 2 1
            for (int i = 0; i < l; i++) { //0 1 2 3
                int j = i + (n - l);

                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;

                if (left > right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;
                }
            }
        }

        Pair p = dp[0][n - 1];
        return p.first > p.second;
    }

    public static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
