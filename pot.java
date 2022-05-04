import java.util.*;

public class pot {
	public static int calculate(int n) {
		int pow, number, res;
		pow = n % 10;
		number = Math.floorDiv(n, 10);
		res = (int) Math.pow(number, pow);
		return res;
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines = sc.nextInt();
		int total, currNum;
		total = 0;
		for (int i = 0; i < lines; i++) {
			currNum = sc.nextInt();
			total += calculate(currNum);
		}
		System.out.println(total);
	}
}