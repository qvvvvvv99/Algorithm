package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3 {
	static int result;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < tc; t++) {
			int[] cost = new int[17];
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i < 17; i++)
				cost[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i < 17; i++) {
				int res = 0;
				int num = 0;
				boolean[] check = new boolean[8];
				boolean[] visited = new boolean[17];
				bfs(cost, i, check, visited, res, num);
			}
			int idx = t+1;
			sb.append("#"+ idx + " " + result +"\n");
		}
		System.out.print(sb);

	}
	
	public static void bfs(int[] cost, int root, boolean[] check, boolean[] visited, int res, int num) {
		res += cost[root];
		visit(root, check);
		visited[root] = true;
		num += 1;
		
		int cnt;
		if(num >= N) {
			for(cnt = 0; cnt < 8; cnt++) {
				if (check[cnt] != true)
					break;
			}
			if(cnt == 8) {
				if(result > res)
					result = res;
				return;
			}
		}
		
		for(int i = 1; i < 17; i++) {
			if(visited[i] == false)
				bfs(cost, i, check, visited, res, num);
		}
	}
	
	public static void visit(int root, boolean[] check) {
		switch(root) {
		case 1:
			check[0] = true;
			check[2] = true;
			check[4] = true;
			check[6] = true;
			break;
		case 2:
			check[0] = true;
			check[2] = true;
			check[4] = true;
			check[7] = true;
			break;
		case 3:
			check[0] = true;
			check[2] = true;
			check[5] = true;
			check[6] = true;
			break;
		case 4:
			check[0] = true;
			check[2] = true;
			check[5] = true;
			check[7] = true;
			break;
		case 5:
			check[0] = true;
			check[3] = true;
			check[4] = true;
			check[6] = true;
			break;
		case 6:
			check[0] = true;
			check[3] = true;
			check[4] = true;
			check[7] = true;
			break;
		case 7:
			check[0] = true;
			check[3] = true;
			check[5] = true;
			check[6] = true;
			break;
		case 8:
			check[0] = true;
			check[3] = true;
			check[5] = true;
			check[7] = true;
			break;
		case 9:
			check[1] = true;
			check[2] = true;
			check[4] = true;
			check[6] = true;
			break;
		case 10:
			check[1] = true;
			check[2] = true;
			check[4] = true;
			check[7] = true;
			break;
		case 11:
			check[1] = true;
			check[2] = true;
			check[5] = true;
			check[6] = true;
			break;
		case 12:
			check[1] = true;
			check[2] = true;
			check[5] = true;
			check[7] = true;
			break;
		case 13:
			check[1] = true;
			check[3] = true;
			check[4] = true;
			check[6] = true;
			break;
		case 14:
			check[1] = true;
			check[3] = true;
			check[4] = true;
			check[7] = true;
			break;
		case 15:
			check[1] = true;
			check[3] = true;
			check[5] = true;
			check[6] = true;
			break;
		case 16:
			check[1] = true;
			check[3] = true;
			check[5] = true;
			check[7] = true;
			break;
		}
		
	}
}
