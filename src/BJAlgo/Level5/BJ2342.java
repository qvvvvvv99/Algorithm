package BJAlgo.Level5;

import java.io.*;
import java.util.*;

// 2342 Dance Dance Revolution
public class BJ2342 {

	static ArrayList<Integer> input; // 스텝이 총 몇개인지 모름
	// dp[ i ] [ j ] [ k ] : 왼발(j) 위치, 오른발(k) 위치이고 - i번째 스텝일때 최댓값
	static int[][][] dp; // [ i ] <= 10만
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		input = new ArrayList<Integer>();
		for (;;) {
			int in = Integer.parseInt(st.nextToken());
			if (in==0) break;
			input.add(in);
		}

		N = input.size();
		dp = new int[N+1][5][5];
		
		int ans = DDR(0, 0, 0);
		bw.write(ans + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	static int DDR(int step, int left, int right) {
		// 1. 마지막 스텝 도달하면 끝
		if (step == N)
			return 0;

		// 2. dp에 값이 차있으면 return
		if (dp[step][left][right] != 0) {
			return dp[step][left][right];
		}

		// 3. 가능한 경우의 수 중 가장 적은 경우로 갱신하고 return
		// 왼발 욺직이는 경우 vs 오른발 움직이는 경우
		int leftScore = score(left, input.get(step)) + DDR(step + 1, input.get(step), right); 
		int rightScore = score(right, input.get(step)) + DDR(step + 1, left, input.get(step)); 
		
		return dp[step][left][right] = Math.min(leftScore, rightScore);
	}

    static int score(int from, int to){
    	// 0. 지금 위치를 누르면 1
    	if(from==to) return 1;
    	// 1. 가운데 출발 2
        if(from==0) return 2;
        // 3. 크로스 해서 밟으면 4
        if(Math.abs(from-to) ==2) return 4;
        // 4. 인접 스텝 밟으면 3
        return 3;
    }
}