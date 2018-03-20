import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BombarderMendo {
	
	private static class Tile implements Comparable<Tile> {
		public char c;
		public int i, j;
		public int distance = Integer.MAX_VALUE;
		public int bombsUsed = 0;
		public boolean visited = false;
		
		public Tile(char c, int i, int j) {
			this.c = c;
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Tile o) {
			return Integer.compare(distance, o.distance);
		}
	}
	
	private static boolean valid(int i, int j) {
		if(i >= 0 && j >= 0 && i < 51 && j < 51)
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Tile[][] map = new Tile[51][51];
		Tile start = null, end = null;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				map[i][j] = new Tile(s.charAt(j), i, j);
				
				if(map[i][j].c == 'B') {
					start = map[i][j];
				} else if(map[i][j].c == 'E') {
					end = map[i][j];
				}
			}
		}
		int bombs = Integer.parseInt(br.readLine());
		
		start.distance = 0;
		
		PriorityQueue<Tile> q = new PriorityQueue<Tile>();
		q.add(start);
		
		int[] moves = new int[] {0, 1, 0, -1, 1, 0, -1, 0};
		while(!q.isEmpty()) {
			Tile u = q.poll();
			u.visited = true;
			
			for(int i = 0; i < moves.length-1; i += 2) {
				int x = u.i + moves[i];
				int y = u.j + moves[i+1];
				if(valid(x, y) && map[x][y] != null) {
					if(!map[x][y].visited) {
						if(map[x][y].c == '#') {
							if(map[x][y].distance > u.distance + 3 && u.bombsUsed < bombs) {
								map[x][y].distance = u.distance + 3;
								map[x][y].bombsUsed = 1 + u.bombsUsed;
								q.add(map[x][y]);
							}
						} else {
							if(map[x][y].distance > u.distance + 1) {
								map[x][y].distance = u.distance + 1;
								map[x][y].bombsUsed = u.bombsUsed;
								q.add(map[x][y]);
							}
						}
					}
				}
			}
		}
		
		System.out.println(end.distance == Integer.MAX_VALUE ? -1 : end.distance);
	
	}
	
}
