package test;

import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {

        int n=5;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = l + i - 1;
                // 计算 dp[i][j]
                System.out.println("("+i+","+j+")");
            }
        }


        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
        map.put("a","b");
        map.put("b","c");


        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}
