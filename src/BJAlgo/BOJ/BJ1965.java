package BJAlgo.BOJ;

import java.util.Scanner;

public class BJ1965 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ary = new int[n+1];
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++)
            ary[i] = sc.nextInt();

        int max;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            max = 0;
            for(int j = i-1; j >= 1; j--){
                if(ary[i] <= ary[j])
                    continue;
                max = Math.max(dp[j], max);
            }
            dp[i] = max+1;
        }

        max = dp[1];
        for(int i = 2; i <= n; i++)
            max = Math.max(max, dp[i]);
        System.out.println(max);
    }
}
