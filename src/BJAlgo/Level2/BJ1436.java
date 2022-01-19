package BJAlgo.Level2;

import java.util.*;

// BJ1436 영화감독 숌
// N번째로 작은 666이 들어가는 숫자

public class BJ1436 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		String str = "666";
		int temp = 666;
		
		while(cnt < N) {
			if(Integer.toString(temp).contains(str))
				cnt++;
			temp++;
		}
		System.out.println(temp-1);
	}

}
