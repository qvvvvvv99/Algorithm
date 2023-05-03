package BJAlgo.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17952 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] ary = new int[N+1][2];
		int idx = 0;
		int res = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if(num != 0) {
				idx++;
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				ary[idx][0] = A;
				ary[idx][1] = T-1;
			}
			else {
				ary[idx][1]--;
			}
			if(ary[idx][1] == 0) {
				res += ary[idx][0];
				idx--;
			}
		}
		
		System.out.println(res);
	}

}
