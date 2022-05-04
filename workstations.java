import java.util.*;
import java.io.*;

class Person implements Comparable<Person> {
	public int arrive;
	public int duration;

	public Person(int arrive, int duration) {
		this.arrive = arrive;
		this.duration = duration;
	}
	public int compareTo(Person other) {
		return arrive - other.arrive;
	}

	public int getArrive() {
		return arrive;
	}
	public int getDuration() {
		return duration;
	}
	public String toString() {
        return String.valueOf(arrive);
    }
}

public class workstations {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] data = br.readLine().split(" ");
		int numResearcher, idleTime;
		numResearcher = Integer.parseInt(data[0]);
		idleTime = Integer.parseInt(data[1]);
		int count = 0;
		if (numResearcher == 1) {
			pw.println(count);
			pw.flush();
			return;
		}
		ArrayList<Person> list = new ArrayList<Person>();
		for (int r=0; r<numResearcher; r++) {
			String[] curPerson = br.readLine().split(" ");
			int arrive = Integer.parseInt(curPerson[0]);
			int duration = Integer.parseInt(curPerson[1]);
			list.add(new Person(arrive, duration));
		}
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int y=0; y<numResearcher; y++) {
			Person cur = list.get(y);
			int curArrive = cur.getArrive();
			int curDuration = cur.getDuration();
			if (pq.size() == 0) {
				pq.add(curArrive+curDuration);
			} else {
				Boolean resolved = false;
				int curStation = pq.peek();
				while (resolved == false) {
					curStation = pq.peek();
					if (curArrive > curStation+idleTime) {
						pq.poll();
						if (pq.size() == 0) {
							resolved = true;
							curStation = -1;
						}
					} else {
						resolved = true;
					} 
				}
				if ((curArrive < curStation) || pq.size() == 0) {
					pq.add(curArrive+curDuration);
				} else {
					pq.poll();
					pq.add(curArrive+curDuration);
					count ++;
				}
			}
		}
		pw.println(count);
		pw.flush();
	}
}