package uebungen.beispiele;
public class ArrayMin {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] {1,5,7,3,2,6,9}));
	}
	
	public static int findMin(int[] numbers) {
		int min = Integer.MAX_VALUE;
		for (int element : numbers) {
			if (element < min) 
				min = element;
		}
		
		return min;
	}

}