import java.util.Scanner;

public class SamAndSubstrings {

	static final int MOD = 1000000007;
	
    static long substrings(String balls) {
    	int n = balls.length();
    	int[] arr = new int[n+1];
    	for(int i = 0; i < n; i++) {
    		arr[i] = Integer.parseInt(balls.charAt(i) + "");
    	}
    	
    	long answer = 0;
    	long elevens = 1;
    	for(int i = n-1; i >= 0; i--) {
    		answer = (answer + (i+1)*arr[i]*elevens)%MOD;
    		elevens = (elevens*10+1)%MOD;
    	}
    	
    	return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String balls = in.next();
        long result = substrings(balls);
        System.out.println(result);
        in.close();
    }

}
