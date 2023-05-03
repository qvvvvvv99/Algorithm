package BJAlgo.BOJ;

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

	// �� �ȵɱ�??
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

		// cnt : Ȯ���� �ڸ� ��
		int cnt = 0;
		for (int i = 0; i < N - 1; i++) {
			// i��° ���� �� �ִ� �ִ� ��
			int max = sort.get(i);
			// �迭���� max�� �ε�����ȣ
			int idx = list.indexOf(max);
			// idx - cnt : �ش� ���� �̵��ؾ��� �Ÿ�
			if (idx == cnt) {
				cnt++;
				continue;
			}
			if (S >= idx - cnt) {
				// �̵�
				list.remove(idx);
				list.add(cnt, max);
				S -= (idx - cnt);
				if (S == 0)
					break;
				cnt++; // �ڸ��� ����
			}
		}

		StringBuffer sb = new StringBuffer();
		for (int i : list)
			sb.append(i).append(" ");
		System.out.println(sb);
	}
}
