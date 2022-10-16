import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuffer sb = new StringBuffer();
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			long R = sc.nextLong();
			long C = sc.nextLong();
			long min = Math.min(R, C);
//			long max = Math.max(R, C);
			
			long white = (2*min-1)*R*C - min*(min-1)*(R+C) + (min-1)*min*(2*min-1)/3;
			long dark = 2*min*R*C - min*min*(R+C) + min*(min+1)*(2*min+1)/3 - min*(min+1);
//			long white = (long)((min*(min+1)*(2*min+1))/3 - min*min + (min*min)*(max-min));
//			long dark = (long)((min*(min+1)*(2*min+1))/3 - min*min + (min*min)*(max-min)-min);
			
			sb.append(white + " " + dark+"\n");
		}
		
		System.out.print(sb);
	}
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
