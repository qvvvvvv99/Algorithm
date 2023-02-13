package AlgoStudy.M2_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4485 {
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int idx = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			idx++;
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sb.append("Problem ").append(idx).append(": ").append(bfs(map)).append("\n");
		}
		
		System.out.print(sb);
	}

	static int bfs(int[][] map) {
		int[] res = new int[N*N];
		Arrays.fill(res, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, map[0][0]));
		res[0] = map[0][0];
		
		Node curr;
		int nx, ny;
		while(!pq.isEmpty()) {
			curr = pq.poll();
			for(int i = 0; i < 4; i++) {
				nx = curr.x + dx[i];
				ny = curr.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if(res[nx*N + ny] > res[curr.x*N + curr.y]+map[nx][ny]) {
					res[nx*N + ny] = res[curr.x*N + curr.y]+map[nx][ny];
					pq.add(new Node(nx, ny, map[nx][ny]));
				}
			}
		}
		
		return res[N*N-1];
	}
}

class Node implements Comparable<Node>{
	int x;
	int y;
	int price;
	
	Node(int x, int y, int price){
		this.x = x;
		this.y = y; 
		this.price = price;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return node.price - this.price;
	}
}