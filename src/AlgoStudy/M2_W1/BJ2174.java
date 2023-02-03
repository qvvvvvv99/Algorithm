package AlgoStudy.M2_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2174 {
	static int A, B, N, M;
	static int[][] map;
	static int[][] robot;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[B][A];
		robot = new int[N+1][3];
		
		int y, x, dir = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			switch(st.nextToken().charAt(0)) {
			case 'N' : dir = 0; break;
			case 'E' : dir = 1; break;
			case 'S' : dir = 2; break;
			case 'W' : dir = 3; break;
			}
			map[B-x][y-1] = i;
			robot[i][0] = B - x;
			robot[i][1] = y - 1;
			robot[i][2] = dir;
		}
		
		int idx = 0, rot, error = 0;
		char cmd;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken());
			cmd = st.nextToken().charAt(0);
			rot = Integer.parseInt(st.nextToken());
			error = simulation(idx, cmd, rot);
			if(error >= 0)
				break;
		}
		
		if(error < 0)
			System.out.println("OK");
		else if(error == 0)
			System.out.println("Robot "+ idx + " crashes into the wall");
		else
			System.out.println("Robot "+ idx + " crashes into robot " + error);
	}

	static int simulation(int idx, char cmd, int rot) {
		for(int i = 0; i < rot; i++) {
			int dir = robot[idx][2];
			if(cmd == 'L') {
				dir--;
				if(dir < 0)
					dir = 3;
				robot[idx][2] = dir;
			}
			else if(cmd == 'R') {
				dir++;
				if(dir == 4)
					dir = 0;
				robot[idx][2] = dir;
			}
			else {
				int nx = robot[idx][0] + dx[dir];
				int ny = robot[idx][1] + dy[dir];
				if(nx < 0 || nx >= B || ny < 0 || ny >= A) 
					return 0;
				if(map[nx][ny] > 0)
					return map[nx][ny];
				map[nx][ny] = idx;
				map[robot[idx][0]][robot[idx][1]] = 0;
				robot[idx][0] = nx;
				robot[idx][1] = ny;
			}
		}
			
		return -1;
	}
}
