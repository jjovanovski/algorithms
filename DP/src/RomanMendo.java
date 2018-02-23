import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RomanMendo {
	
	static int[][] dp;
	
	static int sum(int i, int j, int[] str) {
		int sum = 0;
		for(int k = i; k <= j; k++) {
			sum += str[k];
		}
		return sum;
	}

	static int solve_rec(int n, int k, int[] str) {
		if(n == 1 && k > 0) {
			return str[1];
		}
		if(k == 1) {
			return sum(1, n, str);
		}
		if(dp[n][k] != -1) return dp[n][k];
		
		int result = Integer.MAX_VALUE;
		int tmpsum = 0;
		for(int i = n; i >= 1; i--) {
			result = Math.min(result, 
					Math.max(solve_rec(i, k-1, str), tmpsum) );
			tmpsum += str[i];
		}
		
		dp[n][k] = result;
		return result;
	}
	
	static void solve_iterative(int n, int k, int[] str) {
		int[][] dp = new int[n+1][k+1];
		// M(i, 1) base case (one partition base case)
		dp[1][1] = str[1];
		for(int i = 2; i <= n; i++) {
			dp[i][1] = str[i] + dp[i-1][1];
		}
		// M(1, k) base case (prviot element na k particii)
		for(int i = 1; i <= k; i++) {
			dp[1][i] = str[1];
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 2; j <= k; j++) {
				int result = Integer.MAX_VALUE;
				int rightPartitionSum = sum(1, i, str);
				for(int h = 1; h <= i; h++) {
					rightPartitionSum -= str[h];
					int maxPartition = Math.max(rightPartitionSum, dp[h][j-1]);
					result = Math.min(result, maxPartition);
				}
				
				dp[i][j] = result;
			}
		}
		
		System.out.println(dp[n][k]);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		int[] str = new int[n+1];
		String[] strString = br.readLine().split(" ");
		for(int i = 1; i <= n; i++) {
			str[i] = Integer.parseInt(strString[i-1]);
		}
		
		dp = new int[n+1][k+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <=k; j++) {
				dp[i][j] = -1;
			}
		}
		
		solve_iterative(n, k, str);
		//System.out.println(solve_rec(n, k, str));
	}
}
