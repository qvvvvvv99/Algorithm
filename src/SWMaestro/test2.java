package SWMaestro;

import java.util.*;

public class test2 {

	static int[] map;
	  static int N;
	  static int[] avg;
	  static int[] res;

	  public static void main(String args[]) { 
	    Scanner sc = new Scanner(System.in);
	    
	    N = sc.nextInt();
	    int M = sc.nextInt();
	    int K = sc.nextInt();
	    res = new int[N+1];
	    avg = new int[N+1];
	    map = new int[N+1];

	    for(int i = 1; i <= M; i++){
	      res[sc.nextInt()] = sc.nextInt();
	    }

	    for(int i = 1; i <= N; i++)
	      map[i] = i;

	    for(int i = 1; i <= K; i++){
	      int a = sc.nextInt();
	      int b = sc.nextInt();
	      if (b < a){
	          int temp = b;
	          b = a;
	          a = temp;
	       }
	      union(a, b);
	    }

	    for(int i = 1; i <= N; i++){
	      if(res[i] == 0 && avg[map[i]]==0)
	        average(i);
	      if(avg[map[i]] != 0)
	    	  res[i] = avg[map[i]];
	    }

	    double sum = 0.0;
	    for(int i = 1; i<= N; i++)
	      sum += res[i];

	    System.out.printf("%.2f\n",sum/(double)N);
	  }

	  public static void union(int a, int b){
	    a = find(a);
	    b = find(b);
	    if(a != b)
	      map[b] = a;
	  }

	  public static int find(int n){
	    if(n == map[n])
	      return n;
	    else
	      return find(map[n]);
	  }

	  public static void average(int idx){
	    int group = map[idx];
	    int sum = 0;
	    int cnt = 0;

	    for(int i = 1; i <= N; i++){
	      if(map[i] == group && res[i] != 0){
	        sum+=res[i];
	        cnt++;
	      }
	    }
	    avg[group] = sum / cnt;
	  }

}
