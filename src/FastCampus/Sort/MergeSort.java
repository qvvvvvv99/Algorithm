package FastCampus.Sort;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		merge_sort();
	}

	public static void merge_sort() {
		int[] data = {10, 36, 5, 1, 19, 21, 50, 17, 8, 63, 3, 18};
		
		
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i]+" ");
	}
}
