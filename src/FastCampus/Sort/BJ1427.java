package FastCampus.Sort;

import java.util.*;

public class BJ1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = Integer.toString(N);
		int ary[] = new int[str.length()];
		
		for(int i = 0; i < str.length(); i++) {
			ary[i] = str.charAt(i)-'0';
		}
		
		quickSort(ary, 0, ary.length-1);
		
		for(int i = ary.length-1; i >= 0; i--) {
			System.out.print(ary[i]);
		}
		
		// 초초초간단
		/*
		char[] input = sc.nextLine().toCharArray();
        Arrays.sort(input);
        StringBuilder reverse = new StringBuilder(String.valueOf(input));
        System.out.println(reverse.reverse());
        */
		
		// 9~0 순으로 배열에서 같은 숫자가 있을 경우 출력
		for(int i = 9; i >= 0; i--) {
			for(int j = 0; j < str.length(); j++) {
				if(i == str.charAt(j)-'0') {
					System.out.print(str.charAt(j));
				}
			}
		}
	}
	
	private static void quickSort(int[] ary, int low, int high) {
		if(low >= high)
			return;
		int pivot = partition(ary, low, high);
		
		quickSort(ary, low, pivot-1);
		quickSort(ary, pivot+1, high);
	}
	
	private static int partition(int[] ary, int left, int right) {
		int low = left;
		int high = right;
		int pivot = ary[left];
		
		while(low < high) {
			while(ary[high] > pivot && low < high)
				high--;
			while(ary[low] <= pivot && low < high)
				low++;
			
			swap(ary, low, high);
		}
		
		swap(ary, left, low);
		
		return low;
	}
	
	private static void swap(int[] ary, int i, int j) {
		int temp = ary[i];
		ary[i] = ary[j];
		ary[j] = temp;
	}
}
