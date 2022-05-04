import java.util.*;

public class detaileddifferences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sets = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<sets; i++) {
			String answer = "";
			String firstStr = sc.nextLine();
			String secondStr = sc.nextLine();
			System.out.println(firstStr);
			System.out.println(secondStr);
			int len = firstStr.length();
			for (int x=0; x<len; x++) {
				char firstChar = firstStr.charAt(x);
				char secondChar = secondStr.charAt(x);
				if (firstChar == secondChar) {
					answer += ".";
				}
				else {
					answer += "*";
				}
			}
			System.out.println(answer);
		}
	}
}
 