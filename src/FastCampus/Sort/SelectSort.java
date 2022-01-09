package FastCampus.Sort;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		select_sort();
	}

	public static void select_sort() {
		int[] data = {10, 36, 5, 1, 19, 21};
		int temp, lowest;
		
		for(int i = 0; i < data.length - 1; i++) {
			lowest = i;
			for(int j = i + 1; j < data.length; j++) {
				if(data[lowest] > data[j])
					lowest = j;
			}
			temp = data[lowest];
			data[lowest] = data[i];
			data[i] = temp;
		}
		
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i]+" ");
	}
}
