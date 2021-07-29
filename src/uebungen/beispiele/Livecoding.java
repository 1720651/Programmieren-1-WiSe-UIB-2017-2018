package uebungen.beispiele;

public class Livecoding{
	
	public static void main(String args[]) {
		int[] data = {1, 2, 3, 4, 5, 6};
		int n = 2;
		int[] result = new int[data.length];
		for(int i = 0; i < data.length; i++){
		    result[(i+n) % data.length ] = data[i];
		}
		for(int z:result)
			System.out.println(z);
		
	}
}