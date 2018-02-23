import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubarrayGFG {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String str = br.readLine();
			int n = str.length();
			
			int[] dp = new int[n+1];
			dp[1] = 1;
			
			for(int i = 2; i <= n; i++) {
				boolean contains = false;
				for(int j = 1; j <= dp[i-1]; j++) {
					if(str.charAt(i-1) == str.charAt(i-j-1)) {
						contains = true;
						dp[i] = j;
						break;
					}
				}
				
				if(!contains) {
					dp[i] = dp[i-1] + 1;
				}
			}
			
			int max = 1;
			for(int i = 1; i <= n; i++) {
				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		}
	}
	
}
