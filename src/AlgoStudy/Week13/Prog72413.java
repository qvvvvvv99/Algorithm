package AlgoStudy.Week13;

import java.util.Arrays;

public class Prog72413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(6, 4, 6, 2, fares));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = 0;
	        int INF = 20000001;
	        int[][] map = new int[n+1][n+1];
	        for(int i = 1; i <= n; i++)
	        	Arrays.fill(map[i], INF);
	        for(int i = 1; i <= n ; i++)
	            map[i][i] = 0;
	        
	        for(int i = 0; i < fares.length; i++){
	        	map[fares[i][0]][fares[i][1]] = fares[i][2];
	        	map[fares[i][1]][fares[i][0]] = fares[i][2];
	        }
	        
	        // k : 거쳐가는 노드
	        for(int k = 1; k <= n; k++) {
	        	// i : 출발 노드
	        	for(int i = 1; i <= n; i++) {
	        		// j : 도착 노드
	        		for(int j = i + 1; j <= n; j++) {
	        			map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
	        			map[j][i] = map[i][j];
	        		}
	        	}
	        }
	        
	        answer = map[s][a] + map[s][b];
	        for(int i = 1; i <= n; i++) 
	        	answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
	        
	        
	        return answer;
	    }
}
