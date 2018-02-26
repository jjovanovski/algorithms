import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ConstructTheArrayHR {

	static final int MOD = 1000000007;
	
    static long countArray(int n, int k, int x) {
    	long[][] dp = new long[n+1][3];
    	dp[1][1] = 1;
    	for(int i = 2; i <= n; i++) {
    		for(int j = 1; j <= 2; j++) {
    			if(j == 1) {
    				dp[i][j] = (k-1)*dp[i-1][2];
    				dp[i][j] %= MOD;
    			} else {
    				dp[i][j] = dp[i-1][1] + (k-2)*dp[i-1][2];
    				dp[i][j] %= MOD;
    			}
    			
    			/*for(int h = 1; h <= k; h++) {
    				if(h != j) {
    					dp[i][j] += dp[i-1][h];
    				}
    			}*/
    		}
    	}
    	
    	/*for(int i = 1; i <= n; i++) {
    		for(int j = 1; j <= k; j++) {
    			System.out.print(dp[i][j] + "\t");
    		}
    		System.out.println("");
    	}*/
    	
    	if(x != 1)
    		return dp[n][2];
    	return dp[n][1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        long answer = countArray(n, k, x);
        System.out.println(answer);
        in.close();
    }
}
