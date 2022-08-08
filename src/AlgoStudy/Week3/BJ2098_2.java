package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2098_2 {
	private static final int INF = 16000001; //TSP의 최대값보다 더 큰 값.
    static int N;
	static int[][] map;
    static int visited;
    private static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = (1 << N) - 1; // 1...1(N개) -> N개의 정점을 방문 했는지 여부 
        map = new int[N][N];
        dp = new int[16][visited];
        // dp[방문 도시][이미 방문한 도시들의 비트마스크]
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) 
            Arrays.fill(dp[i], -1);
        
        System.out.println(dfs(0, 1));
    }

    //dp[cur][visit] : cur정점에서 visit(bitmask) 만큼 정점을 방문한 상태일 때,
    //                 나머지 정점 모두 방문 후 다시 0번 정점으로 돌아가는 최소비용
    public static int dfs(int cur, int visit) {
        if (visit == visited) // 모든 정점을 방문했는 경우
        	return map[cur][0] == 0 ? INF : map[cur][0];
        if (dp[cur][visit] != -1) 
        	return dp[cur][visit];

        dp[cur][visit] = INF;
        for(int i = 0; i < N; i++) {
            int next = 1 << i;
            // 도시 cur에서 
            if(map[cur][i] != 0 && ((visit & next) == 0)) {
                dp[cur][visit] = Math.min(dp[cur][visit], dfs(i, (visit|next)) + map[cur][i]);
            }
        }
        return dp[cur][visit];
    }

}
