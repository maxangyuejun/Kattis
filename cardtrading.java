import java.util.*;
import java.io.*;

class Card implements Comparable<Card>{
	int card, qty;
	long buy, sell;
	public Card(int card, int qty, long buy, long sell) {
		this.card = card;
		this.qty = qty;
		this.buy = buy;
		this.sell = sell;
	}
	public long getOppCost() {
		if (qty == 2) {
			return getSoldValue();
		} else {
			return getSoldValue() + getBuyCost();
		}
	}

	public int getQty() {
		return qty;
	}

	public long getSoldValue() {
		return qty*sell;
	}

	public long getBuyCost() {
		return (2-qty)*buy;
	}

	public int compareTo(Card other) {
		return Long.compare(this.getOppCost(), other.getOppCost());
	}                                
}

public class cardtrading {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String[] bgData = br.readLine().split(" ");
		int numCards = Integer.parseInt(bgData[0]);
		int numType = Integer.parseInt(bgData[1]);
		int target = Integer.parseInt(bgData[2]);
		String[] ownedCards = br.readLine().split(" ");
		int[] qtyArray = new int[numType];
		for (int i = 0; i<numCards; i++) {
			int curCard = Integer.parseInt(ownedCards[i]);
			qtyArray[curCard-1] += 1;
		}
		ArrayList<Card> typesList = new ArrayList<Card>();
		for (int x = 0; x<numType; x++) {
			String[] prices = br.readLine().split(" ");
			long buyP = Long.parseLong(prices[0]);
			long sellP = Long.parseLong(prices[1]);
			typesList.add(new Card(x+1, qtyArray[x] , buyP, sellP));
		}
		Collections.sort(typesList);
		long profit = 0;
		for (int y = 0; y<numType; y++) {
			if (y < target) {
				if (typesList.get(y).getQty() != 2) {
					profit -= typesList.get(y).getBuyCost();
				} 
			} else {
				profit += typesList.get(y).getSoldValue();
			}
		}
		pw.println(profit);
		pw.flush();
	}
}