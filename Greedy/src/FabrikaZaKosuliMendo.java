import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FabrikaZaKosuliMendo {
	
	static class Platno implements Comparable<Platno> {
		public int s, f;

		public Platno(int s, int f) {
			this.s = s;
			this.f = f;
		}
		
		@Override
		public int compareTo(Platno o) {
			return Integer.compare(s, o.s);
		}
		
	}
	
	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		Platno[] p = new Platno[n];
		for(int i = 0; i < n; i++) {
			p[i] = new Platno(r.nextInt(), r.nextInt());
		}
		
		Arrays.sort(p);
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(p[0].f);
		int k = 1;
		for(int i = 1; i < n; i++) {
			int min = q.poll();
			if(p[i].s >= min) {
				int newitem = Math.max(min, p[i].f);
				q.add(newitem);
			} else {
				k++;
				q.add(p[i].f);
				q.add(min);
			}
		}
		System.out.println(k);
		
		/*
		 * This is O(n^2) solution. Not fast enough. :)
		 * 
		 * int[] t = new int[n];
		int k = 0;
		
		for(int i = 0; i < n; i++) {
			boolean used = false;
			for(int j = 0; j <= k; j++) {
				if(p[i].s >= t[j]) {
					used = true;
					t[j] = Math.max(t[j], p[i].f);
					break;
				}
			}
			if(!used) {
				k++;
				t[k] = p[i].f;
			}
		}

		System.out.println(k+1);*/
		
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
