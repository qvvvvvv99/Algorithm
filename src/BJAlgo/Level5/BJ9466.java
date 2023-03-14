package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9466 {
	static int[] s;
	static boolean[] visit, done;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			s = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; i++)
				s[i] = Integer.parseInt(st.nextToken());
			visit = new boolean[n+1];
			done = new boolean[n+1];
			count = 0;
			
			for(int i = 1; i <= n; i++) {
				if(done[i])
					continue;
				dfs(i);
			}
			sb.append(n-count).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void dfs(int n) {
		if(visit[n]){
            done[n] = true;    // 팀 편성 완료했다고 처리
            count++;    // 팀 편성 완료 인원 증가
        }else{
            // 방문하지 않았을 때 -> 방문 처리!
            visit[n] = true;
        }
        
        // 다음 학생이 팀 결성을 아직 못했을 경우
        if(!done[s[n]]){
            dfs(s[n]);
        }

        visit[n] = false;
        done[n] = true;
	}

}
