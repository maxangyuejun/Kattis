import java.util.*;
import java.io.*;

public class apaxiaaans {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String word = br.readLine();
		StringBuilder ans = new StringBuilder();
		char prevChar = word.charAt(0);
		ans.append(prevChar);
		char currChar;
		for (int i=1; i<word.length(); i++) {
			currChar = word.charAt(i);
			if (currChar != prevChar) {
				ans.append(currChar);
			}
			prevChar = currChar;
		}
		pw.println(ans);
		pw.flush();
	}
}