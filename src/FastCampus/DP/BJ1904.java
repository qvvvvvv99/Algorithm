package FastCampus.DP;

// BJ 1904번 01타일
// 동적프로그래밍 : 수학적 규칙을 통해 점화식 찾기

import java.util.*;

public class BJ1904 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] ary = new double[N+1];
		
		ary[1] = 1;	//  1
		if(N != 1)
			ary[2] = 2;	// 00, 11
		for(int i = 3; i <= N; i++) 
			ary[i] = (ary[i-1] + ary[i-2])%15746;	// 값이 매우 커지기 때문에 미리 나눠주기
		
		System.out.println((int)ary[N]);
	}

}
