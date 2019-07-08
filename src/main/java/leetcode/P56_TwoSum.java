package leetcode;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class P56_TwoSum {

	public static void main(String[] args) throws UnknownHostException {

		long s = System.currentTimeMillis();

		InetAddress iAddress = InetAddress.getLocalHost();
		String hostName = iAddress.getHostName();
		// To get the Canonical host name
		String canonicalHostName = iAddress.getCanonicalHostName();

		System.out.println("HostName:" + hostName);
		System.out.println("Canonical Host Name:" + canonicalHostName);

		System.out.println(System.currentTimeMillis() - s);

		int[] numbers;
		int target;

		numbers = new int[] { 2, 7, 11, 15 };
		target = 9;
		System.out.println(twoSum(numbers, target));

		numbers = new int[] { 15, 2, 7, 11 };
		target = 9;
		System.out.println(twoSum(numbers, target));

	}

	public static int[] twoSum(int[] numbers, int target) {

		Map<Integer, Integer> map = new HashMap<>(numbers.length);

		int[] r = { 0, 0 };

		for (int i = 0, len = numbers.length; i < len; i++) {
			int n = numbers[i];
			int need = target - n;

			if (map.containsKey(need)) {

				r[0] = i;
				r[1] = map.get(need);
				break;
			} else {
				map.put(n, i);
			}
		}

		if (r[0] > r[1]) {
			r[0] = r[0] ^ r[1];
			r[1] = r[0] ^ r[1];
			r[0] = r[0] ^ r[1];
		}

		return r;
	}
}
