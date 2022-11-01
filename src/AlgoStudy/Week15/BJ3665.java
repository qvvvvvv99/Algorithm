package AlgoStudy.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3665 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] ary = new int[n];
			st = new StringTokenizer(br.readLine());
			int[] parNum = new int[n + 1];
			for (int i = 0; i < n; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
				parNum[ary[i]] = i;
			}

			boolean[][] childs = new boolean[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++)
					childs[ary[i]][ary[j]] = true;
			}
			int m = Integer.parseInt(br.readLine());
			int par, chi, temp;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				par = Integer.parseInt(st.nextToken());
				chi = Integer.parseInt(st.nextToken());
				if (childs[chi][par] == true) {
					temp = par;
					par = chi;
					chi = temp;
				}

				childs[par][chi] = false;
				childs[chi][par] = true;
				parNum[chi]--;
				parNum[par]++;
			}

			int[] answer = new int[n + 1];
			answer = check(n, childs, parNum);
			if (answer[0] == -1)
				sb.append("IMPOSSIBLE");
			else if (answer[0] == 1)
				sb.append("?");
			else {
				for (int i = 1; i <= n; i++)
					sb.append(answer[i] + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	static int[] check(int n, boolean[][] childs, int[] parNum) {
		int[] res = new int[n+1];
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			if(parNum[i] == 0)
				queue.add(i);
		}
		
		int num, idx = 1;
		while(!queue.isEmpty()) {
			if(queue.size() > 1) {
				res[0] = 1;
				break;
			}
			num = queue.poll();
			res[idx] = num;
			idx++;
			if(idx > n)
				break;
			for(int i = 1; i <= n; i++) {
				if(i == num)
					continue;
				if(childs[num][i] == true) {
					childs[num][i] = false;
					parNum[i]--;
					if(parNum[i] == 0)
						queue.add(i);
				}
			}
		}
		
		if(res[0] == 0 && idx <= n)
			res[0] = -1;
		return res;
	}

}
