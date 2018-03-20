import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SobiMendo {
	
	private static class Room {
		
		public int energy;
		public int distance = Integer.MIN_VALUE;
		
	}
	
	private static class Edge {
		public int from, to;
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		Room[] rooms = new Room[n+1];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 1; i <= n; i++) {
			rooms[i] = new Room();
			rooms[i].energy = r.nextInt();
			
			int k = r.nextInt();
			for(int j = 0; j < k; j++) {
				int t = r.nextInt();
				edges.add(new Edge(i, t));
			}
		}
		
		rooms[1].distance = 100;
		
		for(int i = 0; i <= n; i++) {
			for(Edge e : edges) {
				Room u = rooms[e.from];
				Room v = rooms[e.to];
				if(v.distance < u.distance + v.energy && u.distance != Integer.MIN_VALUE && u.distance + v.energy > 0) {
					v.distance = u.distance + v.energy;
				}
			}
		}
		
		//System.out.println(rooms[n].distance);
		if(rooms[n].distance <= 0) {
			System.out.println("NE");
		} else {
			System.out.println("DA");
		}
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
