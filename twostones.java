import java.util.*;

public class twostones {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int stones = sc.nextInt();
		if (stones%2==0) {
			System.out.println("Bob");
		}
		else {
			System.out.println("Alice");
		}
	}
}