import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ToplinskaSmrtMendo {

	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		int[] energy = new int[n];
		for(int i = 0; i < n; i++) {
			energy[i] = r.nextInt();
		}
		
		int counter = 0;
		
		Arrays.sort(energy);
		
		boolean found = true;
		while(found) {
			found = false;
			for(int i = n-1; i > 0; i--) {	
				int t = energy[i] - energy[i-1];
				if(t >= 2) {
					energy[i]--;
					energy[i-1]++;
					counter++;
					found = true;
				}
			}
		}
		
		found = true;
		while(found) {
			found = false;
			for(int i = n-1; i > 0; i--) {
				for(int j = i-1; j >= 0; j--) {
					if(energy[i] - energy[j] >= 2) {
						found = true;
						energy[i]--;
						energy[j]++;
						counter++;
					}
				}
				Arrays.sort(energy);
			}
		}
		
		/*for(int i = 0; i < n; i++) {
			System.out.print(energy[i] + " ");
		}*/
		
		System.out.println(counter);
	}
	
	static class FastReader {		
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
