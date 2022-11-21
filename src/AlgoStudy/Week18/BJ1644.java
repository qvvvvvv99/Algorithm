package AlgoStudy.Week18;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ1644 {
	static ArrayList<Integer> primeNum = new ArrayList<>();
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		// N == 1 일때는 항상 0
		System.out.println(N > 1 ? primeNumber() : 0);
	}

	static int primeNumber() {
		boolean[] prime = new boolean[N + 1];

		for (int i = 2; i * i <= N; i++) {
			if (prime[i] == true)
				continue;
			for (int j = i * 2; j <= N; j += i)
				prime[j] = true;
		}

		for (int i = 2; i <= N; i++) {
			if (prime[i] == false)
				primeNum.add(i);
		}
		
		return sol();
	}

	static int sol() {
		int cnt = 0;
		int front = 0, back = 0;
		int sum = primeNum.get(0);

		while (true) {
			if (sum < N) {
				back++;
				if (back >= primeNum.size())
					break;
				sum += primeNum.get(back);
			} else {
				if (sum == N)
					cnt++;
				sum -= primeNum.get(front);
				front++;
				if (front > back)
					break;
			}
		}

		return cnt;
	}
}
