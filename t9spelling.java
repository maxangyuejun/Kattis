import java.util.*;

public class t9spelling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<Character,String> dict = new HashMap<Character,String>();
		dict.put(' ', "0");
		dict.put('a', "2");
		dict.put('b', "22");
		dict.put('c', "222");
		dict.put('d', "3");
		dict.put('e', "33");
		dict.put('f', "333");
		dict.put('g', "4");
		dict.put('h', "44");
		dict.put('i', "444");
		dict.put('j', "5");
		dict.put('k', "55");
		dict.put('l', "555");
		dict.put('m', "6");
		dict.put('n', "66");
		dict.put('o', "666");
		dict.put('p', "7");
		dict.put('q', "77");
		dict.put('r', "777");
		dict.put('s', "7777");
		dict.put('t', "8");
		dict.put('u', "88");
		dict.put('v', "888");
		dict.put('w', "9");
		dict.put('x', "99");
		dict.put('y', "999");
		dict.put('z', "9999");


		int numCase = sc.nextInt();
		sc.nextLine();
		for (int i=0; i<numCase; i++) {
			String ans = "";
			char prevInput = 'A';
			String currLine = sc.nextLine();
			for (int j=0; j<currLine.length(); j++) {
				char c = currLine.charAt(j);
				String val = dict.get(c);
				if (prevInput == val.charAt(0)) {
					ans = ans + " ";
				}
				ans += val;
				prevInput = val.charAt(0);
			}
			System.out.println("Case #" + (i+1) + ": " + ans);
		}
	}
}