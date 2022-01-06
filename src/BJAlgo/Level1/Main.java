package BJAlgo.Level1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int count = 0;
		int min = 5000;
		int temp;
		
		for(int i = 0; i <= input / 5; i++) {
			temp = input - 5*i;
			count = i;
			count += temp / 3;
			temp = temp % 3;
			if(temp == 0) {
				if(min > count)
					min = count;
			}
		}
		if(min != 5000)
			System.out.println(min);
		else
			System.out.println("-1");
	}	
}