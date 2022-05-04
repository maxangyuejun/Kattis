import java.io.*;
import java.util.*;

public class dominos {
	@SuppressWarnings("unchecked")
	public static void DFSrec(ArrayList<ArrayList<Integer>> adjList, int v, int[] visited, ArrayList<Integer> toposort) {
		visited[v] = 1;
		ArrayList<Integer> neighbours = adjList.get(v);
		int n = neighbours.size();
		for (int a=0; a<n; a++) {
			int curNeighbour = neighbours.get(a);
			if (visited[curNeighbour] == 0) {
				DFSrec(adjList, curNeighbour, visited, toposort);
			}
		}
		toposort.add(v);
	}

	public static void counter(ArrayList<ArrayList<Integer>> adjList, int v, int[] visited) {
		visited[v] = 1;
		ArrayList<Integer> neighbours = adjList.get(v);
		int n = neighbours.size();
		for (int a=0; a<n; a++) {
			int curNeighbour = neighbours.get(a);
			if (visited[curNeighbour] == 0) {
				counter(adjList, curNeighbour, visited);
			}
		}
	}

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numTC = Integer.parseInt(br.readLine());

		for (int tc=0; tc<numTC; tc++) {
			String[] data = br.readLine().split(" ");
			int numDominos = Integer.parseInt(data[0]);
			int numEdges = Integer.parseInt(data[1]);

			int[] visited = new int[numDominos];

			ArrayList<Integer> toposort = new ArrayList<Integer>(numDominos);
			ArrayList<ArrayList<Integer>> allDominos = new ArrayList<ArrayList<Integer>>(numDominos);
			ArrayList<ArrayList<Integer>> transposedDominos = new ArrayList<ArrayList<Integer>>(numDominos);
			for (int z=0; z<numDominos; z++) {
				allDominos.add(new ArrayList<Integer>());
				transposedDominos.add(new ArrayList<Integer>());
				visited[z] = 0;
			}

			for (int x=0; x<numEdges; x++) {
				String[] curEdge = br.readLine().split(" ");
				int first = Integer.parseInt(curEdge[0]) - 1;
				int second = Integer.parseInt(curEdge[1]) - 1;

				ArrayList cur = allDominos.get(first); //adjacency list
				cur.add(second);
				allDominos.set(first, cur);


				ArrayList curT = transposedDominos.get(second); //transposed adjacency list
				curT.add(first);
				transposedDominos.set(second, curT);
			}

			for (int v=0; v<numDominos; v++) {
				if (visited[v] == 0) {
					DFSrec(allDominos,v,visited,toposort);
				}
			}
			for (int c=0; c<numDominos; c++) {
				visited[c] = 0;
			}

			int count = 0;
			for (int i=0; i<numDominos; i++) {
				int curNum = toposort.get(numDominos-1-i);
				if (visited[curNum] == 0) {
					counter(allDominos, curNum, visited);
					count ++;
				}
			}
			pw.println(count);
		}

		pw.flush();
	}
}