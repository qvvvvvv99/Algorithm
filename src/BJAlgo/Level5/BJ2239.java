package BJAlgo.Level5;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ2239 {
	static int[][] map = new int[9][9];
	static ArrayList<Point> list = new ArrayList<>();
	static boolean flag = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String line;
		for(int i = 0; i < 9; i++) {
			line = sc.next();
			for(int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j)-'0';
				if(map[i][j] == 0) 
					list.add(new Point(i,j));
			}
		}
		
		sol(0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void sol(int idx) {
		if(idx == list.size()) {
			flag = true;
			return;
		}
		
		boolean[] check = new boolean[10];
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		checkNum(x, y, check);
		
		for(int i = 1; i <= 9; i++) {
			if(!check[i]) {
				map[x][y] = i;
				idx++;
				sol(idx);
				if(flag)
					return;
				idx--;
				map[x][y] = 0;
			}
		}
	}
	
	static void checkNum(int x, int y, boolean[] check) {
		for(int i = 0; i < 9; i++) {
			check[map[x][i]] = true;
			check[map[i][y]] = true;
		}
		
		x /= 3;
		y /= 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				check[map[i+x*3][j+y*3]] = true;
			}
		}
	}
}
