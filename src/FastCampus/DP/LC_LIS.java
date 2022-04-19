package FastCampus.DP;

// Longest Increasing Subsequence(LIC)
public class LC_LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {7,7,7,7,7,7,7};
		
		System.out.println(LIC(nums));
	}
	
	public static int LIC(int[] nums) {
		int[] dp = new int[nums.length];
		
		dp[0] = 1;
		for(int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		return dp[nums.length-1];
	}
}
