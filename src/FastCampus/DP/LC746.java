package FastCampus.DP;

public class LC746 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int step = 3;
		int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1, 1};
		
		System.out.println(minCostClimbingStairs(cost, step));
	}
	
	public static int minCostClimbingStairs(int[] cost, int step) {
		int[] dp = new int[cost.length+1];
		
		for(int i = step; i < dp.length; i++) {
			dp[i] = dp[i-step] + cost[i-step];
			for(int j = step-1; j > 0; j--) {
				dp[i] = Math.min(dp[i-j] + cost[i-j], dp[i]);
			}
		}
		
		return dp[cost.length];
	}
}
