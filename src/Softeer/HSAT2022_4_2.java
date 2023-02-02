package Softeer;

import java.util.*;
import java.io.*;

public class HSAT2022_4_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int[] ary = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			ary[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(ary);
		long mid, left = ary[0];
		long right = ary[N-1] + (long)Math.sqrt(B);
		long res = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (calculate(mid, ary, B)) {
				left = mid + 1;
				res = mid;
			}
			else {
				right = mid - 1;
			}
		}
		// System.out.println(min + " " + upperBound);

		System.out.println(res);
	}
	
	public static boolean calculate(long min, int[] a, long B) {
        long cost = 0;
        for (int i : a) {
            if (i < min) {
                cost += (min - i) * (min - i);
                if (cost > B) return false;
            }
        }
        return true;
    }

}
