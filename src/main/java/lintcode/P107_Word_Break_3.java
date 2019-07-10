package lintcode;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class P107_Word_Break_3 {

	public static void main(String[] args) {

		// System.out.println(wordBreak("lintcode",
		// new HashSet<String>(Arrays.asList("lint", "code"))));
		//
		// System.out.println(wordBreak("a",
		// new HashSet<String>(Arrays.asList("a"))));

//		System.out.println(wordBreak("eecdababa",
//				new HashSet<String>(Arrays.asList("e", "aba", "cdab"))));

		// System.out.println(wordBreak("a",
		// new HashSet<String>(Arrays.asList("aba", "cdab"))));

		// System.out.println(wordBreak("a", new HashSet<String>()));

		// System.out.println(wordBreak("aaab",
		// new HashSet<String>(Arrays.asList("b", "aa"))));

		// System.out.println(wordBreak("cars",
		// new HashSet<String>(Arrays.asList("car", "ca", "rs"))));
		
		System.out.println(wordBreak("abcdab",
				new HashSet<String>(Arrays.asList("abcd", "ab","b"))));

	}

	private static int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	/**
	 * <pre>
	 * wb[i]表示前i个字符能否组成dict中的word。
	 * 在i之前寻找分割点j，若前j个字符的结果为true并且j－i的字符串在dict中，则wb[i]为true。
	 * 状态函数：wb[i] = wb[i-j] && dict.contains(s.substring(i-j, i))，j表示最后一个word的长度。
	 * 即前i个字符能否组成dict中的word取决于前i-j个字符能否组成dict中的word以及最后一个字符串能否组成dict中的word。
	 * 其中，可以先遍历dict得到最长字符串的长度，然后将j限制在该长度内，可以优化时间。
	 * </pre>
	 */
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLength = getMaxLength(dict);

		BitSet canSegment = new BitSet(s.length() + 1);

		canSegment.set(0, true);

		for (int i = 1; i <= s.length(); i++) {
			canSegment.set(i,false);
			for (int j = 1; j <= maxLength && j <= i; j++) {

				//分融点前的字符是否存在
				if (!canSegment.get(i - j)) {
					continue;
				}

				String word = s.substring(i - j, i);

				System.out.println(s + ":[" + (i - j) + "," + i+ "]:"+(dict.contains(word)?1:0)+":" + word); 

				if (dict.contains(word)) {

					canSegment.set(i, true);
					break;
				}
			}
		}

		return canSegment.get(s.length());
	}
}
