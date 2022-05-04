import java.util.*;


public class different {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLong()){
			long a = sc.nextLong(), b = sc.nextLong();
			long diff = a - b;
			if (diff < 0) {
    			diff = -diff;    
			}
			System.out.println(diff);
		}
		return;
	}
}
