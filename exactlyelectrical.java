import java.util.*;
import java.io.*;

public class exactlyelectrical {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] start = br.readLine().split(" ");
		int startX, startY;
		startX = Integer.parseInt(start[0]);
		startY = Integer.parseInt(start[1]);
		String[] end = br.readLine().split(" ");
		int endX, endY;
		endX = Integer.parseInt(end[0]);
		endY = Integer.parseInt(end[1]);
		int distX, distY;
		distX = Math.abs(endX - startX);
		distY = Math.abs(endY - startY);
		int battery = Integer.parseInt(br.readLine());
		int diff = battery-distX-distY;
		if (diff < 0) {
			pw.println("N");
		} else if (diff%2==0) {
			pw.println("Y");
		} else {
			pw.println("N");
		}
		pw.flush();
	}
}