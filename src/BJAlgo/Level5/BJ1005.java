package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1005 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();

		for (int T = 0; T < tc; T++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] D = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				D[i] = Integer.parseInt(st.nextToken());
			int[] cnt = new int[N + 1];
			ArrayList<Integer>[] map = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				map[i] = new ArrayList<>();

			int s, e;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				cnt[e]++;
				map[s].add(e);
			}
			int direc = Integer.parseInt(br.readLine());
			int[] sec = new int[N + 1];

			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				sec[i] = D[i];
				if (cnt[i] == 0) {
					queue.add(i);
				}
			}

			while (!queue.isEmpty()) {
				int curr = queue.poll();
				
				for (int i: map[curr]) {
					cnt[i]--;
					sec[i] = Math.max(sec[i], sec[curr]+D[i]);
					if (cnt[i] == 0)
						queue.add(i);
				}
			}

			sb.append(sec[direc]).append("\n");
		}

		System.out.print(sb);
	}

}
