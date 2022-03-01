package SWMaestro;

import java.util.*;

public class BJ1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] date = sc.nextLine().split(" ");
		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		
		String week[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int ary[][] = {{1,31}, {2,28}, {3,31}, {4,30}, {5,31},{6,30}, {7,31},{8,31},{9,30},{10,31},{11,30},{12,31}};
		int sumDay = 0;
		
		for(int i = 0; i < month-1; i++)
			sumDay+=ary[i][1];
		sumDay+=day;
		
		System.out.println(week[sumDay%7]);
	}

}
