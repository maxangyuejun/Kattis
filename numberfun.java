import java.util.*;

public class numberfun {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int firstNum, secondNum, result;
		for (int i = 0; i < cases; i++) {
			firstNum = sc.nextInt();
			secondNum = sc.nextInt();
			result = sc.nextInt();
			if (firstNum + secondNum == result || firstNum * secondNum == result) {
				System.out.println("Possible");
			}
			else if (firstNum * result == secondNum || secondNum * result == firstNum) {
				System.out.println("Possible");
			}
			else if (firstNum - secondNum == result || secondNum - firstNum == result) {
				System.out.println("Possible");
			}
			else {
				System.out.println("Impossible");
			}
		}
	}
}