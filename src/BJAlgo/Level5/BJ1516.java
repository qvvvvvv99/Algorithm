package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1516 {
	static int N;
	static int[] parent;
	static int[] time;
	static int[] res;
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		time = new int[N+1];
		res = new int[N+1];
		map = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		
		StringTokenizer st;
		int n;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				n = Integer.parseInt(st.nextToken());
				if(n == -1)
					break;
				map[n].add(i);
				parent[i]++;
			}
		}
		
		topology();
		
		for(int i = 1; i <= N; i++)
			System.out.println(res[i]);
	}

	static void topology() {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(parent[i] == 0) {
				queue.add(i);
				res[i] = time[i];
			}
		}
		
		int curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			for(int n : map[curr]) {
				parent[n]--;
				res[n] = Math.max(res[n], res[curr]);
				if(parent[n] == 0) {
					res[n] += time[n];
					queue.add(n);
				}
			}
		}
	}
}
