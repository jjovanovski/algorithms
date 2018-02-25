import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TomAndJerryGFG {

	static int[] dp;
	
	static boolean solve(int n) {
		if(dp[n] != 0) return dp[n] == 1 ? true : false;
		
		boolean won = false;
		int lim = (int) Math.sqrt(n);
		for(int i = 1; i < lim; i++) {
			if(n%i == 0) {
				boolean t = solve(n-i);
				if(!t) {
					won = true;
					break;
				}
			}
		}
		
		dp[n] = won ? 1 : -1;
		
		return won;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			dp = new int[n+1];

			if(solve(n))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
