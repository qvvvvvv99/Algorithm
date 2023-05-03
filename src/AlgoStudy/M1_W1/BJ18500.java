package AlgoStudy.M1_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18500 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited, newvisit;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int min;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = line.charAt(j);
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int height;
		for(int n = 0; n < N; n++) {
			height = R - Integer.parseInt(st.nextToken());
			// ���ʿ��� ����
			if(n % 2 == 0) {
				for(int j = 0; j < C; j++) {
					if(map[height][j] == 'x') {
						map[height][j] = '.';
						break;
					}
				}
			}
			// �����ʿ��� ����
			else {
				for(int j = C-1; j >= 0; j--) {
					if(map[height][j] == 'x') {
						map[height][j] = '.';
						break;
					}
				}
			}
			
			// �ٴڿ��� �̾����� Ŭ������ ���� Ȯ��
			visited = new boolean[R][C];
			for(int j = 0; j < C; j++) {
				if(map[R-1][j] == 'x' && !visited[R-1][j])
					dfs(R-1,j);
			}

			// ���߿� ���ִ� Ŭ������ Ȯ��
			boolean flag = false;
			for(int i = R-2; i >= 0; i--) {
				for(int j = 0; j < C; j++) {
					if(map[i][j] == 'x' && !visited[i][j]) {
						min = 100;
						newvisit = new boolean[R][C];
						moveLen(i, j);
						down(i, j);
						flag = true;
						break;
					}	
				}
				if(flag)
					break;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '.')
				continue;
			if(!visited[nx][ny])
				dfs(nx, ny);
		}
	}
	
	static void moveLen(int x, int y) {
		newvisit[x][y] = true;
		int l;
		for(l = x+1; l < R; l++) {
			if(!newvisit[l][y] && map[l][y] == 'x')
				break;
		}
		min = Math.min(min, l-x-1);
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == '.')
				continue;
			if(!newvisit[nx][ny])
				moveLen(nx, ny);
		}
	}

	static void down(int x, int y) {
		newvisit[x][y] = false;
		map[x][y] = '.';
		map[x+min][y] = 'x';
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if(newvisit[nx][ny])
				down(nx, ny);
		}
	}
}
