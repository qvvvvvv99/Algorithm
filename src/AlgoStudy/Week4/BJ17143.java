package AlgoStudy.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17143 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		boolean[] live = new boolean[M];
		Shark[] sharks = new Shark[M];
		for(int i = 0; i < R; i++)
			Arrays.fill(map[i], -1);
		int res = 0;
		
		int r, c, s, d, z;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			sharks[i] = new Shark(i, r, c, s, d, z);
			map[r][c] = i;
		}
		
		for(int col = 0; col < C; col++) {
			for(int row = 0; row < R; row++) {
				if(map[row][col] != -1) {
					res += sharks[map[row][col]].z;
					live[map[row][col]] = true;
					break;
				}
			}
			if(col == C-1)
				break;
			
			for(int j = 0; j < R; j++)
				Arrays.fill(map[j], -1);
			
			for(int j = 0; j < M; j++) {
				if(live[j] == false) {
					// 상어 움직이기
					if(sharks[j].d == 1) {
						if(sharks[j].r - sharks[j].s >= 0) {
							sharks[j].r -= sharks[j].s;
						}else {
							int move = sharks[j].s - sharks[j].r;
							int flag = -1;
							while((float)move / (R-1) > 1) {
								flag *= -1;
								move -= (R-1);
							}
							if(flag > 0) {	
								sharks[j].r = R - 1 - move;
							}else {	// 방향 바뀜 아래로 향함
								sharks[j].d = 2;
								sharks[j].r = move;
							}
						}
					}else if(sharks[j].d == 2) {
						if(sharks[j].r + sharks[j].s <= R-1) {
							sharks[j].r += sharks[j].s;
						}else {
							int move = sharks[j].s - (R- 1 - sharks[j].r);
							int flag = -1;
							while((float)move / (R-1) > 1) {
								flag *= -1;
								move -= (R-1);
							}
							if(flag > 0) {	
								sharks[j].r = move;
							}else {	// 방향 바뀜 위로 향함
								sharks[j].d = 1;
								sharks[j].r = R - 1 - move;
							}
						}
					}else if(sharks[j].d == 3) {
						if(sharks[j].c + sharks[j].s <= C - 1) {
							sharks[j].c += sharks[j].s;
						}else {
							int move = sharks[j].s - (C - 1 - sharks[j].c);
							int flag = -1;
							while((float)move / (C-1) > 1) {
								flag *= -1;
								move -= (C-1);
							}
							if(flag > 0) {	
								sharks[j].c = move;
							}else {// 방향 바뀜 죄로 향함
								sharks[j].d = 4;
								sharks[j].c = C - 1 - move;
							}
						}
					}else {
						if(sharks[j].c - sharks[j].s >= 0) {
							sharks[j].c -= sharks[j].s;
						}else {
							int move = sharks[j].s - sharks[j].c;
							int flag = -1;
							while((float)move / (C-1) > 1) {
								flag *= -1;
								move -= (C-1);
							}
							if(flag > 0) {	
								sharks[j].c = C - 1 - move;
							}else {// 방향 바뀜 우로 향함
								sharks[j].d = 3;
								sharks[j].c = move;
							}
						}
					}
					if(map[sharks[j].r][sharks[j].c] == -1)
						map[sharks[j].r][sharks[j].c] = j;
					// 같은 칸에 상어 존재 시 큰 것이 먹기
					else {
						if(sharks[map[sharks[j].r][sharks[j].c]].z > sharks[j].z) {
							live[j] = true;
						}
						else {
							live[map[sharks[j].r][sharks[j].c]] = true;
							map[sharks[j].r][sharks[j].c] = j;
						}
					}
				}
			}
		}
		
		System.out.println(res);
	}

}

class Shark {
	int idx;
	int r, c;
	int s;
	int d;
	int z;

	Shark(int idx, int r, int c, int s, int d, int z) {
		this.idx = idx;
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}