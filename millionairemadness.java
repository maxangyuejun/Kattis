import java.io.*;
import java.util.*;

public class millionairemadness {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		String[] info = br.readLine().split(" ");
		int length = Integer.parseInt(info[0]);
		int breadth = Integer.parseInt(info[1]);

		int[][] vault = new int[length][breadth];
		for (int a=0; a<length; a++) {
			String[] curRow = br.readLine().split(" ");
			for (int b=0; b<breadth; b++) {
				vault[a][b] = Integer.parseInt(curRow[b]);
			}
		}

		PriorityQueue <IntegerTriple> pq = new PriorityQueue <IntegerTriple>();
		int[][] move = {{0,1}, {1,0}, {-1,0}, {0,-1}};
		int ladder = 0;
		pq.add(new IntegerTriple(0, 0, 0));

		while (!pq.isEmpty()) {
			IntegerTriple curSpot = pq.poll();
			int curR = curSpot.second();
			int curC = curSpot.third();
			int cost = curSpot.first();
			if (vault[curR][curC] >= 0) {
				int curHeight = vault[curR][curC];
				vault[curR][curC] = -1;
				if (cost > ladder) {
					ladder = cost;
				}
				if (curR==length-1 && curC==breadth-1) {
					pw.println(ladder);
					break;
				}
				for (int i=0; i<4; i++) {
					int nextR = curR + move[i][0];
					int nextC = curC + move[i][1];
					if (nextR>=0&&nextC>=0&&nextR<length&&nextC<breadth&&vault[nextR][nextC]>=0) {
						int curCost = vault[nextR][nextC] - curHeight;
						pq.add(new IntegerTriple(curCost, nextR, nextC));
					}
				}
			}
		}

		pw.flush();
	}
}

class IntegerTriple implements Comparable<IntegerTriple> {
  public Integer _first, _second, _third;

  public IntegerTriple(Integer f, Integer s, Integer t) {
    _first = f;
    _second = s;
    _third = t;
  }

  public int compareTo(IntegerTriple o) {
    if (!this.first().equals(o.first()))
      return this.first() - o.first();
    else if (!this.second().equals(o.second()))
      return o.second() - this.second();
    else
      return o.third() - this.third();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }

  public String toString() { return first() + " " + second() + " " + third(); }
}