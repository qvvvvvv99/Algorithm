package AlgoStudy.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1034 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] lamp = new int[N][M];
		String line;
		int[] zeroCnt = new int[N];

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				lamp[i][j] = line.charAt(j) - '0';
				if (lamp[i][j] == 0) {
					zeroCnt[i]++;
				}
			}
		}

		int K = Integer.parseInt(br.readLine());
		int max = 0;
		int x, y, cnt;
		for(int i = 0; i < N; i++) {
			cnt = 1;
			// 행의 0의 갯수가 열을 바꾸는 횟수인 K 보다 작을시 해당 열은 절대로 모든 불이 들어올 수 없다.
			// 행의 0의 갯수 % 2 != K % 2 라면 해당 열은 절대로 모든 불이 들어올 수 없다.
			if(zeroCnt[i] > K || zeroCnt[i] % 2 != K % 2)
				continue;
			// 현재 행의 배열과 같은 배열을 가지는 행의 수가 불이 켜진 행의 수
			for(x = 0; x < N; x++) {
				if(x == i)
					continue;
				for(y = 0; y < M; y++) {
					if(lamp[i][y] != lamp[x][y])
						break;
				}
				if(y == M)
					cnt++;
			}
			max = Math.max(max, cnt);
		}


		System.out.println(max);
	}
}
