import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PokloniMendo {

	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		
		double[][] mat = new double[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					mat[i][j] = Double.MAX_VALUE;
				} else {
					mat[i][j] = 0;
				}
			}
		}
		
		int[][] pos = new int[n][2];
		for(int i = 0; i < n; i++) {
			pos[i][0] = r.nextInt();
			pos[i][1] = r.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				double tmp = Math.sqrt(Math.pow(pos[i][0] - pos[j][0], 2) + Math.pow(pos[i][1] - pos[j][1], 2));
				if(tmp <= 10.0) {
					mat[i][j] = tmp;
					mat[j][i] = mat[i][j];
				}
			}
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j] && mat[i][k] != Double.MAX_VALUE && mat[k][j] != Double.MAX_VALUE) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		double result = Double.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j) {
					if(mat[i][j] == Double.MAX_VALUE || mat[i][j] < 0) {
						System.out.println("NE");
						return;
					} else {
						result = Math.max(result, mat[i][j]);
					}
				}
			}
		}
		System.out.println((int) result);
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
