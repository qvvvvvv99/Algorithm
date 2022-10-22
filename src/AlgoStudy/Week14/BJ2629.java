package AlgoStudy.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2629 {
	
    public static void main(String[] args) throws NumberFormatException, IOException{
        // TODO Auto-generated method stub
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int weightCnt = Integer.parseInt(br.readLine());
        int[] weight = new int[weightCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < weightCnt; i++){
			weight[i] = Integer.parseInt(st.nextToken());
            sum += weight[i];
        }
        
        boolean[][] dp = new boolean[weightCnt][sum+1];
        dp[0][0] = true;
        dp[0][weight[0]] = true;
        
        for(int i = 1; i < weightCnt; i++) {
        	for(int j = 0; j <= sum; j++) {
        		if(dp[i-1][j] == true) {
        			dp[i][j] = true;
        			dp[i][j+weight[i]] = true;
        			dp[i][Math.abs(j - weight[i])] = true;
        		}
        	}
        }
        
        StringBuffer sb = new StringBuffer();
     	int beadCnt = Integer.parseInt(br.readLine());
     	st = new StringTokenizer(br.readLine());
        for(int i = 0; i < beadCnt; i++){
        	int n = Integer.parseInt(st.nextToken());
        	if(n > sum)
        		sb.append("N ");
        	else if(dp[weightCnt-1][n] == true)
                sb.append("Y ");
            else
                sb.append("N ");
        }    
        System.out.println(sb);
    }
}