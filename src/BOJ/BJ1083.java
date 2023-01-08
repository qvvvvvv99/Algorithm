package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1083 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// sol();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ary = new int[N];
		for (int i = 0; i < N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			int max = ary[i];
			int idx = i;
			for (int j = i+1; j <= S+i; j++) {
				if (j >= N)
					break;
				if (max < ary[j]) {
					max = ary[j];
					idx = j;
				}
			}
			for (int j = idx; j > i; j--)
				ary[j] = ary[j - 1];
			S -= idx - i;
			ary[i] = max;

			if (S == 0)
				break;
		}

		StringBuffer sb = new StringBuffer();
		for (int i : ary)
			sb.append(i).append(" ");
		System.out.println(sb);
	}

	// 왜 안될까??
	void sol() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		int S = Integer.parseInt(br.readLine());

		ArrayList<Integer> sort = new ArrayList<>(list);
		Collections.sort(sort, Collections.reverseOrder());

		// cnt : 확정된 자리 수
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			// i번째 가질 수 있는 최대 수
			int max = sort.get(i);
			// 배열에서 max의 인덱스번호
			int idx = list.indexOf(max);
			// idx - cnt : 해당 수가 이동해야할 거리
			if (idx == cnt) {
				cnt++;
				continue;
			}
			if (S >= idx - cnt) {
				// 이동
				list.remove(idx);
				list.add(cnt, max);
				S -= (idx - cnt);
				if (S == 0)
					break;
				cnt++; // 자리수 갱신
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i : list)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}
