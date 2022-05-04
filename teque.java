import java.io.*;
import java.util.*;

public class teque {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numOperations = Integer.parseInt(br.readLine());
		int size = Math.floorDiv(numOperations,2)+1;
		int[] frontCircle = new int[size];
		int[] backCircle = new int[size];
		int frontIndex = 0;
		int frontLength = 0;
		int backIndex = 0;
		int backLength = 0;
		for (int op = 0; op<numOperations; op++) {
			String[] data = br.readLine().split(" ");
			int value = Integer.parseInt(data[1]);
			if (data[0].indexOf("get") != -1) {
				if (value < frontLength) {
					pw.println(frontCircle[(frontIndex+value)%size]);
				} else {
					pw.println(backCircle[(backIndex+value-frontLength)%size]);
				}
			} else if (data[0].indexOf("middle") != -1) {
				backIndex = (backIndex-1 + size) % size;
				backCircle[backIndex] = value;
				backLength ++;
			} else {
				if (data[0].indexOf("back") != -1) {
					backCircle[(backIndex+backLength+size) % size] = value;
					backLength ++;
				} else {
					frontIndex = (frontIndex-1 + size) % size;
					frontCircle[frontIndex] = value;
					frontLength ++;
				}
			}
			if (backLength - frontLength == 1) {
				frontCircle[(frontIndex+frontLength)%size] = backCircle[backIndex];
				backIndex = (backIndex+1) % size;
				frontLength ++;
				backLength --;
			}
			if (frontLength - backLength == 2) {
				backIndex = (backIndex-1 + size) % size;
				backCircle[backIndex] = frontCircle[(frontIndex+frontLength-1+size)%size];
				frontLength --;
				backLength ++;
			}
		}
		pw.flush();
	}
}