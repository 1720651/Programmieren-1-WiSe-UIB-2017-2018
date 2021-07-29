package uebungen.beispiele;
public class While {

	public static void main(String[] args) {
		System.out.println("Summe iterativ: " + itSum(5) + "\n");
		System.out.println("Summe rekursiv: " + recSum(5,0));
	}

	public static int itSum(int end) {
		int sum = 0;
		int i = 1;

		while (i <= end) {
			sum = sum + i;
			i++;
			
			System.out.println(i + "\t" + sum);

			// alternative Lösung mit break und while(true)
//			if (i > end)
//				break;
		}
		
		return sum;
	}

	// counter entspricht i in der obigen Methode
	public static int recSum(int counter, int sum) {
		System.out.println("vorher: " + counter + "\t" + sum);
		
		if (counter != 0) {
			sum = counter + recSum(--counter, sum);
		}

		System.out.println("nachher: " + counter + "\t" + sum);

		return sum;
	}

}
