package lintcode;

import java.util.LinkedList;
import java.util.List;

public class P427_Generate_Parentheses {

	public static void main(String[] args) {
		
		System.out.println(generateParenthesis(2));
		
		System.out.println(generateParenthesis(3));
		
	}

	public static List<String> generateParenthesis(int n) {


		List<String> results = new LinkedList<>();

		generateParenthesis(n, n, "", results);

		return results;
	}

	private static void generateParenthesis(int left, int right,
			String out, List<String> results) {
		
		if (left == 0 && right == 0) {
			results.add(out.toString());
			return;
		}

		if(left > 0){
			generateParenthesis(left - 1, right, out + "(", results);			
		}
		
		if(right > 0 && right > left){
			generateParenthesis(left, right - 1, out + ")", results);
		}
	}

}
