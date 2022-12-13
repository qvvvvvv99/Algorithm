package AlgoStudy.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1043 {
	static int N, M;
	static boolean[] lie;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int res = M;
		lie = new boolean[N + 1];
		int[] partyNum = new int[M];
		int num = Integer.parseInt(st.nextToken());
		int a = 0;
		Queue<Integer> know = new LinkedList<>();
		for (int i = 0; i < num; i++) {
			a = Integer.parseInt(st.nextToken());
			lie[a] = true;
			know.add(a);
		}
		
		int[][] ary = new int[M][50];
		ArrayList<Integer>[] line = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			line[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[M];
		
		// 각 사람이 몇번째 파티에 참가하는지
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			partyNum[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < partyNum[i]; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
				line[ary[i][j]].add(i);
			}
		}
		
		while(!know.isEmpty()) {
			int l = know.poll();
			for(int i = 0; i < line[l].size(); i++) {
				int x = line[l].get(i);
				if(visited[x])
					continue;
				visited[x] = true;
				res--;
				for(int y = 0; y < partyNum[x]; y++) {
					if(lie[ary[x][y]])
						continue;
					know.add(ary[x][y]);
					lie[ary[x][y]] = true;
				}
			}
		}
		
		System.out.println(res);
	}
}
