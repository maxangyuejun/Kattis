import java.util.*;
import java.io.*;



public class lostmap {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int villageNum = Integer.parseInt(br.readLine());
		ArrayList<IntegerTriple> EdgeList = new ArrayList<IntegerTriple>();

		int numEdges = 0;
		for (int v=0; v<villageNum; v++) {
			String[] curVillage = br.readLine().split(" ");
			int firstVillage = v;
			for (int x=v+1; x<villageNum; x++) {
				int curDist = Integer.parseInt(curVillage[x]);
				int secondVillage = x;
				EdgeList.add(new IntegerTriple(curDist, firstVillage, secondVillage));
				numEdges++;
			}
		}
		Collections.sort(EdgeList);

		int numOutputLines = 0;
		UnionFind UF = new UnionFind(villageNum);
		for (int i=0; i<numEdges; i++) {
			IntegerTriple edge = EdgeList.get(i);
			int from = edge.second(), to = edge.third(), dist = edge.first();
			int output1 = from+1, output2 = to+1;
			if (!UF.isSameSet(from, to)) {
				pw.println(output1 + " " + output2);
				numOutputLines ++;
				UF.unionSet(from,to);
			}
			if (numOutputLines == villageNum-1) {
				break;
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
      return this.second() - o.second();
    else
      return this.third() - o.third();
  }

  Integer first() { return _first; }
  Integer second() { return _second; }
  Integer third() { return _third; }

  public String toString() { return first() + " " + second() + " " + third(); }
}

// Union-Find Disjoint Sets Library, using both path compression and union by rank heuristics
class UnionFind {
  public int[] p;
  public int[] rank;
  public int[] setSize;
  public int numSets;

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    setSize = new int[N];
    numSets = N;
    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
      setSize[i] = 1;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      numSets--; 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) { 
      	p[y] = x; 
      	setSize[x] = setSize[x] + setSize[y]; 
      }
      else { 
      	p[x] = y; 
      	setSize[y] = setSize[x] + setSize[y];
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public int numDisjointSets() { return numSets; }

  public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}
