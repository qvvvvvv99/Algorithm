package FastCampus.Sort;

import java.util.*;

public class BJ10814 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Member> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			list.add(new Member(sc.nextInt(), sc.next()));
		
		Collections.sort(list);
		
		for(int i = 0; i < N; i++)
			System.out.println(list.get(i).getAge() + " " + list.get(i).getName());
	}

}

class Member implements Comparable<Member>{
	private int age;
	private String name;

	public Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Member mem) {
		// TODO Auto-generated method stub
		if(this.getAge() < mem.getAge())
			return -1;
		else if(this.getAge() > mem.getAge())
			return 1;
		return 0;
	}
}