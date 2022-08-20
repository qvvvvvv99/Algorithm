package AlgoStudy.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ21757 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] ary = new long[N + 1];	// 배열 입력
		long[] sum = new long[N + 1];	// 입력된 배열까지의 합
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] cnt = new long[3];	// 선에 따라 그을 수 있는 경우의 수(0: 첫번째 선, 1: 두번째선, 2: 세번째선)
		long zeroCnt = 0;			// 합이 0이 되는 곳 -> 각 부분의 합이 0일때 사용

		for (int i = 1; i <= N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			sum[i] = ary[i] + sum[i - 1];
			if(sum[i] == 0)
				zeroCnt++;
		}
		// 전체의 합이 4로 나누어 떨어지지 않으면 합이 같은 네 집합으로 나눌 수 없다.
		if (sum[N] % 4 == 0) {
			long s = sum[N] / 4;

			// 합이 0이라면
			if (s == 0) {
				long res;
				// 각 지점까지의 합이 0인 곳이 n개라면 그중 선을 그을 수 있는 곳은 n-1,
				// 이 n-1개의 선을 그을 수 있는 곳 중에서 3곳을 정하면 4개의 같은 크기의 집합으로 나누어진다. 
				res = (zeroCnt-1)*(zeroCnt-2)*(zeroCnt-3)/6;
				cnt[2] = res;
			}
			// 합이 0이 아니라면
			// 합이 같은 집합을 찾으면 해당 지점에서 선을 긋는 것은 현재 선의 전까지 몇개의 선을 그었는지 파악하여 더해준다.
			else {
				for (int i = 1; i <= N; i++) {
					if (sum[i] == s)
						cnt[0]++;
					if (sum[i] == 2 * s)
						cnt[1] += cnt[0];
					if (sum[i] == 3 * s)
						cnt[2] += cnt[1];
				}
			}
		}

		System.out.println(cnt[2]);

	}

}
