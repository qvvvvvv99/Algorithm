package AlgoStudy.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12947 {
	static int N;
	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] cnt = new int[N+1];
		
		for(int i = 1; i <= N; i++) 
			cnt[i] = Integer.parseInt(st.nextToken());
		
		dfs(N, cnt, 0);
		
		System.out.println(max);
	}

	static void dfs(int n, int[] cnt, int len) {
		cnt[n]--;
		int idx = n-1;
		while(cnt[idx] != 1) {
			len++;
			cnt[idx]--;
			if(idx == 0) {
				idx++;
				break;
			}
			idx--;
		}
		if(cnt[idx] == 1) {
			// 길이 1개일 때 위로 올라가는 선택
			dfs(idx, cnt, len+1);
			cnt[idx]++;
		}
		// 길이 1개일 때 밑으로 돌아가거나 루트 노드를 만나 돌아가는 경우
		while(idx <= N && cnt[idx] != 0) {
			len++;
			cnt[idx]--;
			idx++;
		}
		max = Math.max(max, len);
	}
}
