package leetcode;

class P370_GuessGame {

	static final int t = 3;

	public static void main(String[] args) {
		System.out.println(guessNumber(20));
	}

	public static int guessNumber(int n) {

		int a = 1, b = n;

		while (a < b) {
			int mid = ((b - a) >> 1) + a;
			int ret = guess(mid);
			if (ret == 0) {
				return mid;
			}

			if (ret < 0) {
				b = mid - 1;
			} else {
				a = mid + 1;
			}

		}

		return b;
	}

	public static int guess(int num) {
		return t - num;
	}
}
