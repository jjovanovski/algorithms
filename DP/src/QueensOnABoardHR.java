import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/queens-on-board/problem
 * 
 * @author jovanjovanovski
 */

public class QueensOnABoardHR {

	static final int MOD = 1000000007;
	
	static boolean blocked(int i, int j, String[] board) {
		return board[i-1].charAt(j-1) == '#';
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			String[] board = new String[n];
			for(int i = 0; i < n; i++) {
				board[i] = br.readLine();
			}
			
			
		}
	}
	
}
