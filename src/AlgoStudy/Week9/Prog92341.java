package AlgoStudy.Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Prog92341 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		int idx = 0;
		HashMap<Integer, Integer> carNum = new HashMap<>();
		int[][] in = new int[1000][2]; // in에 대한 정보 [hh][mm]
		int[] comul = new int[1000]; // 차량 누적 주차 시간
		boolean[] outFlag = new boolean[1000];
		List<Integer> car = new ArrayList<>();

		int base_time = fees[0];
		int base_fee = fees[1];
		int unit_time = fees[2];
		int unit_fee = fees[3];
		String[] info;
		String[] time;

		for (int i = 0; i < records.length; i++) {
			info = records[i].split(" ");
			time = info[0].split(":");
			if (!carNum.containsKey(Integer.parseInt(info[1]))) {
				carNum.put(Integer.parseInt(info[1]), idx);
				car.add(Integer.parseInt(info[1]));
				in[idx][0] = Integer.parseInt(time[0]);
				in[idx][1] = Integer.parseInt(time[1]);
				idx++;
			} else {
				int num = carNum.get(Integer.parseInt(info[1]));
				if (info[2].equals("IN")) {
					in[num][0] = Integer.parseInt(time[0]);
					in[num][1] = Integer.parseInt(time[1]);
					outFlag[num] = false;
				} else {
					int outHour = Integer.parseInt(time[0]);
					int outMin = Integer.parseInt(time[1]);
					int min;
					if(in[num][1] > outMin) {
						outHour--;
						outMin += 60;
					}
					min = (outMin - in[num][1]) + 60 * (outHour - in[num][0]);
					comul[num] += min;
					outFlag[num] = true;
				}
			}
		}
		
		for(int i = 0; i < idx; i++) {
			if(outFlag[i] == false) {
				comul[i] += ((59 - in[i][1]) + 60 * (23 - in[i][0]));
			}
		}
		
		int[] res = new int[idx];
		Arrays.fill(res, base_fee);
		for(int i = 0; i < idx; i++) {
			if(comul[i] > base_time) {
				res[i] += (int)Math.ceil((float)(comul[i] - base_time) / unit_time) * unit_fee;
			}
		}
		
		int[] answer = new int[idx];
		Collections.sort(car);
		for(int i = 0; i < idx; i++) {
			answer[i] = res[carNum.get(car.get(i))];
		}
		
		for(int i = 0; i < idx; i++)
			System.out.println(car.get(i) + " : " + answer[i]);
	}

}
