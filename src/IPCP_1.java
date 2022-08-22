import java.util.Scanner;

public class IPCP_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			StringBuffer sb = new StringBuffer();
			int a, b, c, min;
			
			for(int tc = 0; tc < T; tc++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				min = Math.min(a, b);
				min = Math.min(c, min);
				
				sb.append(min + "\n");
			}
			
			System.out.print(sb);
	}

}
