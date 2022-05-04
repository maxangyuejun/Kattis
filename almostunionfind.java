import java.io.*;
import java.util.*;

class UnionFind {                                              
  public int[] p;
  public int[] size;
  public long[] sums;
  public int[] exactpos;

  public UnionFind(int N) {
    p = new int[N+1];
    size = new int[N+1];
    sums = new long[N+1];
    exactpos = new int[N+1];
    for (int i = 0; i < N+1; i++) {
      p[i] = i;
      sums[i] = 0l + i;
      size[i] = 1;
      exactpos[i] = 0;
    }
  }

  public int findSet(int i) { 
    int j = exactpos[i];
    if (j == 0) {
      while (p[i] != i) {
        i = p[i];
      }
      return i;
    } else {
      while (p[j] != j) {
        j = p[j];
      }
      return j;
    }
  }

  public Long getSum(int i) {
    int mainSet = findSet(i);
    return sums[mainSet];
  }

  public String getStrArray() {
    return Arrays.toString(sums);
  }

  public String getExactArray() {
    return Arrays.toString(exactpos);
  }

  public String getAUFArray() {
    return Arrays.toString(p);
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public int getNumElement(int i) {
    int mainSet = findSet(i);
    return size[mainSet];
  }

  public void move(int i, int j) {
    if (!isSameSet(i,j)) {
      int x = findSet(i), y = findSet(j);
      size[x] -= 1;
      sums[x] -= i;
      size[y] += 1;
      sums[y] += i;
      exactpos[i] = y;
    }
  }

  public void unionSet(int i, int j) {
    if (!isSameSet(i,j)) {
      int x = findSet(i), y = findSet(j);
      
      if (size[x] < size[y]) {
        p[x] = y;
        size[y] = size[y] + size[x];
        size[x] = 0;
        sums[y] = sums[y] + sums[x];
        sums[x] = 0;
      } else {
        p[y] = x;
        size[x] = size[x] + size[y];
        size[y] = 0;
        sums[x] = sums[x] + sums[y];
        sums[y] = 0;
      }
    }
  }
}

public class almostunionfind {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    try {
      while (true) {
        int numbers = io.getInt();
        int commands = io.getInt();
        UnionFind disjointSet = new UnionFind(numbers);
        for (int c = 0; c<commands; c++) {
          int type = io.getInt(); 
          if (type == 3) {
            int target = io.getInt(); 
            int size = disjointSet.getNumElement(target);
            Long sumSet = disjointSet.getSum(target);
            io.println(size + " " + sumSet);
          } else {
            int p = io.getInt();
            int q = io.getInt();
            if (type == 1) {
              disjointSet.unionSet(p,q);
            } else {
              disjointSet.move(p,q);
            }
          }
        }
      }
    } catch (Exception endOfFileException) {
      io.close();
    } finally {
      io.close();
    }
  }
}
