package AlgoStudy.M1_W5;

import java.util.Scanner;

public class BJ13335 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n, w, L;
		n = sc.nextInt();
		w = sc.nextInt();
		L = sc.nextInt();
		int[] trucks = new int[n+1];
		int[] intime = new int[n+1];
		
		for(int i = 1; i <= n; i++)
			trucks[i] = sc.nextInt();
		
		int head = 1, tail = 0;
		int sec = 0, sum = 0;
		while(true) {
			sec++;
			if(sec - intime[head] == w) {
				sum -= trucks[head];
				head++;
			}
			if(head > n)
				break;
			if(sum == 0) {
				tail++;
				intime[tail] = sec;
				sum = trucks[tail];
			}
			else if(tail < n && sum + trucks[tail+1] <= L) {
				tail++;
				intime[tail] = sec;
				sum += trucks[tail];
			}
		}
		
		System.out.println(sec);
	}

}
