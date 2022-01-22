package FastCampus.Sort;

import java.io.*;
import java.util.Arrays;

public class BJ11004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int[] ary = new int[N];
		input = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++)
			ary[i] = Integer.parseInt(input[i]);
		
		//quickSort(ary, 0, N-1);
		
		Arrays.sort(ary);
		System.out.println(ary[K-1]);
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
