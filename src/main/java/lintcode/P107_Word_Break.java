package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P107_Word_Break {

	public static void main(String[] args) {

		System.out.println(wordBreak("lintcode",
				new HashSet<String>(Arrays.asList("lint", "code"))));

		System.out.println(wordBreak("a",
				new HashSet<String>(Arrays.asList("a"))));

		System.out.println(wordBreak("eecdababa",
				new HashSet<String>(Arrays.asList("aba", "cdab"))));

		System.out.println(wordBreak("a",
				new HashSet<String>(Arrays.asList("aba", "cdab"))));

		System.out.println(wordBreak("a", new HashSet<String>()));

		System.out.println(wordBreak("aaab",
				new HashSet<String>(Arrays.asList("b", "aa"))));

	}

	public static boolean wordBreak(String s, Set<String> dict) {

		if ("".equals(s)) {
			return dict.size() <= 0;
		}

		if (dict.size() == 0) {
			return false;
		}

		BitSet bs = new BitSet();

		Deque<Integer> stack = new LinkedList<>();

		List<String> collect = new ArrayList<String>(dict);

		int first = s.indexOf(collect.get(0));

		if (first < 0) {
			return false;
		}

		bs.set(first, first + collect.get(0).length(), true);

		stack.push(first);

		if (collect.size() <= 1 && collect.get(0).length() == s.length()) {
			return true;
		}

		while (stack.size() > 0) {

			String word = collect.get(stack.size());

			while (stack.size() < collect.size()) {

				int find = s.indexOf(word);

				if (find < 0) {

					back(stack, bs, s, collect);

					break;
				}

				// 寻找是否对应的下标有没有设置为找到
				int nextSetBit = bs.nextSetBit(find);

				if (nextSetBit < 0) {
					// 没有找到就是可以
					bs.set(find, find + word.length(), true);

					stack.push(find);

					break;
				}

				// 找到已设置,判断是否有冲突
				if (nextSetBit < find + word.length()) {
					// 与现有有冲突,不可以

					back(stack, bs, s, collect);
				} else {
					bs.set(find, find + word.length(), true);

					stack.push(find);
				}

			}

			if (stack.size() == collect.size()) {
				if (bs.cardinality() == s.length()) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	public static void back(Deque<Integer> stack, BitSet bs, String s,
			List<String> collect) {

		String lastWord = collect.get(stack.size() - 1);

		// 回溯
		Integer lastStart = stack.pop();

		int indexOf = s.indexOf(lastWord, lastStart + 1);

		if (indexOf < 0) {
			return;
		}

		bs.set(lastStart, lastStart + lastWord.length(), false);
		bs.set(indexOf, indexOf + lastWord.length(), true);

		stack.push(indexOf);

	}

}
