package AlgoStudy.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.Collections;
>>>>>>> branch 'master' of https://github.com/qvvvvvv99/Algo.git
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2109 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int p, d;
		PriorityQueue<Lecture> pq = new PriorityQueue<>();
		int maxDay = 0;

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			pq.add(new Lecture(p,d));
			maxDay = Math.max(maxDay, d);
		}
		
		int[] price = new int[maxDay+1];
		
		while(!pq.isEmpty()) {
			Lecture lec = pq.poll();
			int day = lec.day;
			while(day > 0 && price[day] != 0)
				day--;
			if(day == 0)
				continue;
			price[day] = lec.price;
		}
		
		int res = 0;
		for(int i = 1; i <= maxDay; i++)
			res += price[i];
		
		System.out.println(res);
	}

}

class Lecture implements Comparable<Lecture>{
	int day;
	int price;
	
	Lecture(int price, int day){
		this.day = day;
		this.price = price;
	}

	@Override
	public int compareTo(Lecture lec) {
		// TODO Auto-generated method stub
		return lec.price - price;
	}
}
