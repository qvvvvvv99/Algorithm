package AlgoStudy.Week19;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;

import javax.management.Query;

public class BJ3190 {
	static int N, K, L;
	static int[][] map;	// 0 : ºó°Å, 1 : ¹ì, 2 : »ç°ú
	static int[] rotSec;
	static char[] rotDir;	// L : ¿Þ(-1), R : ¿À(+1)
	static int dir = 1;	// 0 : À§, 1 : ¿À, 2 : ¾Æ·¡, 3 : ¿Þ
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		map[0][0] = 1;
		int x, y;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 2;
		}
		
		L = Integer.parseInt(br.readLine());
		rotSec = new int[L];
		rotDir = new char[L];
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			rotSec[i] = Integer.parseInt(st.nextToken());
			rotDir[i] = st.nextToken().charAt(0);
		}
		
		System.out.println(sol());
	}
	
	static int sol() {
		int res = 0;
		int nx = 0, ny = 0;
		Deque<Point> dq = new LinkedList<>();
		dq.add(new Point(0, 0));
		int L_cnt = 0;
		
		while(true) {
			Point p = dq.peekFirst();
			nx = p.x + dx[dir];
			ny = p.y + dy[dir];
			res++;
			if(nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;
			if(map[nx][ny] == 1)
				break;
			// »ç°ú°¡ ¾ø´Ù
			if(map[nx][ny] == 0) { 
				p = dq.pollLast();
				map[p.x][p.y] = 0;
			}
			map[nx][ny] = 1;
			dq.addFirst(new Point(nx, ny));
			
			if(L_cnt < L && res == rotSec[L_cnt]) {
				if(rotDir[L_cnt] == 'L') {
					dir--;
					if(dir < 0)
						dir = 3;
				}
				else {
					dir++;
					dir %= 4;
				}
				L_cnt++;
			}
		}
		
		return res;
	}

}
