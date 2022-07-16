package Programmers.Level1;

public class Pro64061 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        int[] heigth = new int[len];
        int[] basket = new int[len*len];
        int top = 0;
        
        for(int i = 0; i < len; i++) {
        	for(int j = 0; j < len; j++) {
        		if(board[i][j] != 0 && heigth[j] == 0)
        			heigth[j] = len - i;
        	}
        }
        
        for(int i = 0; i < moves.length; i++) {
        	if(heigth[moves[i]-1] != 0) {
        		int num = board[len- heigth[moves[i]-1]][moves[i]-1];
        		heigth[moves[i]-1]--;
        		if(num == basket[top]) {
        			answer += 2;
        			top--;
        		}else {
        			top++;
        			basket[top] = num;
        		}
        	}
        }
        
        return answer;
    }
}
