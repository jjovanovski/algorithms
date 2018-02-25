import java.util.Scanner;

public class SherlockAndCostHR {
	
	static int cost(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][2];
		
		for(int i = 1; i < n; i++) {
			// a[i] = 1
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + Math.abs(arr[i-1]-1));
			
			// a[i] = b[i]
			dp[i][1] = Math.max(dp[i-1][0] + Math.abs(arr[i] - 1), dp[i-1][1] + Math.abs(arr[i-1] - arr[i]));
		}
		
		return Math.max(dp[n-1][0], dp[n-1][1]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			int result = cost(arr);
			System.out.println(result);
		}
		in.close();
	}

}
