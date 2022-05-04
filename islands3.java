import java.util.*;
import java.io.*;


class Coordinate{
	public int x;
	public int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


public class islands3 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		String[] info = br.readLine().split(" ");
		int numRow = Integer.parseInt(info[0]);
		int numCol = Integer.parseInt(info[1]);

		boolean[][] visited = new boolean[numRow][numCol];
		char[][] storage = new char[numRow][numCol];
		for (int r=0; r<numRow; r++) {
			String curLine = br.readLine();
			for (int c=0; c<numCol; c++) {
				storage[r][c] = curLine.charAt(c);
			}
		}

		int[] xChange = {0, 0, 1, -1};
		int[] yChange = {1, -1, 0, 0};
		int count = 0;
		for (int x=0; x<numRow; x++) {
			for (int y=0; y<numCol; y++) {
				if (storage[x][y] == 'L' && visited[x][y] != true) {
					// pw.println(visited[x][y]);
					// pw.println("visiting" + x + y);
					count ++;
					// pw.println(x);
					// pw.println(y);
					Deque q = new ArrayDeque<Coordinate>();
					// Queue q = new LinkedList<Coordinate>(); //for some reason linkedlist queue doesnt work
					q.add(new Coordinate(x, y));
					visited[x][y] = true;

					while (!q.isEmpty()) {
						Coordinate curSpot = (Coordinate) q.remove();
						// pw.println(q.peek());
						// pw.println("curspot is " + curSpot.x + curSpot.y);
						for (int z=0; z<4; z++) {
							int changedX = curSpot.x + xChange[z];
							int changedY = curSpot.y + yChange[z];
							if (changedX<0 || changedY<0 || changedX>=numRow || changedY>=numCol || storage[changedX][changedY] == 'W' || visited[changedX][changedY] == true ) {
								continue;
							}
							q.add(new Coordinate(changedX, changedY));
							// pw.println("adding " + changedX + changedY);
							// pw.println("size" + q.size());
							// storage[changedX][changedY] = 'V';
							visited[changedX][changedY] = true;
							// pw.println(visited[changedX][changedY]);
						}
					}
				}
			}
		} 
		pw.println(count);
		pw.flush();
	}
}