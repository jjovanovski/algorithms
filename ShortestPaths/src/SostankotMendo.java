import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SostankotMendo {

	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		int m = r.nextInt();
		
		int[][] mat = new int[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				if(i == j) {
					mat[i][j] = 0;
				} else {
					mat[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			int from = r.nextInt();
			int to = r.nextInt();
			int k = r.nextInt();
			mat[from][to] = k;
			mat[to][from] = k;
		}
		
		// floyd-warshall
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j] && mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		int minplace = -1;
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			for(int j = 1; j <= n; j++) {
				sum += mat[i][j];
			}
			if(sum < result) {
				result = sum;
				minplace = i;
			}
		}
		System.out.println(minplace);
	}
	
	private static class FastReader {		
		private BufferedReader br;
		private StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public String nextLine() {
			String line = "";
			try {
				line = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return line;
		}
		
	}
	
}
