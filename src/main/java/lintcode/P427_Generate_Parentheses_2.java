package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P427_Generate_Parentheses_2 {

	public static void main(String[] args) {

//		System.out.println(generateParenthesis(2));

		System.out.println(generateParenthesis(3));

	}

	public static List<String> generateParenthesis(int n) {

		Set<String> set = new HashSet<String>();
		if (n == 0) {
			set.add("");
		} else {
			List<String> pre = generateParenthesis(n - 1);
			for (String s : pre) {
				for (int i = 0; i < s.length(); ++i) {
					if (s.charAt(i) == '(') {
						
						String t = s.substring(0, i + 1) + "()"+ s.substring(i + 1, s.length());
						
						set.add(t);
					}
				}
				set.add("()" + s);
			}
		}
		return new ArrayList<String>(set);
	}

}
