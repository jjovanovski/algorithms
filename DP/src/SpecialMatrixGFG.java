import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialMatrixGFG {

	static final long MOD = (long)Math.pow(10, 9) + 7;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int k = Integer.parseInt(line[2]);
			
			boolean[][] obstacle = new boolean[n+1][m+1];
			line = br.readLine().split(" ");
			for(int i = 0; i < 2*k; i += 2) {
				int r = Integer.parseInt(line[i]);
				int c = Integer.parseInt(line[i+1]);
				obstacle[r][c] = true;
			}
			
			long[][] dp = new long[n+1][m+1];
			dp[1][1] = 1;
			
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					if(obstacle[i][j]) continue;
					
					if(i-1 >= 1) {
						if(!obstacle[i-1][j])
							dp[i][j] = (dp[i][j] + dp[i-1][j])%MOD;
					}
					if(j-1 >= 1) {
						if(!obstacle[i][j-1])
							dp[i][j] = (dp[i][j] + dp[i][j-1])%MOD;
					}
				}
			}
			
			System.out.println(dp[n][m]);
		}
	}
	
}
