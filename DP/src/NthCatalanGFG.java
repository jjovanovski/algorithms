import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/*
 * Calculating the N-th Catalan number using binomial coefficient:
 * Catalan(n) = (1/(n+1))*C(2n, n) 
 */

public class NthCatalanGFG {

	static BigInteger binCoeff(int n, int k) {
		// C(n, k) = C(n, n-k)
		if(k > n-k)
			k = n-k;
		
		BigInteger result = new BigInteger("1");
		
		for(int i = 0; i < k; i++) {
			result = result.multiply(new BigInteger(String.valueOf(n-i)));
			result = result.divide(new BigInteger(String.valueOf(i+1)));
		}
		
		return result;
	}
	
	static BigInteger catalan(int n) {
		BigInteger c = binCoeff(2*n, n);
		c = c.divide(new BigInteger(String.valueOf(n+1)));
		return c;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				System.out.println(1);
				continue;
			}
			System.out.println(catalan(n).toString());
		}
	}
	
}
