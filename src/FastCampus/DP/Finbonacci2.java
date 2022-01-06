package FastCampus.DP;

import java.util.*;

public class Finbonacci2 {
	// BOJ 2748¹ø
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		List<Double> ary = new ArrayList<>();
		ary.add((double) 0);
		ary.add((double) 1);

		for (int i = 2; i <= n; i++)
			ary.add(ary.get(i - 2) + ary.get(i - 1));
		
		System.out.println(ary.get(n));
	}

}
