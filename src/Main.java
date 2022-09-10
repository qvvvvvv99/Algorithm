import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();	// 고정
		int B = sc.nextInt();	// 가변
		int C = sc.nextInt();	// 판매가격
		int res;
		
		// A + n * B < C * n -> n의 최소
		if(B >= C)
			res = -1;
		else 
			res = A / (C - B) + 1;
		
		System.out.println(res);
	}

}
