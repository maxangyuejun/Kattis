import java.util.*;
import java.io.*;

public class sumkindofproblem {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numSets = Integer.parseInt(br.readLine());
		int currN, currOdd, currEven, currPositive, dataSetNum;
		for (int set=0; set<numSets; set++) {
			String[] currSet = br.readLine().split(" ");
			currN = Integer.parseInt(currSet[1]);
			dataSetNum = set + 1;
			currOdd = currN * currN;
			currPositive = (currOdd + currN) / 2;
			currEven = currOdd + currN;
			pw.println(dataSetNum + " " + currPositive + " " + currOdd + " " + currEven + " ");
		}
		pw.flush();
	}
}