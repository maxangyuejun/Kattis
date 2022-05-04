import java.util.*;
import java.io.*;

public class joinstrings {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numStr = Integer.parseInt(br.readLine());
		if (numStr == 1) {
			pw.println(br.readLine());
		} else {
			String[] storage = new String[numStr];
			ArrayList<TailedLinkedList> xxx = new ArrayList<TailedLinkedList>();
			for (int n=0; n<numStr; n++) {
				storage[n] = br.readLine();
				TailedLinkedList test = new TailedLinkedList();
				test.addFront(n);
				xxx.add(test);
			}
			int lastI = 0;
			for (int op=0; op<numStr-1; op++) {
				String[] currLine = br.readLine().split(" ");
				int firstIndex, secondIndex;
				firstIndex = Integer.parseInt(currLine[0]) - 1;
				secondIndex = Integer.parseInt(currLine[1]) - 1;
				TailedLinkedList firstLL = xxx.get(firstIndex);
				TailedLinkedList secondLL = xxx.get(secondIndex);
				firstLL.extend(secondLL);
				xxx.set(firstIndex, firstLL);
				if (op == numStr-2) {
					lastI = firstIndex;
				}
			}
			TailedLinkedList lul = xxx.get(lastI);
			StringBuilder str = new StringBuilder();
			for (int x=0; x<numStr; x++) {
				int strIndex = lul.removeFront();
				str.append(storage[strIndex]);
			}
			pw.println(str.toString());
		}
		pw.flush();
	}
}