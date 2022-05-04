import java.util.*;
import java.io.*;

public class kattissquest {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int numCommands = Integer.parseInt(br.readLine());
		TreeMap<Integer, PriorityQueue<Integer>> storage = new TreeMap<>();
		TreeSet<Integer> set = new TreeSet<Integer>();

		
		for (int x=0; x<numCommands; x++) {
			String[] curLine = br.readLine().split(" ");
			if (curLine[0].equals("add")) { //add
				int energy = Integer.parseInt(curLine[1]);
				int reward = Integer.parseInt(curLine[2]);
				if (storage.containsKey(energy) == false) {
					PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
					pq.add(reward);
					storage.put(energy, pq);
					set.add(energy);
				} else {
					PriorityQueue pq = storage.get(energy);
					pq.add(reward);
					storage.put(energy, pq);
				}
			} else { //query
				long totalReward = 0;
				int curEnergy = Integer.parseInt(curLine[1]);
				while (set.floor(curEnergy) != null && curEnergy != 0) {
					int energySpent = set.floor(curEnergy);
					PriorityQueue<Integer> pq = storage.get(energySpent);
					curEnergy -= energySpent;
					Integer curReward = pq.poll();
					totalReward += curReward;
					if (pq.size() == 0) {
						storage.remove(energySpent);
						set.remove(energySpent);
					} else {
						storage.put(energySpent, pq);
					}
				}
				pw.println(totalReward);

			}
		}

		pw.flush();
	}
}

