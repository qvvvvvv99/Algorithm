package AlogStudy.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ20056 {
	static int N, M, K;
	static int[][] cnt;
	static ArrayList<FireBall> fireballs;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		fireballs = new ArrayList<>();
		cnt = new int[N+1][N+1];
		
		int r, c, m, s, d;
		for(int i = 0; i < M; i++) {
			 st = new StringTokenizer(br.readLine());
			 r = Integer.parseInt(st.nextToken());
			 c = Integer.parseInt(st.nextToken());
			 m = Integer.parseInt(st.nextToken());
			 s = Integer.parseInt(st.nextToken());
			 d = Integer.parseInt(st.nextToken());
			 fireballs.add(new FireBall(r, c, m, s, d));
			 cnt[r][c]++;
		}
		
		for(int i = 0; i < K; i++) {
			move();
			check();
		}
		
		int res = 0;
		for(int i = 0; i < fireballs.size(); i++)
			res += fireballs.get(i).m;
		
		System.out.println(res);
	}
	
	static void move() {
		int nextRow, nextCol;
		FireBall next;
		for(int i = 0; i < fireballs.size(); i++) {
			next = fireballs.get(i);
			nextRow = next.r + next.s * dx[next.d];
			nextCol = next.c + next.s * dy[next.d];
			nextRow %= N;
			nextCol %= N;
			if(nextRow <= 0)
				nextRow += N;
			if(nextCol <= 0)
				nextCol += N;
			cnt[next.r][next.c]--;
			cnt[nextRow][nextCol]++;
			fireballs.get(i).r = nextRow;
			fireballs.get(i).c = nextCol;
		}
	}

	static void check() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(cnt[i][j] > 1) {
					int m = 0, s = 0, d = 0, dFlag = 0, c = 0, curr = 0;
					FireBall del;
					while(curr < fireballs.size()) {
						if(fireballs.get(curr).r == i && fireballs.get(curr).c == j) {
							del = fireballs.remove(curr);
							if(m == 0)
								dFlag = del.d % 2;
							m += del.m;
							s += del.s;
							d = del.d % 2;
							c++;
							if(d != dFlag)
								dFlag = -1;
						}
						else
							curr++;
					}
					cnt[i][j] = 0;
					if(m / 5 == 0)
						continue;
					devide(i, j, m/5, s/c, dFlag);
				}
			}
		}
	}
	
	static void devide(int x, int y, int m, int s, int d) {
		cnt[x][y] = 4;
		if (d == -1)
			d = 1;
		else 
			d = 0;
		for(; d < 8; d+=2) 
			fireballs.add(new FireBall(x, y, m, s, d));
	}
}

class FireBall{
	int r;
	int c;
	int m;
	int s;
	int d;
	
	FireBall(int r, int c, int m, int s, int d){
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
