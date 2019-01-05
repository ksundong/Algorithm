package AplusB;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String rawInput = sc.nextLine();

		int a = Integer.parseInt(rawInput.split(" ")[0]);
		int b = Integer.parseInt(rawInput.split(" ")[1]);

		if (a <= 0 || a >= 10 || b <= 0 || b >= 10) {
			System.out.println("오류");
		} else {
			System.out.println(a + b);
		}
	}

}
