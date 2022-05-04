import java.util.*;
import java.io.*;

public class skener {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] data = br.readLine().split(" ");
		int r, c, zr, zc;
		r = Integer.parseInt(data[0]);
		c = Integer.parseInt(data[1]);
		zr = Integer.parseInt(data[2]);
		zc = Integer.parseInt(data[3]);
		for (int numline=0; numline<r; numline++) {
			StringBuilder str = new StringBuilder();
			String currLine = br.readLine();
			for (int i=0; i<currLine.length(); i++) {
				char currChar = currLine.charAt(i);
				for (int time=0; time<zc; time++) {
					str.append(currChar);
				}
			}
			for (int print=0; print<zr; print++) {
				pw.println(str);
			}
		}
		pw.flush();
	}
}