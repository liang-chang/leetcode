package lintcode;

public class P83_SingleNumber {

	public static void main(String[] args) {

		int[] numbers = new int[]{0,0,1};
		System.out.println(singleNumber(numbers));
		

		
	}

    public static int singleNumber(int[] A) {
    	
    	int s=0;
    	for(int n : A){
    		s = s ^ n;
    	}
    	
    	return s;
    }
}
