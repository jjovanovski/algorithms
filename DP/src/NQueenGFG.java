import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NQueenGFG {

	static boolean isAttacked(int row, int column, boolean[][] board, int n) {		
		// vertical
		int i = 0;
		while(i < n) {
			if(board[i][column]) {
				return true;
			}
			i++;
		}
		
		// horizontal
		int j = 0;
		while(j < n) {
			if(board[row][j]) {
				return true;
			}
			j++;
		}
		
		// leftop-to-rightbottom diagonal
		i = row-column; j = 0;
		if(column > row) {
			i = 0; j = column-row;
		}
		while(i < n && j < n) {
			if(board[i][j])
				return true;
			i++;
			j++;
		}
		
		// righttop-to-leftbottom diagonal
		i = 0; j = row+column;
		if(row+column >= n) {
			i = row+column-n+1; j = n-1;
		}
		while(i < n && j >= 0) {
			if(board[i][j])
				return true;
			i++;
			j--;
		}
		
		
		return false;
	}
	
	static boolean solveUtil(int column, boolean[][] board, int n, String str, ArrayList<String> solutions) {
		boolean any = false;
		for(int i = 0; i < n; i++) {
			if(!isAttacked(i, column, board, n)) {
				if(column == n-1) {
					solutions.add(str + (i+1) + " ");
					any = true;
				} else {
					board[i][column] = true;
					boolean t = solveUtil(column+1, board, n, str + (i+1) + " ", solutions);
					if(t) {
						any = true;
					}
					board[i][column] = false;
				}
			}
		}
		
		return any;
	}
	
	static void solve(int n) {
		boolean[][] board = new boolean[n][n];
		ArrayList<String> solutions = new ArrayList<String>();
		
		boolean result = solveUtil(0, board, n, "", solutions);
		if(result) {
			System.out.println(solutions.size());
			/*for(String s : solutions) {
				System.out.print("[" + s + "] ");
			}*/
			System.out.println("");
		} else {
			System.out.println(-1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			solve(n);
		}
	}
	
}
