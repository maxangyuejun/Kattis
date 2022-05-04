import java.util.*;
import java.io.*;

class Person {
	public String name;
	public double start;
	public double end;

	public Person(String name, double start, double end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public double getStart() {
		return start;
	}

	public double getEnd() {
		return end;
	}

	public String toString() {
		return name + " - " + start + " - " + end;
	}
}

class EndTimeComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2) {
		return Double.compare(p1.getEnd(), p2.getEnd());
	}

	public boolean equals(Object obj) {
		return this == obj;
	}
}

public class bestrelayteam {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		EndTimeComparator etc = new EndTimeComparator();
		int numAthletes = Integer.parseInt(br.readLine());
		double currStart, currEnd;
		Person[] p = new Person[numAthletes];
		for (int a=0; a < numAthletes; a++) {
			String[] currAthlete = br.readLine().split(" ");
			String currName = currAthlete[0];
			currStart = Double.parseDouble(currAthlete[1]);
			currEnd = Double.parseDouble(currAthlete[2]);
			p[a] = new Person(currName, currStart, currEnd);
		}
		List<Person> list = Arrays.asList(p);
		Collections.sort(list, etc);
		Person first;
		double bestTime = 81.0d;
		String bestFirst = "";
		String bestSecond = "";
		String bestThird = "";
		String bestFourth = "";
		for (int i=0; i<numAthletes; i++) {
			Person second = null;
			Person third = null;
			Person fourth = null;
			first = list.get(i);
			double currTime;
			int curIndex = 0;
			while (second==null || third==null || fourth==null) {
				if (curIndex == i) {
					curIndex += 1;
				} else {
					if (second==null) {
						second = list.get(curIndex);
						curIndex += 1;
					} else if (third==null) {
						third = list.get(curIndex);
						curIndex += 1;
					} else {
						fourth = list.get(curIndex);
					}
				}
			}
			currTime = first.getStart() + second.getEnd() + third.getEnd() + fourth.getEnd();
			if (currTime < bestTime) {
				bestTime = currTime;
				bestFirst = first.getName();
				bestSecond = second.getName();
				bestThird = third.getName();
				bestFourth = fourth.getName();
			}
		}
		pw.println(bestTime);
		pw.println(bestFirst);
		pw.println(bestSecond);
		pw.println(bestThird);
		pw.println(bestFourth);
		pw.flush();
	}
}