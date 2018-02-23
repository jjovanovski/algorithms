import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysToTileFloorGFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if(n == 1) {
				System.out.println(1);
				continue;
			}

			long f1 = 1, f2 = 1, fib = 2;
			for(int i = 2; i <= n; i++) {
				fib = f1+f2;
				f1 = f2;
				f2 = fib;
			}
			System.out.println(fib);
		}
	}
	
}
