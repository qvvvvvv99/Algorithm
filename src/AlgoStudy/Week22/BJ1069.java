package AlgoStudy.Week22;

import java.util.Scanner;

public class BJ1069 {
	static int X, Y, D, T;
	static double res = Double.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		D = sc.nextInt();
		T = sc.nextInt();

		sol();

		System.out.println(res);
	}

	static void sol() {
		double diagoLen = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		int div = 0;

		// 걸어가기
		res = diagoLen;
		div = (int) (diagoLen / D);
		// 한번의 점프가 목적지까지 거리보다 길 때
		if (div == 0) {
			// 점프 한번하고 넘은 거리 돌아오기
			res = Math.min(res, T + D - diagoLen);
			// 두번 꺽어 점프해서 도착하기
			res = Math.min(res, 2 * T);
		} 
		// 한번의 점프가 목적지까지 거리보다 짧을 때
		else {
			// 직전까지 점프하고 걸어서 도착하기
			res = Math.min(res, T * div + diagoLen - D * div);
			// 전전까지 점프하고 두번 꺽어 점프해서 도착하기
			if(T * (div + 1) < res)
				res = T * (div + 1);
		}

	}

}
