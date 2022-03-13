package FastCampus.Mathematics;

import java.util.ArrayList;
import java.util.Scanner;

public class prime_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> prime = eratos_prime(sc.nextInt());
		
		System.out.println(prime);
		System.out.println(prime.size());
	}

	public static ArrayList<Integer> eratos_prime(int N) {
		int[] list = new int[N+1];
		ArrayList<Integer> prime = new ArrayList<>();
		
		for(int i = 2; i <= N; i++) {
			if(list[i] == 0)
				prime.add(i);
			else
				continue;
			for(int j = i*i; j <= N; j+=i)
				list[j] = 1;
		}
		
		return prime;
	}
}
