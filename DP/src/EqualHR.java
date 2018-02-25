import java.util.Scanner;

public class EqualHR {

	// coinChange(n) = 1 + min(coinChange(n-1), coinChange(n-2), coinChange(n-3))
	static int[][] ccdp;
	
	static int coinChange(int n) {
		/*int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			if(i-5 >= 0 && dp[i-5] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], 1+dp[i-5]);
			}
			if(i-2 >= 0 && dp[i-2] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], 1+dp[i-2]);
			}
			if(dp[i-1] != Integer.MAX_VALUE)
				dp[i] = Math.min(dp[i], 1+dp[i-1]);
		}
		
		return dp[n];*/
		int result = 0;
		if(n >= 5) {
			result += n/5;
			n = n%5;
		}
		if(n >= 2) {
			result += n/2;
			n = n%2;
		}
		result += n;
		
		return result;
	}
	
	static int equal(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = min-4; i <= min; i++) {
			int total = 0;
			for(int j = 0; j < arr.length; j++) {
				int diff = Math.abs(arr[j] - i);
				total += coinChange(diff);
			}
			result = Math.min(total, result);
		}
		
		return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = equal(arr);
            System.out.println(result);
        }
        in.close();
    }
	
}
