package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];
		// 총 비용 저장
		int cost = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			m[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			cost += c[i];
		}

		// 메모리 크기에 따라 최소의 비용 -> M의 크기가 매우 크기에 많은 반복 요구
		// 비용에 따라 확보 가능한 최대 메모리 크기
		// 점화식 : dp[cost] = max(dp[cost], dp[cost - c[i]] + m[i])
		int dp[] = new int[cost + 1];
		for (int i = 1; i <= N; i++) {
			// 만약 c[0] -> cost 순으로 진행한다면, i번째 app을 여러 번 사용.
			// 역순으로 진행해야 dp[j-c[i]]는 i번째 app을 사용하지 않은 cost.
			for (int j = cost; j >= c[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
			}
		}
		
		// 비용에 따라 확보가능한 최대의 메모리 크기를 저장한 dp 배열에서 가장 먼저 M 이상의 메모리를 가지는 비용이 최소 비용이 된다.
		int res;
		for(res = 0; res <= cost; res++) {
			if(dp[res] >= M)
				break;
		}
		
		System.out.println(res);
	}

}
