package leetcode;

public class P1775_Find_The_Numbers_II {

	public static void main(String[] args) {

		System.out.println(getSum(2, 7));
		System.out.println(getSum(3, 4));
	}

	public static int getSum(int A, int B) {
		int sum = 0;
		for (int i = A; i <= B; i++) {

			sum += i % 3 == 0 ? i : 0;

		}
		return sum;
	}
}
