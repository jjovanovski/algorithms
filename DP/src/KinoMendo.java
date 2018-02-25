import java.util.Scanner;

public class KinoMendo {

	static final int MOD = 1000000007;
	
	static long factorial(int n) {
		if(n == 0) return 1;
		
		long res = 1;
		for(int i = n; i >= 1; i--) {
			res *= i;
			res %= MOD;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int d = s.nextInt();
		
		long[][] dp = new long[n+1][m+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i == 0 || j == 0 || i > j) {
					dp[i][j] = 0;
				} else if(i == j) {
					dp[i][j] = factorial(i);
				} else {
					if(i == 1 && d == 0) {
						dp[i][j] = 1;
					} else {
						
						long res = 0;
						for(int k = i; k <= j; k++) {
							long tmp = (i*dp[i-1][k-1])%MOD;
							for(int h = k+1; h <= j; h++) {
								if(h-d-1 < 0) {
									tmp = 0;
									break;
								}
								tmp *= i-d;
								tmp %= MOD;
							}
							res += tmp;
							res %= MOD;
						}
						
						dp[i][j] = res;
						
					}
				}
			}
		}
		
		System.out.println(dp[n][m]);
	}
	
}
