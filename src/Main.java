import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        
        while(true) {
        	a = sc.nextInt();
        	b = sc.nextInt();
        	if(a == 0 && b == 0)
        		break;
        	if(a < b) {
        		if((b / a)*a == b)
        			System.out.println("factor");
        		else
        			System.out.println("neither");
        	}
        	else {
        		if((a / b)*b == a)
        			System.out.println("multiple");
        		else
        			System.out.println("neither");
        	}
        }
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
