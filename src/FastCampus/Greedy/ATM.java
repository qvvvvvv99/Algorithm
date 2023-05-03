package FastCampus.Greedy;

import java.util.*;

// BJAlgo.BOJ 11399��
public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] ary = new int[num];
		int sum = 0, waitTime = 0;
		
		for(int i = 0; i < num; i++) {
			ary[i] = sc.nextInt();
		}
		
		Arrays.sort(ary);
		
		for(int i = 0; i < num; i++) {
			sum += waitTime+ary[i];
			waitTime += ary[i];
		}
		
		System.out.println(sum);
	}

}
