import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_GFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			br.readLine(); // string sizes
			
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			int n = s1.length();
			int m = s2.length();
			
			int[][] dp = new int[n+1][m+1];
			for(int i = 0; i <= n; i++)
				dp[i][0] = 0;
			for(int j = 0; j <= m; j++)
				dp[0][j] = 0;
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = 1 + dp[i-1][j-1];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}
	
}
