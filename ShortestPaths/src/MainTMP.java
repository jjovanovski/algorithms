import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainTMP {
	
	private static class Location {
		
		public ArrayList<Integer> dis = new ArrayList<Integer>();
		
	}
	
	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		int m = r.nextInt();
		
		Location[][] mat = new Location[n+1][n+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= n; j++) {
				mat[i][j] = new Location();
				if(i == j) {
					mat[i][j].dis.add(0);
				} else {
					mat[i][j].dis.add(Integer.MAX_VALUE);
				}
			}
		}
		
		for(int i = 0; i < m; i++) {
			int from = r.nextInt();
			int to = r.nextInt();
			int cost = r.nextInt();
			mat[from][to].dis.add(cost);
			mat[to][from].dis.add(cost);
		}
		
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
