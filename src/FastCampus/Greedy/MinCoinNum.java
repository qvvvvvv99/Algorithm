package FastCampus.Greedy;

import java.util.*;

public class MinCoinNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		int[] coinList = {500, 100, 50, 10};
		int[] coinCount = new int[4];
		int totalCoinCount = 0;
		
		for(int i = 0; i < 4; i++) {
			coinCount[i] = value / coinList[i];
			totalCoinCount += coinCount[i];
			value -= coinCount[i] * coinList[i];
			System.out.println(coinList[i] + " : " + coinCount[i]);
		}
		System.out.println(totalCoinCount);
	}

}
