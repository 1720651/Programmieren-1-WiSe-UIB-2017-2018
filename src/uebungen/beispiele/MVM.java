package uebungen.beispiele;

public class MVM {

	public static void main(String[] args) {
		double[] vector = {1, 2, 3};
		double[][] matrix = {
				{3, 2, 1},
				{5, 4, 3},
				{7, 8, 9}			
							};
		double[] result = new double[vector.length];
		for(int i=0; i<matrix.length; i++) {
			double sum = 0;
			for(int j=0; j<matrix.length; j++) {
				sum += matrix[i][j]*vector[j];
			}
			result[i] = sum;
		}
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		

	}

}
