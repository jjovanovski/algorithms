import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedPartitionGFG {

	static void solve(int n, int[] arr) {
		int totalSum = 0;
		for(int i = 1; i <= n; i++) {
			totalSum += arr[i];
		}
		
		boolean[][] dp = new boolean[n+1][totalSum+1];
		// base case: 0 sum is possible with all elements
		for(int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		// base case: with 0 elements, no other sum is possible except the 0 sum (hence i=1)
		for(int i = 1; i <= totalSum; i++) {
			dp[0][i] = false;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= totalSum/2; j++) {
				// exclude the i-th element
				dp[i][j] = dp[i-1][j];
				
				// include the i-th element
				if(arr[i] <= j) {
					dp[i][j] |= dp[i-1][j - arr[i]];
				}
			}
		}
		
		int diff = Integer.MAX_VALUE;
		
		for(int j = totalSum/2; j >= 0; j--) {
			if(dp[n][j] == true) {
				diff = totalSum - 2*j;
				break;
			}
		}
		
		System.out.println(diff);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split(" ");
			int[] arr = new int[n+1];
			for(int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(line[i-1]);
			}
			
			solve(n, arr);
		}
	}
}
