package AlgoStudy.Week5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12851 {
	static int N, K;
	static int[] visitedSec = new int[100001];
	static int minSec = 100001;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		Arrays.fill(visitedSec, 100001);

		bfs();

		System.out.println(minSec + "\n" + cnt);
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visitedSec[N] = 0;

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (visitedSec[curr] > minSec)
				break;
			if (curr == K) {
				minSec = visitedSec[curr];
				cnt++;
			}

			if ((curr - 1 >= 0) && (visitedSec[curr - 1] >= visitedSec[curr] + 1)) {
				queue.add(curr - 1);
				visitedSec[curr - 1] = visitedSec[curr] + 1;
			}
			if ((curr + 1 <= 100000) && (visitedSec[curr + 1] >= visitedSec[curr] + 1)) {
				queue.add(curr + 1);
				visitedSec[curr + 1] = visitedSec[curr] + 1;
			}
			if ((curr * 2 <= 100000) && (visitedSec[curr * 2] >= visitedSec[curr] + 1)) {
				queue.add(curr * 2);
				visitedSec[curr * 2] = visitedSec[curr] + 1;
			}
		}
	}
}
