import java.util.Scanner;

public class Main{
	static int cnt;
	
    public static int recursion(String s, int l, int r){
    	cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i = 0; i < N; i++) {
    		cnt = 0;
    		String str = sc.next();
    		sb.append(isPalindrome(str) + " " + cnt + "\n");
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
