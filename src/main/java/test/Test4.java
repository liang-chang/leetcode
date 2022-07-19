package test;

public class Test4 {

    public static void main(String[] args) {
        int[][] nums = {{0}, {2}, {4}, {6}, {8}, {9,2}};
        test(nums);

        String[][] nums2 = {{"0"}, {"2"}, {"4"}, {"6"}, {"8"}, {"9","2"}};
        test(nums2);

        int[][] nums3 =null;
        test(nums3);

    }

    static void test(int[][] nums){
        System.out.println(nums);

        System.out.println(nums[0].length);
        System.out.println(nums[nums.length-1].length);
    }

    static void test(String[][] nums){
        System.out.println(nums);

        System.out.println(nums[0].length);
        System.out.println(nums[nums.length-1].length);
    }

}
