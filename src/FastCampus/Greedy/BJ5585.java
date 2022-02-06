package FastCampus.Greedy;

import java.util.*;

public class BJ5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int price = sc.nextInt();
		int change = 1000 - price;
		int num = 0;
		
		num += change / 500;
		change %= 500;
		num += change / 100;
		change %= 100;
		num += change / 50;
		change %= 50;
		num += change / 10;
		change %= 10;
		num += change / 5;
		change %= 5;
		num += change / 1;
		change %= 1;
		
		System.out.println(num);
	}

}
