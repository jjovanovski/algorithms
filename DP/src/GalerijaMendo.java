import java.util.Arrays;
import java.util.Scanner;

public class GalerijaMendo {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		double x = s.nextDouble();
		double[] arr = new double[n+1];
		for(int i = 1; i <= n; i++) {
			arr[i] = s.nextDouble();
		}
		
		double dx = 2.0*x;
		
		Arrays.sort(arr);
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			int t = Integer.MAX_VALUE;
			for(int j = i; j >= 1; j--) {
				double diff = Math.abs(arr[i] - arr[j]);
				if(diff <= dx) {
					t = Math.min(t, 1+dp[j-1]);
				} else {
					break;
				}
			}
			dp[i] = t;
		}
		
		System.out.println(dp[n]);
		
		s.close();
	}
	
}
