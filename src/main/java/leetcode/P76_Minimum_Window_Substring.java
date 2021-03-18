package leetcode;

import java.util.HashMap;
import java.util.Map;

public class P76_Minimum_Window_Substring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }


    public static String minWindow(String s, String t) {

        // 在 s 中寻找 t 的「最小覆盖子串」
        int left  = 0, right = 0;
        int start = 0, minLen = Integer.MAX_VALUE;

// 相当于两个计数器
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs  = new HashMap<>();
        for (char c : t.toCharArray()) needs.put(c, needs.containsKey(c)?needs.get(c):1);

// 记录 window 中已经有多少字符符合要求了
        int match = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.containsKey(c1)
                        ? window.get(c1) : 1); // 加入 window
                if (window.get(c1).compareTo(needs.get(c1)) == 0)
                    // 字符 c1 的出现次数符合要求了
                    match++;
            }
            right++;

            // window 中的字符串已符合 needs 的要求了
            while (match == needs.size()) {
                // 更新结果 res
                if (right - left < minLen) {
                    // 更新最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {

                    window.put(c2, window.get(c2) - 1);// 移出 window

                    if (window.get(c2) < needs.get(c2))
                        // 字符 c2 出现次数不再符合要求
                        match--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ?
                "" : s.substring(start, start + minLen);

    }

}
