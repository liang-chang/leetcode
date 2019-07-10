package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P107_Word_Break_2 {

	public static void main(String[] args) {

		System.out.println(wordBreak("lintcode",
				new HashSet<String>(Arrays.asList("lint", "code"))));

		System.out.println(wordBreak("a",
				new HashSet<String>(Arrays.asList("a"))));

		System.out.println(wordBreak("eecdababa",
				new HashSet<String>(Arrays.asList("e", "aba", "cdab"))));

		System.out.println(wordBreak("a",
				new HashSet<String>(Arrays.asList("aba", "cdab"))));

		System.out.println(wordBreak("a", new HashSet<String>()));

		System.out.println(wordBreak("aaab",
				new HashSet<String>(Arrays.asList("b", "aa"))));

	}

	public static boolean wordBreak(String s, Set<String> dict) {

		if (dict.size() <= 0) {
			if (s.length() <= 0) {
				return true;
			}

			return false;
		}

		BitSet bs = new BitSet(s.length());

		Deque<Integer> stack = new LinkedList<>();

		List<String> words = new ArrayList<>(dict);

		words.sort((a, b) -> b.length() - a.length());

		for (int i = 0, len = s.length(); i < len; i++) {

			for (String word : words) {
				if ((i = s.indexOf(word, i)) < 0) {
					continue;
				}

				push(i, word, bs, stack, words);
				break;
			}

			if (stack.size() <= 0) {
				return false;
			}

			while (true) {

				for (String word : words) {

					for (int j = 0, len2 = s.length(); j < len2; j++) {

						int index = s.indexOf(word, j);


						if (index < 0) {

							break;
						}
						
						j = index;

						if (testHashMark(index, index + word.length(), bs)) {
							continue;
						}

						push(index, word, bs, stack, words);
						
						break;
					}
				}

				if (bs.cardinality() >= s.length()) {
					return true;
				}

				break;
			}
		}

		return false;
	}

	/**
	 * s 查找的开始范围(包含) e 查找的结束范围(不包含)
	 */
	public static boolean testHashMark(int s, int e, BitSet bs) {

		int nextSetBit = bs.nextSetBit(s);

		if (nextSetBit < 0) {
			return false;
		}

		if (nextSetBit >= e) {
			return false;
		}

		return true;

	}

	public static void pop(BitSet bs, Deque<Integer> stack, List<String> words) {
		Integer index = stack.pop();

		String word = words.get(stack.size());

		bs.set(index, index + word.length(), false);
	}

	public static void push(int index, String word, BitSet bs,
			Deque<Integer> stack, List<String> words) {
		stack.push(index);

		bs.set(index, index + word.length(), true);
	}

}
