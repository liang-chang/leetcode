package lintcode;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

class P75_Find_Peak_Element {

	static final int t = 3;

	public static void main(String[] args) {

		List<Integer> collect = IntStream.range(0, 100000).boxed()
				.collect(toList());

		collect.add(1);

		System.out
				.println(findPeak(collect.stream().mapToInt(i -> i).toArray()));

		System.out.println(findPeak(new int[] { 1, 2, 1, 3, 4, 5, 7, 6 }));

		System.out.println(findPeak(new int[] { 1, 2, 3, 4, 1 }));

	}

	public static int findPeak(int[] a) {

		if (a[1] > a[2]) {
			return 1;
		}
		if (a[a.length - 2] > a[a.length - 3]) {
			return a.length - 2;
		}
		for (int i = 1, len = a.length; i < len; i++) {
			if (a[i] < a[i - 1]) {
				return i - 1;
			}
		}
		return 0;
	}
}
