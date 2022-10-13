package AlgoStudy.Week13;

public class Prog118667 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] queue1 = {9, 1, 1, 1, 1};
		int[] queue2 = {1, 1, 1, 1, 1};

		System.out.println(solution(queue1, queue2));
	}

	public static int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long allSum = 0;
		long sum1 = 0;
		for (int i = 0; i < queue1.length; i++) {
			allSum += (long) (queue1[i] + queue2[i]);
			sum1 += (long) queue1[i];
		}
		
		if(allSum % 2 == 1)
			return -1;
		
		int s = 0;
		int e = queue1.length-1;
		while(true) {
			if(sum1 == allSum / 2)
				break;
			if(s > e || answer > 1000000) {
				answer = -1;
				break;
			}
			
			if(sum1 < allSum / 2) {
				e++;
				if(e >= queue1.length)
					sum1 += queue2[e % queue1.length];
				else
					sum1 += queue1[e];
			}
			else {
				if(s >= queue1.length)
					sum1 -= queue2[s % queue1.length];
				else
					sum1 -= queue1[s];
				s++;
			}
			answer++;
		}

		return answer;
	}
}
