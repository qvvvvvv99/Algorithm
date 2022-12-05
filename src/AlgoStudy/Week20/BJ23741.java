package AlgoStudy.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ23741 {

	static int N, M, X, Y;
	static HashSet<Integer> hs = new HashSet<>();
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		HashSet<Integer>[] map = new HashSet[N+1];
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
		
		visited = new boolean[N+1][M+1];
		bfs(map);
		
		if(hs.isEmpty())
			hs.add(-1);
		Iterator iter = hs.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
	}
	
	static void bfs(HashSet<Integer>[] map) {
		Queue<route> queue = new LinkedList<>();
		queue.add(new route(X, 0));
		visited[X][0] =  true;
		
		while(!queue.isEmpty()) {
			route curr = queue.poll();
			if(curr.n > Y)
				break;
			else if(curr.n == Y)
				hs.add(curr.v);
			else {
				Iterator iter = map[curr.v].iterator();
				while(iter.hasNext()) {
					int next = (Integer)iter.next();
					if(visited[next][curr.n+1] == true)
						continue;
					queue.add(new route(next, curr.n+1));
					visited[next][curr.n+1] = true;
				}
			}
		}
	}
}

class route{
	int v;
	int n;
	
	route(int v, int n){
		this.v = v;
		this.n = n;
	}
}