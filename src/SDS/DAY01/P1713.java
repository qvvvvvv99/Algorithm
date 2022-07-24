package SDS.DAY01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P1713 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int[] recoCnt = new int[101];
		int[] result = new int[N];

		for (int i = 0; i < R; i++) {
			int rec = sc.nextInt();
			recoCnt[rec]++;
			int j;
			for (j = 0; j < N; j++) {
				if (result[j] == rec) {
					break;
				}
			}
			if (j != N)
				continue;

			int min = 1001;
			for (int k = 0; k < N; k++) {
				if (recoCnt[result[k]] < min)
					min = recoCnt[result[k]];
			}
			for (int count = 0; count < N; count++) {
				// 추천 수가 같은 경우 가장 먼저 들어온 수 버리기
			}

		}

		Arrays.sort(result);

		for (int i = 0; i < N; i++) {
			if (result[i] != 0)
				System.out.print(result[i] + " ");
		}

	}
}
