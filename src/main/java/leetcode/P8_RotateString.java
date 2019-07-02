package leetcode;
public class P8_RotateString {

	public static void main(String[] args) {

		char[] str = "abcdefg".toCharArray();		
		rotateString(str, 3);
		System.out.println(str);
		
		str = "abcdefg".toCharArray();
		rotateString(str, 0);
		System.out.println(str);
		
		str = "abcdefg".toCharArray();
		rotateString(str, 1);
		System.out.println(str);
		
		str = "abcdefg".toCharArray();
		rotateString(str, 2);
		System.out.println(str);
		
		str = "abcdefg".toCharArray();
		rotateString(str, 10);
		System.out.println(str);
		

		str = "".toCharArray();
		rotateString(str, 10);
		System.out.println(str);
		
		str = "ubuntu".toCharArray();
		rotateString(str, 6);
		System.out.println(str);
		
		str = "cppjavapy".toCharArray();
		rotateString(str, 25);
		System.out.println(str);

	}

	public static void rotateString(char[] r, int offset) {
		
		
		if(offset<=0 || r.length<=0){
			return;
		}
		
		offset = offset >= r.length ?(offset%r.length):offset;
		
		if(offset<=0 || r.length<=0){
			return;
		}
		
		
		int startIndex=0;
		int endIndex = r.length - offset - 1;

		
		swap(r,startIndex,endIndex);

		startIndex=r.length - offset;
		endIndex = r.length - 1;
		swap(r,startIndex,endIndex);

		startIndex = 0;
		endIndex = r.length - 1;
		swap(r,startIndex,endIndex);
	}
	
	public static void swap(char[] r,int startIndex,int endIndex){
		int len= (endIndex - startIndex)/2;
		for (int i = 0; i <= len; i++) {
			char s = r[startIndex+i];
			r[startIndex + i] = r[endIndex - i];
			r[endIndex - i] = s;
		}
	}

}
