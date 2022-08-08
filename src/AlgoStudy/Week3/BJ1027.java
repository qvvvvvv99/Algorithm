package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1027 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N + 1];
		float[][] lean = new float[N + 2][N + 2];
		int max = 0;
		float l;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			height[i] = Integer.parseInt(st.nextToken());
		// x 좌표에 대하여 두 좌표간 기울기를 나타내는 이차원 배열 만들기
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				l = (float)(height[j] - height[i]) / (j - i);
				lean[i][j] = l;
				lean[j][i] = l;
			}
		}

		if (N == 1)
			max = 0;
		else if (N == 2)
			max = 1;
		else {
			// 최대 50개의 건물에 대하여 볼 수 있는 건물의 수를 구한다.
			// 기울기 이차원 배열을 토대로 기울기가 증가하는 수를 파악 (같아도 안됨)
			for (int i = 1; i <= N; i++) {
				int cnt;
				if (i > 1 && i < N)
					cnt = 2;
				else
					cnt = 1;
				l = lean[i][i - 1];
				// 양쪽으로 독립된 경우로 탐색
				for (int j = i - 2; j > 0; j--) {
					if (lean[i][j] < l) {
						cnt++;
						l = lean[i][j];
					}
				}
				l = lean[i][i + 1];
				for (int j = i + 2; j <= N; j++) {
					if (lean[i][j] > l) {
						cnt++;
						l = lean[i][j];
					}
				}
				// 가장 증가하는 횟수가 많은 것이 많은 건물을 볼 수 있는 것
				max = Math.max(max, cnt);
			}

		}
		System.out.println(max);
	}

}
