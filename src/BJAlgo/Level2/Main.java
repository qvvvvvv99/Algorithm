package BJAlgo.Level2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		ArrayList<Integer> ary = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			ary.add(sc.nextInt());
		}
		//Arrays.sort(ary); -> 시간초과
		Collections.sort(ary);
		
		for(int value: ary)
			sb.append(value).append('\n');
		System.out.println(sb);
	}
}