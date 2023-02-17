package AlgoStudy.M2_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1446 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		ArrayList<Road>[] highway = new ArrayList[D+1];
		for(int i = 0; i <= D; i++) {
			highway[i] = new ArrayList<>();
		}
		int u, v, d;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			if(v-u <= d || u > D || v > D)
				continue;
			highway[v].add(new Road(u, d));
		}
		
		int[] distance = new int[D+1];
		Arrays.fill(distance, 100000001);
		distance[0] = 0;
		for(int i = 1; i <= D; i++) {
			int cnt = highway[i].size();
			if(cnt > 0) {
				for(int j = 0; j < cnt; j++) {
					Road road = highway[i].get(j);
					if(distance[i] > distance[road.s] + road.d)
						distance[i] = distance[road.s] + road.d;
				}
				distance[i] = Math.min(distance[i], distance[i-1] + 1);
			}else {
				distance[i] = distance[i-1] + 1;
			}
		}
		
		System.out.println(distance[D]);
	}

}

class Road{
	int s, d;
	
	Road(int s, int d){
		this.s = s;
		this.d = d;
	}
}
