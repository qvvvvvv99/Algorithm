import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k= sc.nextInt();
		int[] ary = new int[N];
		
		for(int i = 0; i < N; i++) {
			ary[i] = sc.nextInt();
		}
		
		Arrays.sort(ary);
		
		System.out.println(ary[N-k]);
	}

}
