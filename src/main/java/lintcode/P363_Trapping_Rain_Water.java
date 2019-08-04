package lintcode;


public class P363_Trapping_Rain_Water {

	public static void main(String[] args) {

//		System.out.println(generateParenthesis(2));

		System.out.println(I(0,1,0));
		
		System.out.println(I(0,1,0,2,1,0,1,3,2,1,2,1));

	}
	
	public static int I(int...height){
		return trapRainWater(height);
	}

    /**
     * @param heights: a list of integers
     * @return: a integer
     */
    public static int trapRainWater(int[] heights) {
    	return 0;
    }

}
