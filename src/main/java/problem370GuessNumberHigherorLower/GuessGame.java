package problem370GuessNumberHigherorLower;

class Solution extends GuessGame {
	public int guessNumber(int n) {

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
}

public class GuessGame {

	static final int t = 3;

	public int guess(int num) {
		return t - num;
	}

	public static void main(String[] args) {
		Solution t = new Solution();
		System.out.println(t.guessNumber(20));
	}
}