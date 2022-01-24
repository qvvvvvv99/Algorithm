package FastCampus.Search;

//BJ1302번 베스트 셀러

import java.util.*;
import java.util.Map.Entry;

public class BJ1302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> list = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String name = sc.next();
			if (list.containsKey(name)) {
				int cnt = list.get(name) + 1;
				list.replace(name, cnt);
			} else {
				list.put(name, 1);
			}
		}

		Comparator<Entry<String, Integer>> comparator = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				// TODO Auto-generated method stub
				if (e1.getValue() > e2.getValue())
					return 1;
				else if (e1.getValue() < e2.getValue())
					return -1;
				else {
					int compare = e1.getKey().compareTo(e2.getKey());
					if (compare >= 0)
						return 0;
					else
						return 1;
				}
			}

		};
		
		Entry<String, Integer> maxEntry = Collections.max(list.entrySet(), comparator);

		System.out.println(maxEntry.getKey());

	}

}