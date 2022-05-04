import java.io.*;
import java.util.*;


public class conformity {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numFrosh = Integer.parseInt(br.readLine());
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		int mostPopular = 0;
		int pax = 0;
		for (int frosh=0; frosh<numFrosh; frosh++) {
			String[] curLine = br.readLine().split(" ");
			int[] curCombi = new int[5];
			for (int i=0; i<5; i++) {
				curCombi[i] = Integer.parseInt(curLine[i]);
			}
			Arrays.sort(curCombi);
			StringBuilder sb = new StringBuilder();
			for (int x=0; x<5; x++) {
  				sb.append(curCombi[x]);
			}
			String text = sb.toString();
			if (data.getOrDefault(text, -1) == -1) {
				data.put(text, 1);
			} else {
				data.put(text, data.get(text) + 1);
			}
			if (data.get(text) > mostPopular) {
				mostPopular = data.get(text);
				pax = 1;
			} else if (data.get(text) == mostPopular) {
				pax ++;
			}
		}
		pw.println(mostPopular*pax);
		pw.flush();
	}
}