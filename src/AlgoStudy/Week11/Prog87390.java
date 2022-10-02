package AlgoStudy.Week11;

public class Prog87390 {
	static int[] answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000000;
		long left = 1000000000;
		long right = 1000039810;
		solution(n, left, right);
		
		for(int i = 0; i < right-left+1; i++)
			System.out.print(answer[i] + " ");
	}
	
	public static int[] solution(int n, long left, long right) {
		int len = (int)(right-left+1);
        answer = new int[len];
        
        for(int i = 0; i <= right - left; i++) {
        	long idx = left + i;
        	int row = (int)(idx / (long)n);
        	int col = (int)(idx % (long)n);
        	
        	if(col <= row)
        		answer[i] = row + 1;
        	else
        		answer[i] = col + 1;
        }
        
        return answer;
    }

}
