import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ValutaMendo {
	
	private static class State {
		
		public int index;
		public double value;
		public int length;
		public State parent;
		public int startIndex;
		public int sum;
		
		public State(int index, double value, int length, State parent, int startIndex, int sum) {
			this.index = index;
			this.value = value;
			this.length = length;
			this.parent = parent;
			this.startIndex = startIndex;
			this.sum = sum;
		}
		
	}
	
	private static void print(State s) {
		if(s.parent != null) {
			print(s.parent);
			System.out.print("-");
		}
		System.out.print((s.index + 1));
	}

	public static void main(String[] args) {
		FastReader r = new FastReader();
		
		int n = r.nextInt();
		double[][] mat = new double[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				mat[i][j] = r.nextDouble();
			}
		}
		
		Stack<State> stack = new Stack<State>();
		for(int i = n-1; i >= 0; i--) {
			stack.push(new State(i, 1.0, 0, null, i, i));
		}
		
		State candidate = new State(0, 0.0, Integer.MAX_VALUE, null, 0, 0);
		while(!stack.isEmpty()) {
			State t = stack.pop();

			// expand node
			for(int i = 0; i < n; i++) {
				if(i != t.index) {
					State newState = new State(i, t.value*mat[t.index][i], t.length+1, t, t.startIndex, t.sum+i);
					if(newState.index == t.startIndex) {
						if(newState.value > 1.01) {
							//print(candidate);
							//System.out.println("");
							if(newState.length < candidate.length) {
								candidate = newState;
							} else if(newState.length == candidate.length && newState.sum <= candidate.sum) {
								candidate = newState;
							}
						}
					} else if(newState.length < n && newState.length <= candidate.length) {
						stack.push(newState);
					}
				}
			}
		}
		
		if(candidate.length == Integer.MAX_VALUE) {
			System.out.println("ne postoi profitabilna sekvenca");
		} else {
			//System.out.println(candidate.value);
			print(candidate);
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
