package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13975 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringBuffer sb = new StringBuffer();
		long res;
		
		for(int tc = 0; tc < T; tc++) {
			res = 0;
			N = Integer.parseInt(br.readLine());
			pq.clear();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				pq.add(Long.parseLong(st.nextToken()));
			
			while(true) {
				long sum = pq.poll() + pq.poll();
				res += sum;
				if(pq.isEmpty())
					break;
				pq.add(sum);
			}
			
			sb.append(res + "\n");
		}
		
		System.out.print(sb);
	}

}
