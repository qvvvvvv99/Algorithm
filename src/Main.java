import java.util.Scanner;

public class Main {
	static int[] dial = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int sum = 0;
		for(int i = 0; i < str.length(); i++) {
			sum += dial[str.charAt(i) - 'A'];
		}
		
		System.out.println(sum);
	}

}
