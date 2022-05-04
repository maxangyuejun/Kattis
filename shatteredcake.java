import java.util.*;
import java.io.*;

public class shatteredcake {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int width = Integer.parseInt(br.readLine());
		int pieces = Integer.parseInt(br.readLine());
		int area, currWidth, currLength, currArea;
		area = 0;
		for (int p=0; p<pieces; p++) {
			String[] currLine = br.readLine().split(" ");
			currWidth = Integer.parseInt(currLine[0]);
			currLength = Integer.parseInt(currLine[1]);
			currArea = currLength * currWidth;
			area += currArea;
		}
		int length = area / width;
		pw.println(length);
		pw.flush();
	}
}