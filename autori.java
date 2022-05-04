import java.util.*;

public class Autori {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String names = sc.next();
		String ans = names.substring(0,1);
		int i = names.indexOf("-");
		while (i != -1) {
			ans += names.substring(i+1, i+2);
			i = names.indexOf("-", i+1);
		}
		System.out.println(ans);
	}
}