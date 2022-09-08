package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1106 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] city = new int[N][2];	
		int[] customer = new int[C+101];
		
		Arrays.fill(customer, 100001);
		customer[0] = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			city[i][0] = Integer.parseInt(st.nextToken());
			city[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= C + 100; i++) {
			for(int j = 0; j < N; j++) {
				if(i - city[j][1] < 0)
					continue;
				customer[i] = Math.min(customer[i-city[j][1]] + city[j][0], customer[i]);
			}
		}
		
		int min = customer[C];
		for(int i = C+1; i <= C+100; i++)
			min = Math.min(min, customer[i]);
		System.out.println(min);
	}

}
