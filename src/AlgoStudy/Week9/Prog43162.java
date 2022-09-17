package AlgoStudy.Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prog43162 {
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] computers = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				computers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        int answer = n;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(computers[i][j] == 1){
                    int u = i;
                    int v = j;
                    u = find(u);
                    v = find(v);
                    if(u != v){
                        union(u,v);
                        answer--;
                    }
                }
            }
        }
         
        System.out.println(answer);
    }
    
    static int find(int n){
        if(n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
    }
    
    static void union(int u, int v){
        parent[Math.max(u, v)] = Math.min(u, v);
    }
}
