import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		FastReader r = new FastReader();
		int n = r.nextInt();
		
		// 65 A, 90 Z, 91 a, 122 z
		
		int[][] mat = new int[123][123];
		for(int i = 0; i < 123; i++) {
			for(int j = 0; j < 123; j++) {
				if(i != j) {
					mat[i][j] = Integer.MAX_VALUE;
				} else {
					mat[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			char p1 = r.nextChar();
			char p2 = r.nextChar();
			int cost = r.nextInt();
			mat[p1][p2] = cost;
			mat[p2][p1] = cost;
		}
		
		for(int k = 65; k <= 122; k++) {
			for(int i = 65; i <= 122; i++) {
				for(int j = 65; j <= 122; j++) {
					if(mat[i][j] > mat[i][k] + mat[k][j] && mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		char maxi = 0, mini = 0;
		for(int i = 65; i < 90; i++) {
			if(mat[i]['Z'] != Integer.MAX_VALUE) {
				if(mat[i]['Z'] > max) {
					max = mat[i]['Z'];
					maxi = (char) i;
				}
				if(mat[i]['Z'] < min) {
					min = mat[i]['Z'];
					mini = (char) i;
				}
			}
		}

		System.out.println(Character.toString(mini) + " "+ min);
		System.out.println(Character.toString(maxi) + " "+ max);
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
		
		public char nextChar() {
			return next().charAt(0);
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
