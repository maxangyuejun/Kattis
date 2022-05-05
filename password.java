import java.io.*;
import java.util.*;

public class password {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int numPasswords = Integer.parseInt(br.readLine());
		double[] probabilities = new double[numPasswords];

		for (int n=0; n<numPasswords; n++) {
			probabilities[n] = Double.parseDouble(br.readLine().split(" ")[1]);
		}
		Arrays.sort(probabilities);

		double expected = 0d;
		int multiplier = 1;

		for (int i=numPasswords-1; i>=0; i--) {
			expected += probabilities[i]*multiplier;
			multiplier++;
		}

		pw.println(expected);
		pw.flush();
	}
}