import java.util.ArrayList;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below*/
class RatInMazeGFG{
    
    static int[] xMoves = new int[] {0, 1, 0, -1};
    static int[] yMoves = new int[] {1, 0, -1, 0};
    static String[] moves = new String[] {"R", "D", "L", "U"};
    
    static boolean isValidMove(int i, int j, int[][] m) {
        if(i >= 0 && i < m.length && j >= 0 && j < m.length) {
            return m[i][j] != 0;
        }
        
        return false;
    }
    
    static void solve(int xpos, int ypos, boolean[][] visited, int[][] m, int n, String movestr, ArrayList<String> solutions) {    	
    	if(xpos == n-1 && ypos == n-1) {
    		solutions.add(movestr);
    		return;
    	}
    	
    	for(int i = 0; i < xMoves.length; i++) {
    		int nextX = xpos + xMoves[i];
    		int nextY = ypos + yMoves[i];
    		
    		if(isValidMove(nextX, nextY, m)) {
    			if(!visited[nextX][nextY]) {
    				visited[nextX][nextY] = true;
    				movestr += moves[i];
    				
    				solve(nextX, nextY, visited, m, n, movestr, solutions);
    				
    				visited[nextX][nextY] = false;
    				movestr = movestr.substring(0, movestr.length()-1);
    			}
    		}
    	}
    }
    
    public static ArrayList<String> printPath(int[][] m, int n)
    {
        // start from (0, 0)
        // try to go to all possible moves (if in range and not blocked and not visited)
    	// if the move returns true, print the path
    	boolean[][] visited = new boolean[n][n];
    	visited[0][0] = true;
    	ArrayList<String> solutions = new ArrayList<String>();
    	solve(0, 0, visited, m, n, "", solutions);
        
    	solutions.sort((s1, s2) -> s1.compareTo(s2));   
    	return solutions;
    }
}