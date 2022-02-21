package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ2630 {
	static int[][] map;
	static int[] res = new int[2]; // 0:white 1:blue

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		divide(0, 0, N);

		br.close();
		System.out.println(res[0] + "\n" + res[1]);
	}

	public static void divide(int r, int c, int n) {
		int fir = map[r][c];
		if (n == 1) {
			res[fir]++;
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (fir != map[i + r][j + c]) {
					int nn = n / 2;
					divide(r, c, nn);
					divide(r + nn, c, nn);
					divide(r, c + nn, nn);
					divide(r + nn, c + nn, nn);
					return;
				}
			}
		}

		res[fir]++;
	}

}
