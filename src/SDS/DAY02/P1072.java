package SDS.DAY02;

import java.util.Scanner;

public class P1072 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long X = sc.nextLong();
		long Y = sc.nextLong();
		long res = 0;
		long Z = Y*100/X;
		
		if(Z >= 99)
			res = -1;
		else {
			long min = 0;
			long max = X;
			while(true) {
				long mid = (min + max) / 2;
				long newRate = (Y+mid)*100/(X+mid);
				if(newRate > Z)
					max = mid - 1;
				else if(newRate <= Z)
					min = mid + 1;
				if(min > max) {
					res = min;
					break;
				}
			}
		}
		
		System.out.println(res);
	}

}
