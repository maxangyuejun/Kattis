import java.util.*;
import java.io.*;


public class coconut {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] data = br.readLine().split(" ");
		int syllables, playerCount;
		syllables = Integer.parseInt(data[0]);
		playerCount = Integer.parseInt(data[1]);
		int[] status = new int[playerCount*2];
		for (int s=0; s<playerCount; s++) {
			status[s*2] = 1;
			status[s*2+1] = 0;
		}
		int curSize = playerCount*2;
		int curIndex = 0;
		int curStatus = 0;
		while (curSize != 1) {
			int counter = syllables;
			while (counter > 0) {
				if (curIndex >= playerCount*2) {
					curIndex = curIndex % (playerCount*2);
				}
				curStatus = status[curIndex];
				if (curStatus == 1) {
					counter -= 1;
					curIndex += 2;
				} else if (curStatus == 2 || curStatus == 3) {
					counter -= 1;
					curIndex += 1;
				} else {
					curIndex += 1;
				}
			}
			if (curStatus == 1) {
				curIndex -= 2;
				status[curIndex] = 2;
				status[curIndex+1] = 2;
			} else if (curStatus == 2) {
				status[curIndex-1] = 3;

			} else {
				status[curIndex-1] = 4;
				curSize -= 1;
			}
		}
		for (int x=0; x<playerCount*2; x++) {
			if (status[x] != 4) {
				pw.println(Math.floorDiv(x,2) + 1);
				break;
			}
		}
		pw.flush();
	}
}
