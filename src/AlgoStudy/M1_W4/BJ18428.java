package AlgoStudy.M1_W4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ18428 {
	static int N, tCnt = 0;
	static char[][] map;
	static int[][] cnt;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] teacher = new int[5][2];
	static boolean flag;
	static ArrayList<Point> p = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		cnt = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					teacher[tCnt][0] = i;
					teacher[tCnt][1] = j;
					tCnt++;
				}
			}
		}
		
		search();
		if(p.size() > 3)
			flag = true;
		if(!flag) {
			int num = 3;
			int x, y;
			for(int i = 0; i < p.size(); i++) {
				x = p.get(i).x;
				y = p.get(i).y;
				makeO(x, y);
				num--;
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(cnt[i][j] > 0) {
						if(num == 0) {
							flag = true;
							break;
						}
						makeO(i, j);
					}
				}
				if(flag)
					break;
			}
		}
		if(flag)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	
	static void search() {
		int x, y, nx, ny;
		
		for(int i = 0; i < tCnt; i++) {
			x = teacher[i][0];
			y = teacher[i][1];
			for(int j = 0; j < 4; j++) {
				nx = x + dx[j];
				ny = y + dy[j];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(map[nx][ny] == 'S') {
					flag = true;
					return;
				}
				
				cnt[nx][ny] = findStu(nx, ny, j);
			}
		}
	}

	static int findStu(int x, int y, int d) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		if(nx < 0 || nx >= N || ny < 0 || ny >= N)
			return 0;
		if(map[nx][ny] =='S') {
			cnt[x][y]++;
			if(cnt[x][y] == 2)
				p.add(new Point(x,y));
			return 1;
		}
		
		return cnt[x][y] += findStu(nx, ny, d);
	}
	
	static void makeO(int x, int y) {
		for(int j=x-1;j>=0;j--) {
			if(map[j][y] == 'S' || map[j][y] == 'T')
				break;
			cnt[j][y]--;
		}
		for(int j=x+1;j<N;j++) {
			if(map[j][y] == 'S' || map[j][y] == 'T')
				break;
			cnt[j][y]--;
		}
		for(int j=y-1;j>=0;j--) {
			if(map[x][j] == 'S' || map[x][j] == 'T')
				break;
			cnt[j][y]--;
		}
		for(int j=y+1;j<N;j++) {//¿ì
			if(map[x][j] == 'S' || map[x][j] == 'T')
				break;
			cnt[j][y]--;
		}
	}
}
