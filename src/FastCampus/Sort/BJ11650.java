package FastCampus.Sort;

import java.util.*;

// BJ 11650번 좌표 정렬하기

public class BJ11650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Dot> dots = new ArrayList<>();
		
		for(int i = 0; i < N; i++) 
			dots.add(new Dot(sc.nextInt(), sc.nextInt()));
		
		Collections.sort(dots, new Comparator<Dot>() {

			@Override
			public int compare(Dot d1, Dot d2) {
				// TODO Auto-generated method stub
				if(d1.getX() < d2.getX())
					return -1;
				else if(d1.getX() > d2.getX())
					return 1;
				else {
					if(d1.getY() < d2.getY())
						return -1;
					else if(d1.getY() > d2.getY())
						return 1;
					else
						return 0;
				}
			}
		});
		for(int i = 0; i < N; i++) 
			System.out.println(dots.get(i).getX() + " " + dots.get(i).getY());
	}

}

class Dot{
	private int x;
	private int y;
	
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}