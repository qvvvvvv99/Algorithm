package FastCampus.DP;

import java.util.*;

public class Fibonacci5 {
	// BOJ 10870번
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		version1(n);
		version2(n);
	}

	public static void version1(int n) {
//		Version1. 배열 사용
		if (n != 0) {
			int[] ary = new int[n + 1];
			ary[0] = 0;
			ary[1] = 1;

			for (int i = 2; i <= n; i++) {
				ary[i] = ary[i - 1] + ary[i - 2];
			}
			System.out.println(ary[n]);
		} else
			System.out.println("0");
	}

	public static void version2(int n) {

//		Version2. ArrayList 사용
		ArrayList<Integer> ary = new ArrayList<>();
		ary.add(0);
		ary.add(1);

		for (int i = 2; i <= n; i++)
			ary.add(ary.get(i - 2) + ary.get(i - 1));
		
		System.out.println(ary.get(n));
	}
}