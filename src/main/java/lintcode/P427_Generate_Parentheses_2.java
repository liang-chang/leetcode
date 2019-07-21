package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P427_Generate_Parentheses_2 {

	public static void main(String[] args) {

		System.out.println(generateParenthesis(2));

//		System.out.println(generateParenthesis(3));

	}

	public static List<String> generateParenthesis(int n) {

		Set<String> res = new HashSet<String>();
		if (n == 0) {
			res.add("");
		} else {
			List<String> pre = generateParenthesis(n - 1);
			for (String str : pre) {
				for (int i = 0; i < str.length(); ++i) {
					if (str.charAt(i) == '(') {
						str = str.substring(0, i + 1) + "()"+ str.substring(i + 1, str.length());
						res.add(str);
						str = str.substring(0, i + 1)+ str.substring(i + 3, str.length());
					}
				}
				res.add("()" + str);
			}
		}
		return new ArrayList<String>(res);
	}

}
