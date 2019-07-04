package lintcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class P147_NarcissisticNumber {

	public static void main(String[] args) {
		
		System.out.println(getNarcissisticNumbers(0));
		System.out.println(getNarcissisticNumbers(1));
		System.out.println(getNarcissisticNumbers(2));
		System.out.println(getNarcissisticNumbers(3));
	}

	public static List<Integer> getNarcissisticNumbers(int n) {

		if (n <= 0) {
			return Collections.emptyList();
		}

		List<Integer> r = new LinkedList<Integer>();

		int start = (int) Math.pow(10, n - 1);
		int end = (int) Math.pow(10, n);
		
		start = start==1?0:start;

		for (int i = start; i < end; i++) {
			if(i == getNarcissistic(i,n)){
				r.add(i);
			}
		}

		return r;
	}
	
	public static int getNarcissistic(int num,int n){
		
		int i = num;
		int sum=0;
		while( i > 0){
			
			sum += Math.pow(i%10,n);
			
			i = i/10;
		}
		return sum;
	}
}
