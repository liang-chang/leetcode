package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
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

		List<Interval> ret = new ArrayList<>();
		
		for (Interval interval : intervals) {
			
			
			
			
		}

		return null;
	}

	public static List<Interval> L(Interval... i) {
		return new ArrayList<Interval>(Arrays.asList(i));
	}

	public static Interval I(int start, int end) {
		return new Interval(start, end);
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
