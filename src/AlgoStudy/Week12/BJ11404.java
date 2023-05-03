package AlgoStudy.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11404 {
	static int[][] map;
	static int[][] d;
	static int N, M;
	static int INF = 10000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N+1][N+1];
		d = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		int a, b, c;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(map[a][b] > c)
				map[a][b] = c;
		}
		
		
		floydWarshall();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(d[i][j] == INF)
					d[i][j] = 0;
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void floydWarshall() {
		// ��� �׷��� �ʱ�ȭ
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				d[i][j] = map[i][j];
		}
		
		// k : ���İ��� ���
		for(int k = 1; k <= N; k++) {
			// i : ��� ���
			for(int i = 1; i <= N; i++) {
				// j : ���� ���
				for(int j = 1; j <= N; j++) {
					if(d[i][k] + d[k][j] < d[i][j])
						d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
}
