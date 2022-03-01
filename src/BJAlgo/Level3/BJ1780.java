package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ1780 {
	static int ary[][];
	static int cnt[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ary = new int[N][N];
		cnt = new int[3];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j = 0; j < N; j++)
				ary[i][j] = Integer.parseInt(st.nextToken());
		}
		check(0,0,N);
		br.close();
		
		for(int i = 0; i < 3; i++)
			System.out.println(cnt[i]);
	}
	
	public static void check(int y, int x, int size) {
		int n = ary[y][x];
		for (int i = y; i < y+size; i++) {
			for(int j = x; j < x+size; j++) {
				if(n != ary[i][j]) {
					size /= 3;
					check(y,x, size);
					check(y,x+size, size);
					check(y,x+size*2, size);
					check(y+size,x, size);
					check(y+size,x+size, size);
					check(y+size,x+size*2, size);
					check(y+size*2,x, size);
					check(y+size*2,x+size, size);
					check(y+size*2,x+size*2, size);
					return;
				}
			}
		}
		cnt[n+1]++;
	}

}
