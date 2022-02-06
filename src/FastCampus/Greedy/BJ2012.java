package FastCampus.Greedy;

import java.util.*;

public class BJ2012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ary[] = new int[N+1];
		long res = 0;
		// 최악의 경우 자료형 크기 생각하기!!
		// int형 4byte 약 -20억~20억
		// long형 8byte 엄청나다....
		
		for(int i = 1; i <= N; i++)
			ary[i] = sc.nextInt();
		
		Arrays.sort(ary);
		
		for(int i = 1; i <= N; i++) 
			res += Math.abs(ary[i] - i);
		
		System.out.println(res);
	}

}
