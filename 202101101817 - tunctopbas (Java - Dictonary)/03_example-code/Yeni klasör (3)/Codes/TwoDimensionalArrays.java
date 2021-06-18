package week9;

public class TwoDimensionalArrays {

	public static int sum(int[][] values) {
		int total = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length; j++) {
				total = total + values[i][j];
			}
		}
		return total;
	}

}
