package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ7662 {

	public static void main(String[] args) throws IOException {
		// 시간 초과ㅠㅠ
		// ver_priorityQueue(); 
		// ver_linkedList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int k = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minQue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                if (ch == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);

                    minQue.add(n);
                    maxQue.add(n);
                } else {
                    if (map.size() == 0)
                        continue;

                    PriorityQueue<Integer> que = n == 1 ? maxQue : minQue;
                    removeMap(que, map);
                }
            }

            if (map.size() == 0)
                System.out.println("EMPTY");
            else {
                int n = removeMap(maxQue, map);
                System.out.println(n + " " + (map.size() > 0 ? removeMap(minQue, map) : n));
            }

        }

    }

    static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        int num;
        while (true) {
            num = que.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0)
                continue;

            if (cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt - 1);

            break;
        }

        return num;
    }
	
	public static void ver_linkedList() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int c = 0; c < tc; c++) {
			int t = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < t; i++) {
				String[] line = br.readLine().split(" ");
				char ch = line[0].charAt(0);
				int num = Integer.parseInt(line[1]);
				if (ch == 'I') {
					list.add(num);
					Collections.sort(list);
				}
				else {
					if(list.isEmpty())
						continue;
					if(num == 1)
						list.removeLast();
					else
						list.removeFirst();
				}
			}
			if(list.isEmpty())
				sb.append("EMPTY\n");
			else {
				sb.append(list.getLast() + " " + list.getFirst() + "\n");
			}
		}

		System.out.print(sb);
	}

	public static void ver_priorityQueue() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int c = 0; c < tc; c++) {
			int minDel = 0, maxDel = 0;
			int t = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> minheapq = new PriorityQueue<>();
			PriorityQueue<Integer> maxheapq = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < t; i++) {
				String[] line = br.readLine().split(" ");
				char ch = line[0].charAt(0);
				int num = Integer.parseInt(line[1]);
				if (ch == 'I') {
					minheapq.add(num);
					maxheapq.add(num);
				} else {
					if (minheapq.size() - maxDel <= 0)
						continue;
					if (num == 1) {
						maxheapq.poll();
						maxDel++;
					} else {
						minheapq.poll();
						minDel++;
					}
				}
			}
			if (minheapq.size() - maxDel <= 0)
				sb.append("EMPTY\n");
			else {
				int max = maxheapq.poll();
				int min = minheapq.poll();
				sb.append(max + " " + min + "\n");
			}
		}
		System.out.print(sb);
	}
}
