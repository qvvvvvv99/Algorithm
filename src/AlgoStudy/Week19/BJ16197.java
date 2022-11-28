package AlgoStudy.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ16197 {
	public static char[][] board;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int x1, y1, x2, y2;
	static int N, M;
	static Queue<Coin> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		boolean coin1 = false;
		
		board = new char[N][M];
		for(int i = 0; i < N; i++) { 
			String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (str.charAt(j) == 'o') {
                    if (coin1) {
                        x2 = i;
                        y2 = j;
                    } else {
                        x1 = i;
                        y1 = j;
                        coin1 = true;
                    }
                }
            }
		}
		
        queue.add(new Coin(x1, y1, x2, y2, 0));
        
		System.out.println(bfs());
	}

	static public int bfs() {
        while (!queue.isEmpty()) {
            Coin now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx1 = now.x1 + dx[i];
                int ny1 = now.y1 + dy[i];
                int nx2 = now.x2 + dx[i];
                int ny2 = now.y2 + dy[i];
                int cnt = now.cnt + 1;
                if(cnt > 10)
                	break;

                boolean flag = false;
                if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M) {
                    flag = true;
                }
                if (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M) {
                    if (flag)
                        continue;
                    else
                    	return cnt;
                }
                if (flag)
                	return cnt;
                

                if (board[nx1][ny1] == '#' && board[nx2][ny2] == '#')
                	continue;
                if (board[nx1][ny1] == '#') {
                    nx1 = now.x1;
                    ny1 = now.y1;
                }
                if (board[nx2][ny2] == '#') {
                    nx2 = now.x2;
                    ny2 = now.y2;
                }

                queue.add(new Coin(nx1, ny1, nx2, ny2, cnt));
            }
        }

        return -1;
    }
}

class Coin {
    int x1, y1, x2, y2, cnt;

    public Coin(int x1, int y1, int x2, int y2, int cnt) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cnt = cnt;
    }
}