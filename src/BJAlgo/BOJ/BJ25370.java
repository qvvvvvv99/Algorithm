package BJAlgo.BOJ;

import java.util.HashSet;
import java.util.Scanner;

public class BJ25370 {
	static HashSet<Integer> hs = new HashSet<>();
	static int n;
	
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] count = new int[10];
        
        dfs(0, 1, count);
        
        System.out.println(hs.size());
    }
    
    static void dfs(int idx, int num, int[] count) {
    	if(idx == n) {
    		int a = 1;
    		for(int i = 2; i <= 9; i++) {
    			if(count[i] > 0)
    				a *= Math.pow(i, count[i]);
    		}
    		hs.add(a);
    		return;
    	}
    	
    	for(int i = num; i <= 9; i++) {
    		count[i]++;
    		dfs(idx+1, i, count);
    		count[i]--;
    	}
    }
}