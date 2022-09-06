package AlgoStudy.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20057 {
	static int[][] map;
	static int res = 0;
	static int N;
	static int[][] dx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2}, {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};       
	static int[][] dy = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
	static int[] sandRatio ={1,1,2,7,7,2,10,10,5};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		int row = N / 2;
		int col = N / 2;
		int dir = -1;
		int len = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int alpha, total;
		for (int i = 0; i < N - 1; i++) {
			len++;
			for (int j = 0; j < len; j++) {
				col += dir;
				total = 0;
				// 왼쪽 방향
				if (dir == -1) {
					if(map[row][col] >= 10)
						total = move(0, row, col);
					alpha = map[row][col] - total;
					if(col > 0) 
						map[row][col-1] += alpha;
					else
						res += alpha;
				}
				// 오른쪽 방향
				else {
					if(map[row][col] >= 10)
						total = move(2, row, col);
					alpha = map[row][col] - total;
					if(col < N-1)
						map[row][col+1] += alpha;
					else
						res += alpha;
				}
				map[row][col] = 0;
			}

			dir *= -1;

			for (int j = 0; j < len; j++) {
				row += dir;
				total = 0;
				// 아래 방향
				if (dir == 1) {
					if(map[row][col] >= 10)
						total = move(1, row, col);
					alpha = map[row][col] - total;
					if(row < N - 1)
						map[row+1][col] += alpha;
					else
						res += alpha;
				}
				// 위 방향
				else {
					if(map[row][col] >= 10)
						total = move(3, row, col);
					alpha = map[row][col] - total;
					if(row > 0)
						map[row-1][col] += alpha;
					else
						res += alpha;
				}
				map[row][col] = 0;
			}
		}

		// 마지막 젤 윗줄
		for (int i = N - 2; i >= 0; i--) {
			total = 0;
			if(map[0][i] >= 10)
				total = move(0, 0, i);
			alpha = map[0][i] - total;
			if(i > 0) 
				map[0][i-1] += alpha;
			else
				res += alpha;
			map[0][i] = 0;
		}

		System.out.println(res);
	}

	static int move(int dir, int row, int col) {
		int outSum = 0, total = 0;
		int rotRow, rotCol, spreadSand;
		
		for(int rot = 0; rot < 9; rot++) {
			rotRow = row + dx[dir][rot];
			rotCol = col + dy[dir][rot];
			spreadSand = (map[row][col] * sandRatio[rot]) / 100;
			
			if(rotRow < 0 || rotRow >= N || rotCol < 0 || rotCol >= N)
				outSum += spreadSand;
			else
				map[rotRow][rotCol] += spreadSand;
			total += spreadSand;
		}
		
		res += outSum;
		
		return total;
	}
}
