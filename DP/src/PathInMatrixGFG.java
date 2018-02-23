import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Path in matrix
 * https://practice.geeksforgeeks.org/problems/path-in-matrix/0
 */


public class PathInMatrixGFG {

	static int dp_rec[][];
	
	static int solve_rec_helper(int n, int mat[][], int i, int j) {
		if(i < 0 || j < 0 || i >= n || j >= n)
			return Integer.MIN_VALUE;
		if(i == 0)
			return mat[i][j];
		
		if(dp_rec[i][j] != -1)
			return dp_rec[i][j];
		
		int r1 = solve_rec_helper(n, mat, i-1,j-1) + mat[i][j];
		int r2 = solve_rec_helper(n, mat, i-1,j) + mat[i][j];
		int r3 = solve_rec_helper(n, mat, i-1,j+1) + mat[i][j];
		dp_rec[i][j] = Math.max(Math.max(r1, r2), r3);
		
		return dp_rec[i][j];
	}
	
	static void solve_rec(int n, int mat[][]) {
		dp_rec = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dp_rec[i][j] = -1;
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(solve_rec_helper(n, mat, n-1, i), max);
		}
		System.out.println(max);
	}
	
	static void solve_iterative(int n, int mat[][]) {
		int dp[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			dp[0][i] = mat[0][i];
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int result = mat[i][j] + dp[i-1][j];
				
				if(j-1 >= 0) {
					result = Math.max(mat[i][j] + dp[i-1][j-1], result);
				}
				
				if(j+1 < n) {
					result = Math.max(mat[i][j] + dp[i-1][j+1], result);
				}
				
				dp[i][j] = result;
			}
		}
		
		int maxPath = dp[n-1][0];
		for(int i = 1; i < n; i++) {
			maxPath = Math.max(maxPath, dp[n-1][i]);
		}
		System.out.println(maxPath);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] matstr = br.readLine().split(" ");
			int[][] mat = new int[n][n];
			int h = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					mat[i][j] = Integer.parseInt(matstr[h++]);
				}
			}
			
			solve_iterative(n, mat);
		}
	}
}
