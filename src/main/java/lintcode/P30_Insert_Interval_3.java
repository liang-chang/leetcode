package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P30_Insert_Interval_3 {

	public static void main(String[] args) {

		System.out.println(insert(L(I(1, 2), I(5, 9)), I(2, 5)));

		System.out.println(insert(L(I(1, 2), I(5, 9)), I(3, 4)));

		System.out.println(insert(L(I(1, 5)), I(2, 3)));

		System.out.println(insert(L(I(1, 2), I(3, 4), I(5, 9)), I(3, 4)));

		System.out.println(insert(L(I(1, 3), I(5, 8), I(11, 14)), I(2, 12)));

		System.out.println(insert(L(I(1, 5)), I(1, 7)));

		System.out.println(insert(L(I(1, 5)), I(0, 0)));

		System.out.println(insert(L(I(1, 5), I(6, 8)), I(0, 9)));
	}

	public static List<Interval> insert(List<Interval> intervals, Interval ni) {

		List<Interval> ret = new LinkedList<>();

		for (int i = 0, len = intervals.size(); i < len; i++) {

			if (ni == null) {
				ret.add(intervals.get(i));
				continue;
			}

			Interval current = intervals.get(i);

			int s = ni.start;
			int e = ni.end;

			if (s < current.start) {
				// 起止点在当前之前
				if (e < current.start) {
					//开始和结束在前面
					ret.add(ni);
					ret.add(current);
					ni = null; // 标记为处理完成
				} else if (e <= current.end) {
					//结束端点落在当前区间					
					ni.end = current.end;
					ret.add(ni);
					ni = null; // 标记为处理完成
				} else {
					// e > current.end
					// 当前区间被包含
					continue;
				}

			} else if (s <= current.end) {
				// 开始的点落在当前区间里
				if (e <= current.end) {
					// 插入的区间被包含

					ret.add(current);
					ni = null; // 标记为处理完成
				} else {
					// e > current.end
					ni.start = current.start;
				}
			} else {
				// s > current.end
				ret.add(current);
				continue;
			}
		}

		if (ni != null) {
			ret.add(ni);
		}

		return ret;
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
