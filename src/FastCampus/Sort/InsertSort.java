package FastCampus.Sort;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert_sort();
	}

	public static void insert_sort() {
		int[] data = {10, 36, 5, 1, 19, 21};
		int temp;
		
		for(int i = 0; i < data.length - 1; i++) {
			for(int j = i + 1; j > 0; j--) {
				if(data[j] < data[j-1]) {
					temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
				else	break;
			}
		}
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i]+" ");
	}
}
