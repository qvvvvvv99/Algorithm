package AlgoStudy.Week6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14226 {
	static int S;
	static int min = 1000;
	static boolean[][] visited = new boolean[2001][2001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		
		solve();
		
		System.out.println(min);
	}
	
	static void solve() {
		Queue<info> queue = new LinkedList<>();
		queue.add(new info(2, 1, 2));
		visited[2][1] = true;
		info curr;
		
		while(!queue.isEmpty()){
			curr = queue.poll();
			if(curr.screen == S) {
				min = Math.min(min, curr.sec);
			}
			if(curr.sec > min)
				break;
			if(curr.screen > S) {
				if(visited[curr.screen-1][curr.clipboard] == false) {
					queue.add(new info(curr.screen-1, curr.clipboard, curr.sec+1));
					visited[curr.screen-1][curr.clipboard] = true;
				}
			}
			else {
				if(visited[curr.screen+curr.clipboard][curr.clipboard] == false) {
					queue.add(new info(curr.screen + curr.clipboard, curr.clipboard, curr.sec+1));
					visited[curr.screen+curr.clipboard][curr.clipboard] = true;
				}
				if(visited[curr.screen][curr.screen] == false) {
					queue.add(new info(curr.screen, curr.screen, curr.sec+1));
					visited[curr.screen][curr.screen] = true;
				}
				if(curr.screen > 0 && visited[curr.screen-1][curr.clipboard] == false) {
					queue.add(new info(curr.screen-1, curr.clipboard, curr.sec+1));
					visited[curr.screen-1][curr.clipboard] = true;
				}
			}
		}
	}

}

class info{
	int screen;
	int clipboard;
	int sec;
	
	info(int screen, int clipboard, int sec){
		this.screen = screen;
		this.clipboard = clipboard;
		this.sec = sec;
	}
}