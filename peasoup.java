import java.util.*;
public class peasoup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numRestaurants = sc.nextLine();
		int numShops = Integer.parseInt(numRestaurants);
		for (int i=0; i<numShops; i++) {
			int menuItems = Integer.parseInt(sc.nextLine());
			String shopName = sc.nextLine();
			boolean containsPancake = false;
			boolean containsPeaSoup = false;
			for (int n=0; n<menuItems; n++) {
				String currItem = sc.nextLine();
				if (currItem.equals("pea soup")) {
					containsPeaSoup = true;
				} else if (currItem.equals("pancakes")) {
					containsPancake = true;
				}
			}
			if (containsPancake == true && containsPeaSoup == true) {
				System.out.println(shopName);
				return;
			}
		}
		System.out.println("Anywhere is fine I guess");
	}
}