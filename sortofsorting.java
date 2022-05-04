import java.util.*;
import java.io.*;


class Word implements Comparable<Word>{
	String name;
	public Word(String name) {
		this.name = name;
	}
	public char getFirst() {
		return name.charAt(0);
	}
	public char getSecond() {
		return name.charAt(1);
	}
	public int compareTo(Word other) {
		if (Character.compare(name.charAt(0), other.getFirst()) != 0) {
			return Character.compare(name.charAt(0), other.getFirst());
		} else {
			return Character.compare(name.charAt(1), other.getSecond());
		}
	}
	public String toString() {
        return String.valueOf(name);
    }
}


public class sortofsorting {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int num = Integer.parseInt(br.readLine());
		while (num != 0) {
			Word[] allNames = new Word[num];
			ArrayList<Word> listNames = new ArrayList<Word>();
			for (int n=0; n<num; n++) {
				String name = br.readLine();
				allNames[n] = new Word(name);
				listNames.add(new Word(name));
			}
			Collections.sort(listNames);
			for (int x=0; x<num; x++) {
				pw.println(listNames.get(x));
			}
			num = Integer.parseInt(br.readLine());
			pw.println();
		}
		pw.flush();
	}
}