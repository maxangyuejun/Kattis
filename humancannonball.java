import java.io.*;
import java.util.*;

public class humancannonball {
	public static void main (String[] args) throws IOException {
		Kattio io = new Kattio(System.in, System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		double startX = io.getDouble();
		double startY = io.getDouble();
		double endX = io.getDouble();
		double endY = io.getDouble();

		int numCannon = io.getInt();
		ArrayList<Coordinate> vertexList = new ArrayList<Coordinate>(numCannon+2);
		vertexList.add(new Coordinate(startX, startY));
		vertexList.add(new Coordinate(endX, endY));

		for (int x=0; x<numCannon; x++) { //get arraylist of coordinates for start,end,cannons
			double curX = io.getDouble();
			double curY = io.getDouble();
			vertexList.add(new Coordinate(curX, curY));
		}

		int size = vertexList.size();
		double[][] timeMap = new double[size][size];
		for (int a=0; a<size; a++) {
			Coordinate coordA = vertexList.get(a);
			double aX = coordA.first();
			double aY = coordA.second();
			for (int b=0; b<size; b++) {
				if (b != a) {
					Coordinate coordB = vertexList.get(b);
					double bX = coordB.first();
					double bY = coordB.second();
					double dist = Math.hypot(aX - bX, aY - bY);
					double time1 = dist/5;
					double time2 = 1000000000.0;
					if (a>=2) {
						time2 = 2 + (Math.abs(dist-50)/5);
					}
					timeMap[a][b] = Math.min(time1,time2);
				} 
				else {
					timeMap[a][b] = 1000000000.0;
				}
			}
		}

		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					timeMap[i][j] = Math.min(timeMap[i][j], timeMap[i][k]+timeMap[k][j]);
				}
			}
		}

        io.println(timeMap[0][1]);
		io.close();
	}
}

class Coordinate {
  public double _first, _second;

  public Coordinate(Double f, Double s) {
    _first = f;
    _second = s;
  }

  double first() { return _first; }
  double second() { return _second; }

  public String toString() { return first() + " " + second(); }
}