package BJAlgo.Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18111 {
	static int N, M, B;
	static int[][] block;
	static int minSec = Integer.MAX_VALUE;
	static int[] s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int max = 0;
		
		block = new int[N][M];
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			for(int j = 0; j < M; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
				if(block[i][j] > max)
					max = block[i][j];
			}
		}
		s = new int[max+1];
		
		BF(max);
		int cnt;
		for(cnt = max; cnt >= 0; cnt--) {
			if(s[cnt] == minSec)
				break;
		}
		System.out.println(minSec+" "+ cnt);
	}
	
	public static void BF(int end) {
		int res = 0;
		
		for(int l = 0; l <= end; l++) {
			int sum = 0;
			int under = 0;
			int upper = 0;
			int sec = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					sum += (block[i][j] - l);
					if(block[i][j] > l)
						upper += (block[i][j] - l);
					else
						under += (l - block[i][j]);
				}
			}
			if(sum + B < 0) {
				s[l] = -1;
				continue;
			}
			else {
				sec += upper*2;
				sec += under;
				if(sec < minSec) {
					minSec = sec;
				}
				s[l] = sec;
			}
		}
	}
}
