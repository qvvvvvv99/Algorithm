package AlgoStudy.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14890 {
	static int N, L;
	static int[][] map;
	static boolean[][] road;
	static int res;
	static boolean flag;
	static boolean[] line;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		road = new boolean[N][2]; // 0 : 가로, 1 : 세로
		for (int i = 0; i < N; i++)
			Arrays.fill(road[i], true);
		res = N * 2;
		line = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (j > 0 && road[i][0] == true) {
					if (Math.abs(map[i][j] - map[i][j - 1]) > 1) {
						road[i][0] = false;
						res--;
					}
				}
				if (i > 0 && road[j][1] == true) {
					if (Math.abs(map[i][j] - map[i - 1][j]) > 1) {
						road[j][1] = false;
						res--;
					}
				}
			}
		}
		check();

		System.out.println(res);
	}

	static void check() {
		for (int i = 0; i < N; i++) {
			flag = true;
			// 가로 체크
			Arrays.fill(line, false);
			if (road[i][0] == true) {
				for (int j = 1; j < N; j++) {
					if (map[i][j] != map[i][j - 1]) {
						if (map[i][j] > map[i][j - 1]) { // 현재 높이가 더 크므로 앞 경사로를 놓아야 한다.
							// 경사로를 놓을 경우 범위가 벗어나는 경우
							if (j - 1 < L - 1) {
								res--;
								flag = false;
								break;
							}
							// 경사로를 놓아야하는 곳에 높이가 일정하지 않거나 이미 경사로가 존재하는 경우
							for (int k = 1; k <= L; k++) {
								if (line[j-k] == true || map[i][j - 1] != map[i][j - k]) {
									res--;
									flag = false;
									break;
								}
							}

							if (flag == true) { // 경사로를 깔 수 있다면 깔기
								for (int k = 1; k <= L; k++)
									line[j - k] = true;
							}
						} else { // 현재 높이가 더 작으므로 현재부터 경사로를 놓아야한다.
							// 경사로를 놓을 경우 범위가 벗어나는 경우
							if (j > N - L) {
								res--;
								break;
							}
							// 경사로를 놓아야하는 곳에 높이가 일정하지 않거나 이미 경사로가 존재하는 경우
							for (int k = 0; k < L; k++) {
								if (line[j+k] == true || map[i][j] != map[i][j + k]) {
									res--;
									flag = false;
									break;
								}
							}

							if (flag == true) { // 경사로를 깔 수 있다면 깔기
								for (int k = 0; k < L; k++)
									line[j + k] = true;
							}
						}
						if (flag == false)
							break;
					}
				}
			}

			// 세로 체크
			flag = true;
			Arrays.fill(line, false);
			if (road[i][1] == true) {
				for (int j = 1; j < N; j++) {
					if (map[j][i] != map[j - 1][i]) {
						if (map[j][i] > map[j - 1][i]) { // 현재 높이가 더 크므로 앞 경사로를 놓아야 한다.
							// 경사로를 놓을 경우 범위가 벗어나는 경우
							if (j - 1 < L - 1) {
								res--;
								flag = false;
								break;
							}
							// 경사로를 놓아야하는 곳에 높이가 일정하지 않거나 이미 경사로가 존재하는 경우
							for (int k = 1; k <= L; k++) {
								if (line[j-k] == true || map[j - 1][i] != map[j - k][i]) {
									res--;
									flag = false;
									break;
								}
							}

							if (flag == true) { // 경사로를 깔 수 있다면 깔기
								for (int k = 1; k <= L; k++)
									line[j - k] = true;
							}
						} else { // 현재 높이가 더 작으므로 현재부터 경사로를 놓아야한다.
							// 경사로를 놓을 경우 범위가 벗어나는 경우
							if (j > N - L) {
								res--;
								break;
							}
							// 경사로를 놓아야하는 곳에 높이가 일정하지 않거나 이미 경사로가 존재하는 경우
							for (int k = 0; k < L; k++) {
								if (line[j+k] == true || map[j][i] != map[j + k][i]) {
									res--;
									flag = false;
									break;
								}
							}

							if (flag == true) { // 경사로를 깔 수 있다면 깔기
								for (int k = 0; k < L; k++)
									line[j + k] = true;
							}
						}
						if (flag == false)
							break;
					}
				}
			}
		}
	}
}
