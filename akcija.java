import java.io.*;
import java.util.*;


public class akcija {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numBooks = Integer.parseInt(br.readLine());

		int[] prices = new int[numBooks];
		for (int b=0; b<numBooks; b++) {
			prices[b] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(prices);

		int setCounter = 1;
		int cost = 0;
		for (int i = numBooks-1; i>=0; i--) {
			if (setCounter != 3) {
				cost += prices[i];
				setCounter++;
			} 
			else {
				setCounter = 1;
			}
		}

		pw.println(cost);

		pw.flush();
	}
}