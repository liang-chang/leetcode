package leetcode;

import java.util.Deque;
import java.util.LinkedList;

class P12_Min_Stack {

	public static void main(String[] args) {

		MinStack s = new MinStack();
		s.push(1);
		s.pop();
		s.push(2);
		s.push(3);
		s.min();
		s.push(1);
		s.min();

		s = new MinStack();
		s.push(1);
		s.min();
		s.push(2);
		s.min();
		s.push(3);
		s.min();

	}

	public static class MinStack {

		private Deque<Integer>	stack		= null;

		private Deque<Integer>	minStack	= null;

		public MinStack() {
			stack = new LinkedList<>();
			minStack = new LinkedList<>();
		}

		public void push(int number) {

			stack.addLast(number);

			if (minStack.isEmpty()) {
				minStack.addLast(number);
				return;
			}

			int min = minStack.peekLast();

			if (number < min) {
				minStack.addLast(number);
				return;
			}

			minStack.addLast(min);
		}

		public int pop() {

			Integer ret = stack.pollLast();

			minStack.pollLast();

			System.out.println(ret);

			return ret;

		}

		public int min() {

			int r = minStack.peekLast();

			System.out.println(r);

			return r;
		}
	}
}
