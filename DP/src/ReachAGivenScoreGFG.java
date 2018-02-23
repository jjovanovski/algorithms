import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReachAGivenScoreGFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			long[][] dp = new long[n+1][4];
			for(int i = 0; i < 4; i++) {
				dp[0][i] = 1;
			}
			
			for(int i = 1; i <= n; i++) {
				// 3
				dp[i][1] = dp[i][0];
				if(i-3 >= 0)
					dp[i][1] += dp[i-3][1];
				
				// 5
				dp[i][2] = dp[i][1];
				if(i-5 >= 0)
					dp[i][2] += dp[i-5][2];
				
				// 10
				dp[i][3] = dp[i][2];
				if(i-10 >= 0)
					dp[i][3] += dp[i-10][3];
			}
			
			System.out.println(dp[n][3]);
		}
	}
	
}
