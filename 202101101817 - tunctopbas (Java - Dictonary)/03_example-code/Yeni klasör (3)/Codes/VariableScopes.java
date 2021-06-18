package week8;

public class VariableScopes {

	private static double TAX_RATIO = 0.15;

	public static void main(String[] args) {

		double TAX_RATIO = 0;

		{
			double salaryAmount = 0;
		}

		double salaryAmount = 100;

		if (salaryAmount > 0) {
			double taxAmount = salaryAmount * TAX_RATIO;
			System.out.printf("Tax Amount=%.2f\n", taxAmount);
		}

		System.out.println(salaryAmount);
	}

}
