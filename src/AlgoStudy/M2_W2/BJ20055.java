package AlgoStudy.M2_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ20055 {
	static int N, K;
	static int[] belt;
	static int[] robot;
	static boolean[] exist;
	static int first;
	static int head = 0, tail = -1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		robot = new int[2*N];
		exist = new boolean[2*N];
		Arrays.fill(robot, -1);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2*N; i++)
			belt[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		while(true) {
			cnt++;
			// rotate belt
			first--;
			if(first < 0)
				first = 2*N-1;
			
			dropRobot();
			
			// move robot
			moveRobot();
			
			dropRobot();
			
			// ¿Ã¸®±â
			if(belt[first] > 0) {
				tail++;
				tail %= 2 * N;
				robot[tail] = first;
				belt[first]--;
				exist[first] = true;
				if(belt[first] == 0)
					K--;
			}
			
			if(K == 0)
				break;
		}
		
		System.out.println(cnt);
	}
	
	static void moveRobot() {
		int num = head;
		int idx, next;
		while(robot[num] >= 0) {
			idx = robot[num];
			next = (idx + 1) % (2*N);
			if(!exist[next] && belt[next] > 0) {
				robot[num] = next;
				belt[next]--;
				exist[next] = true;
				exist[idx] = false;
				if(belt[next] == 0)
					K--;
			}
			num++;
			num %= 2 * N;
		}
	}
	
	static void dropRobot() {
		if(exist[(first + N -1) % (2*N)]) {
			exist[(first + N -1) % (2*N)] = false;
			robot[head] = -1;
			head++;
			head %= 2 * N;
		}
	}

}
