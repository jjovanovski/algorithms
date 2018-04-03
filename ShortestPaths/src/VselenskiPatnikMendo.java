import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VselenskiPatnikMendo {

	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		int[][] mat = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = r.nextInt();
			}
		}
		
		// Floyd-Warshall
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		// check for negative cycles
		for(int i = 0; i < n; i++) {
			if(mat[i][i] < 0) {
				System.out.println("Se izgubi vo vremeto");
				return;
			}
		}
		
		int result = 0;
		int p = r.nextInt();
		int lastp = r.nextInt()-1;
		for(int i = 0; i < p-1; i++) {
			int nextp = r.nextInt()-1;
			result += mat[lastp][nextp];
			lastp = nextp;
		}
		System.out.println(result);		
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
