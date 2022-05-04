import java.util.*;

public class lastfactorialdigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sets = sc.nextInt();
		Integer currNum;
		int amt;
		for (int i=0; i<sets; i++) {
			currNum = sc.nextInt();
			amt = 1;
			for (int x = currNum; x>1; x--) {
				amt *= x;
			}
			while (amt > 9) {
				amt = amt%10;
			}
			System.out.println(amt);
		}
	}
}