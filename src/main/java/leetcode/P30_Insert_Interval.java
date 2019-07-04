package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P30_Insert_Interval {

	public static void main(String[] args) {
		// System.out.println(insert(new ArrayList<>(Arrays.asList(new
		// Interval(1, 2), new Interval(5, 9))), new Interval(2, 5)));
		// System.out.println(insert(new ArrayList<>(Arrays.asList(new
		// Interval(1, 2), new Interval(5, 9))), new Interval(3, 4)));
		// System.out.println(insert(new ArrayList<>(Arrays.asList(new
		// Interval(1, 5))), new Interval(2,3)));

		// System.out.println(insert(new ArrayList<>(Arrays.asList(new
		// Interval(1, 2),new Interval(3, 4),new Interval(5, 9))), new
		// Interval(3,4)));
		// System.out.println(
		// insert(new ArrayList<>(Arrays.asList(new Interval(1, 3), new
		// Interval(5, 8), new Interval(11, 14))),
		// new Interval(2, 12)));

		System.out.println(insert(new ArrayList<>(Arrays.asList(new Interval(1, 5))), new Interval(1, 7)));
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		int START_POINT_TYPE = 0;
		int END_POINT_TYPE = 1;

		BitSet bitSet = new BitSet();

		intervals.add(newInterval);

		Map<Integer, Integer> pointMap = new HashMap<>();

		// 节点去重及消除
		for (Interval interval : intervals) {
			putPoint(pointMap, interval.start, START_POINT_TYPE);
			putPoint(pointMap, interval.end, END_POINT_TYPE);
		}

		// 节点放入去重后的点
		for (Integer p : pointMap.keySet()) {
			bitSet.set(p, true);
		}

		// 包含关系的区间点消除
		for (Interval interval : intervals) {

			if (hasMoreThan(bitSet, interval.start, interval.end, 1)) {
				bitSet.clear(interval.start + 1, interval.end);
			}

		}

		int i = 0;
		for (;; i++) {
			i = bitSet.nextSetBit(i);

			if (i < 0) {
				break;
			}

			int j = bitSet.nextSetBit(i + 1);

			if (pointMap.get(i).equals(pointMap.get(j))) {
				// 类型相同

				// 相同类型点,起始点消前面,结束点消后面
				int clearP = pointMap.get(i).equals(START_POINT_TYPE) ? j : i;

				bitSet.clear(clearP);
			}

			i = j;
		}

		List<Interval> ret = new LinkedList<>();

		int ii = 0;
		while (true) {

			ii = bitSet.nextSetBit(ii);

			if (ii < 0) {
				break;
			}

			Interval t = new Interval(ii, 0);

			ii = bitSet.nextSetBit(ii + 1);

			t.end = ii;

			ii++;

			ret.add(t);
		}

		return ret;
	}

	public static boolean hasMoreThan(BitSet bitSet, int from, int to, int count) {

		int c = 0;
		for (int i = bitSet.nextSetBit(from + 1); i >= 0; i = bitSet.nextSetBit(i + 1)) {

			if (i >= to) {
				break;
			}

			c++;
		}

		return c > count;
	}

	public static void putPoint(Map<Integer, Integer> pointMap, int p, int type) {
		if (!pointMap.containsKey(p)) {
			pointMap.put(p, type);
		} else {

			if (!pointMap.get(p).equals(type)) {
				// 相同重复忽略,不同去除合并
				pointMap.remove(p);
			}
		}
	}

	public static class Interval {
		private int	start;
		private int	end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "[start=" + start + ",end=" + end + "]";
		}

	}
}
