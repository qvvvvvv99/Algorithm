package FastCampus.Search;

// BJ 1668번 트로피 진열

import java.util.*;

public class BJ1668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ary = new int[N];
		int lcnt = 1, rcnt = 1;
		int lmax, rmax;
		
		for(int i = 0; i < N; i++) 
			ary[i] = sc.nextInt();
		
		lmax = ary[0];
		rmax = ary[N-1];
		
		for(int i = 1; i < N; i++) {
			if(ary[i] > lmax) {
				lmax = ary[i];
				lcnt++;
			}
		}
		for(int i = N-1; i >= 0; i--) {
			if(ary[i] > rmax) {
				rmax = ary[i];
				rcnt++;
			}
		}
		
		System.out.println(lcnt);
		System.out.println(rcnt);
	}

}
