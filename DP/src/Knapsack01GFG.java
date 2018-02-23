import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack01GFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int capacity = Integer.parseInt(br.readLine());
			
			String[] valuesstr = br.readLine().split(" ");
			String[] weightsstr = br.readLine().split(" ");
			
			int[] values = new int[n+1];
			int[] weights = new int[n+1];
			for(int i = 1; i <= n; i++) {
				values[i] = Integer.parseInt(valuesstr[i-1]);
				weights[i] = Integer.parseInt(weightsstr[i-1]);
			}
			
			int[][] dp = new int[capacity+1][n+1];
			for(int i = 0; i <= capacity; i++) {
				dp[i][0] = 0;
			}
			for(int i = 0; i <= n; i++) {
				dp[0][i] = 0;
			}
			
			for(int i = 1; i <= capacity; i++) {
				for(int j = 1; j <= n; j++) {
					dp[i][j] = dp[i][j-1];
					if(i >= weights[j]) {
						dp[i][j] = Math.max(dp[i][j], dp[i-weights[j]][j-1] + values[j]);
					}
				}
			}
			
			System.out.println(dp[capacity][n]);
		}
	}
	
}
