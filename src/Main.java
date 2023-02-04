import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] map = new int[N][N];
        
        int num = 2;
        int len = 1;
        int x = 0;
        int y = 0;
        int dir = 1;
        map[0][0] = 1;
        
        for(int i = 1; i < N; i++) {
        	if(i % 2 == 0) {
        		x+=1;
        		map[x][y] = num;
        		num++;
        		dir = 1;
        		for(int j = 0; j < len; j++) {
        			y += dir;
        			map[x][y] = num;
        			num++;
        		}
        		dir = -1;
        		for(int j = 0; j < len; j++) {
        			x += dir;
        			map[x][y] = num;
        			num++;
        		}
        	}
        	else {
        		y+=1;
        		map[x][y] = num;
        		num++;
        		dir = 1;
        		for(int j = 0; j < len; j++) {
        			x += dir;
        			map[x][y] = num;
        			num++;
        		}
        		dir = -1;
        		for(int j = 0; j < len; j++) {
        			y += dir;
        			map[x][y] = num;
        			num++;
        		}
        	}
        	len++;
        }
        
        System.out.println(map[r-1][c-1]);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
