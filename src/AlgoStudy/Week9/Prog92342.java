package AlgoStudy.Week9;

public class Prog92342 {
	static int max = 0;
	static int[] info = {0,0,0,0,0,0,0,0,3,4,3};
	static int[] answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		
		solution(n);
		
		for(int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}
	
	static int[] solution(int n) {
		answer = new int[11];
		int[] res = new int[11];
		
        dfs(0, 0, n, res);
		
		if(max == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
        
        return answer;
    }
	
	static void dfs(int idx, int score, int remain, int[] res) {
		if(idx >= 10 || remain == 0) {
			res[10] = remain;
			for(int i = idx; i < 10; i++) {
				if(info[i] != 0)
					score -= 10 - i;
			}
			if(max < score) {
				max = score;
				answer = res.clone();
			}
			else if(max == score) {
				for(int i = 10; i >= 0; i--) {
					if(res[i] < answer[i])
						break;
					else if(res[i] == answer[i])
						continue;
					else {
						answer = res.clone();
						break;
					}			
				}
			}
			return;
		}
		
		if(remain > info[idx]) {
			score += 10 - idx;
			remain -= info[idx] + 1;
			res[idx] = info[idx]+1;
			dfs(idx+1, score, remain, res);
			score -= 10 - idx;
			remain += info[idx] + 1;
		}
		if(info[idx] > 0)
			score -= 10 - idx;
		
		res[idx] = 0;
		dfs(idx+1, score, remain, res);
		score += 10 - idx;
	}
}
