package AlgoStudy.Week13;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15686 {
	static int N, M;
	static ArrayList<Point> house, store;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<>();
		store = new ArrayList<>();
		int n;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				n = Integer.parseInt(st.nextToken());
				if(n == 1)
					house.add(new Point(i, j));
				else if(n == 2)
					store.add(new Point(i, j));
			}
		}
		
		boolean[] open = new boolean[store.size()];
		dfs(0, 0, open);
		
		System.out.println(min);
	}
	
	static void dfs(int idx, int num, boolean[] open) {
		if(num == M) {
			int sum = 0;
			for(int i = 0; i < house.size(); i++) {
				int len = Integer.MAX_VALUE;
				
				for(int j = 0; j < store.size(); j++) {
					if(open[j])
						len = Math.min(len, Math.abs(house.get(i).x - store.get(j).x) + Math.abs(house.get(i).y - store.get(j).y));
				}
				sum += len;
			}
			min = Math.min(min, sum);
			return;
		}
		
		for(int i = idx; i < store.size(); i++) {
			open[i] = true;
			dfs(i + 1, num+1, open);
			open[i] = false;
		}
	}

}