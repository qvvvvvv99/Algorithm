package AlgoStudy.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ23741 {

	static int N, M, X, Y;
	static ArrayList<Integer> res = new ArrayList<>();
	static boolean[][] visited;
	static HashSet<Integer>[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map = new HashSet[N+1];
		for(int i = 1; i <= N; i++)
			map[i] = new HashSet<Integer>();
		
		int u, v;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			map[v].add(u);
		}
		
		visited = new boolean[N+1][Y+1];
		dfs(X, 0);
		
		Collections.sort(res);
		if(res.isEmpty())
			res.add(-1);
		for(int i = 0; i < res.size(); i++)
			System.out.print(res.get(i)+" ");
	}
	
	static void dfs(int v, int cnt) {
		visited[v][cnt] = true;
		
		if(cnt == Y) {
			res.add(v);
			return;
		}
		
		Iterator iter = map[v].iterator();
		while(iter.hasNext()) {
			int next = (int) iter.next();
			if(!visited[next][cnt+1])
				dfs(next, cnt+1);
		}
	}
}
