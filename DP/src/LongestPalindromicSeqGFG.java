import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromicSeqGFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String str = br.readLine();
			String rstr = "";
			int n = str.length();
			for(int i = str.length()-1; i >= 0; i--) {
				rstr += str.charAt(i);
			}
			
			int[][] dp = new int[n+1][n+1];
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(str.charAt(i-1) == rstr.charAt(j-1)) {
						dp[i][j] = 1 + dp[i-1][j-1];
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
			
			System.out.println(dp[n][n]);
		}
	}
	
}
