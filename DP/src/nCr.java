import java.io.IOException;

public class nCr {

	static long factorial(int n) {
		if(n <= 0)
			return 1;
		
		long result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	// overflows for n > 20
	static long binCoeffFormula(int n, int k) {
		return factorial(n)/(factorial(n-k)*factorial(k));
	}
	
	static long binCoeff(int n, int k) {
		if(k > n-k)
			k = n-k;
		
		long result = 1;
		for(int i = 0; i < k; i++) {
			result *= n-i;
			result /= i+1;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for(int i = 1; i <= 30; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("n: " + i + ", k: " + j + " --> ");
				System.out.print(binCoeff(i, j) + " ");
				System.out.print(binCoeffFormula(i, j) + "\n");
			}
		}
	}
	
}
