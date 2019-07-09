package lintcode;

import static java.util.stream.Collectors.toList;

import java.util.BitSet;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P107_Word_Break {

	public static void main(String[] args) {

	}

	public boolean wordBreak(String s, Set<String> dict) {

		BitSet bs = new BitSet();

		Deque<Integer> stack = new LinkedList<>();

		stack.push(0);

		List<String> collect = dict.stream().collect(toList());

		while (true) {

			Integer startIndex = stack.pop();

			String word = collect.get(stack.size());

			int find = s.indexOf(word, startIndex);

			if (find < 0) {
				continue;
			}
			
//			if(bs.){
//				
//			}
			
			
			bs.set(find, find + word.length(), true);
			

			break;
		}

		return false;
	}

}
