import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int n = 0, idx = 1;
		int ja, mo;
		
		while(true) {
			if(n >= X)
				break;
			
			n += idx;
			idx++;
		}
		n -= (idx - 1);
		if(idx % 2 == 1) {
			mo = idx - (X - n);
			ja = X - n;
		}else {
			mo = X - n;
			ja = idx - (X - n);
		}
		
		System.out.println(ja+"/"+mo);
	}

}
