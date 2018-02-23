import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSumProblemGFG {
	
	static int[][] dp;
	
	static int solve_rec(int n, int sum, int[] arr) {
		if(sum <= 0) {
			return Integer.MAX_VALUE;
		}
		if(n == 1) {
			if(arr[1] == sum)
				return 0;
			else
				return Integer.MAX_VALUE;
		}
		
		if(dp[n][sum] != -1) return dp[n][sum];
		
		if(arr[n] == sum) {
			dp[n][sum] = 0;
			return 0;
		}
		
		if(solve_rec(n-1, sum, arr) == 0) {
			dp[n][sum] = 0;
			return 0;
		}
				
		dp[n][sum] = solve_rec(n-1, sum-arr[n], arr);
		return dp[n][sum];
	}
	
	static boolean solve(int n, int[] arr) {
		// check sum
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += arr[i];
		}
		if(sum%2 != 0)
			return false;
		
		sum = sum/2;
		
		boolean[][] dp = new boolean[n+1][sum+1];
		for(int i = 0; i <= n; i++)
			dp[i][0] = true;
		for(int i = 0; i <= sum; i++)
			dp[0][i] = false;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= sum; j++) {
				if(arr[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j-arr[i]] || dp[i-1][j];
				}
			}
		}
		
		return dp[n][sum];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			int[] arr = new int[n+1];
			for(int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(str[i-1]);
			
			boolean iterative = solve(n, arr);
			if(iterative)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			/*int sum = 0;
			for(int i = 1; i <= n; i++) {
				sum += arr[i];
			}
			if(sum%2 != 0) {
				System.out.println("NO");
				continue;
			}
			
			dp = new int[n+1][sum/2+1];
			for(int i = 0; i <= n; i++) {
				for(int j = 0; j <= sum/2; j++) {
					dp[i][j] = -1;
				}
			}
			
			int r = solve_rec(n, sum/2, arr);
			if(r == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}*/
		}
	}
}
