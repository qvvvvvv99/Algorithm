package AlgoStudy.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14204 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ary = new int[N][M];
		boolean flag = false;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			int n = (ary[i][0]-1) / M;
			for(int j = 1; j < M; j++) {
				if((ary[i][j]-1)/M != n) {
					flag = true;
					break;
				}
			}
			if(flag == true)
				break;
		}
		
		if(flag == false) {
			for(int j = 0; j < M; j++) {
				int n = ary[0][j] % M;
				for(int i = 1; i < N; i++) {
					if(ary[i][j] % M != n) {
						flag = true;
						break;
					}
				}
				if(flag == true)
					break;
			}
		}
		
		int res = flag ? 0 : 1;
		System.out.println(res);
	}

}
