package FastCampus.Sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {10, 36, 5, 1, 19, 21};
		quick_sort(data, 0, data.length-1);
		
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i]+" ");
	}
	
	private static void quick_sort(int[] ary, int low, int high) {
		if(low >= high)
			return;
		int pivot = partition(ary, low, high);
		
		quick_sort(ary, low, pivot-1);
		quick_sort(ary, pivot+1, high);
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
