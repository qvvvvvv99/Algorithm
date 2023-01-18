package AlgoStudy.M1_W4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ9881 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> hills = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			hills.add(sc.nextInt());
		
		Collections.sort(hills);
		int min = hills.get(0);
		int max = hills.get(N-1);
		
		int res = Integer.MAX_VALUE;
		int price;
		for(int height = min; height <= max-17; height++) {
			price = 0;
			for(int idx = 0; idx < N; idx++) {
				if(hills.get(idx) < height) 
					price += Math.pow((height - hills.get(idx)), 2);
				else if(hills.get(idx) > height+17)
					price += Math.pow((hills.get(idx) - height - 17), 2);
			}
			res = Math.min(res, price);
		}
		
		System.out.println(res);
	}

}
