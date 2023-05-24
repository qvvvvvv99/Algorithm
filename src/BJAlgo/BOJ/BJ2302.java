package BJAlgo.BOJ;

import java.util.Scanner;

public class BJ2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ary = new int[m+1];
        for(int i = 1; i <= m; i++)
            ary[i] = sc.nextInt();

        int[] dp = new int[41];
        dp[1] = 1;
        dp[2] = 2;
        int res = 1;
        for(int i = 1; i <= m; i++){
            if(ary[i]-ary[i-1] == 1)
                continue;
            res *= (dp[ary[i]-ary[i-1]-1]);
        }
        if(ary[m] != n)
            res *= dp[n-ary[m]];

        System.out.println(res);
    }
}
