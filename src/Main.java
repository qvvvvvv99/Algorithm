import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if(N > 1) {
			ArrayList<Integer> list = new ArrayList<>();
			while(true) {
				int i;
				for(i = 2; i <= (int)Math.sqrt(N); i++) {
					if(N % i == 0) {
						N /= i;
						list.add(i);
						break;
					}
				}
				if(i > (int)Math.sqrt(N)) {
					list.add(N);
					break;
				}
			}
			
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
	}

}
