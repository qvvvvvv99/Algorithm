package FastCampus.Recursive;

//BJ 2747번 피보나치 수

import java.util.*;

public class BJ2747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ary[] = new int[n+1];
        ary[0] = 0; ary[1] = 1;
        
        for(int i = 2; i <= n; i++){
            ary[i] = ary[i-1] + ary[i-2];
        }
        
		System.out.println(ary[n]);
//		System.out.println(fibo(n));
	}
	
	// 재귀함수
	// 증복 계산이 많아진다. -> 시간초과  -> 반복문이 더 효율적!!
	// 2의 n 제곱 만큼 연산
	public static int fibo(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		return fibo(n-1) + fibo(n-2);
	}

}
