package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P30_Insert_Interval_2 {

	public static void main(String[] args) {

		System.out.println(insert(L(I(1, 2), I(5, 9)), I(2, 5)));

		System.out.println(insert(L(I(1, 2), I(5, 9)), I(3, 4)));

		System.out.println(insert(L(I(1, 5)), I(2, 3)));

		System.out.println(insert(L(I(1, 2), I(3, 4), I(5, 9)), I(3, 4)));

		System.out.println(insert(L(I(1, 3), I(5, 8), I(11, 14)), I(2, 12)));

		System.out.println(insert(L(I(1, 5)), I(1, 7)));

		System.out.println(insert(L(I(1, 5)), I(0, 0)));
	}

	public static List<Interval> insert(List<Interval> intervals, Interval ni) {

		int i = search(intervals, ni.start);

		int j = search(intervals, ni.end);

		// 没有横跨多个区间
		if (i == j) {
			// 包含关系,或没有包含关系

			if (i >= 0) {
				// 被包含
				return intervals;
			}

			// 无包含关系
			intervals.add(ni);
			Collections.sort(intervals, (a, b) -> a.start - b.start);
			return intervals;

		}

		// 跨多个
		if (i >= 0 && j >= 0) {

			Interval a = intervals.get(i);
			Interval b = intervals.get(j);

			// 尾部值复制
			a.end = b.end;

			// 清除i后面到j(包含)的所有数据
			intervals.subList(i + 1, j + 1).clear();

			return intervals;
		}

		// 至少全包含一个区间
		if (i < 0 && j < 0) {
			intervals.subList(-i - 1, -j - 1).clear();

			intervals.add(ni);
			Collections.sort(intervals, (a, b) -> a.start - b.start);
			return intervals;
		}
		
		//至少与一个区间有交集
		if( i < 0 ){
			ni.end = intervals.get(j).end;
			
			intervals.subList(-i - 1, j + 1 ).clear();
			
			intervals.add(ni);
			Collections.sort(intervals, (a, b) -> a.start - b.start);
			return intervals;
		}
		
		// i > 0 , j <0
		intervals.get(i).end = ni.end;
		
		intervals.subList(i+1, -j - 1 ).clear();

		return intervals;
	}

	public static int search(List<Interval> intervals, int point) {

		return Collections.binarySearch(intervals, point, (a, b) -> {

			Interval i = null;

			int p;

			if (Interval.class.isInstance(a)) {
				i = (Interval) a;
				p = (int) b;
			} else {
				i = (Interval) b;
				p = (int) a;
			}

			if (p < i.start) {
				return 1;
			}

			if (p > i.end) {
				return -1;
			}

			return 0;
		});

	}

	public static List<Interval> L(Interval... i) {
		return new ArrayList<Interval>(Arrays.asList(i));
	}

	public static Interval I(int start, int end) {
		return new Interval(start, end);
	}

	public static class Interval {
		private int start;
		private int end;

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
