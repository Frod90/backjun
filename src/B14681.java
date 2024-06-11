import java.util.Scanner;

public class B14681 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int x = Integer.parseInt(scanner.nextLine());
		int y = Integer.parseInt(scanner.nextLine());

		if (x > 0 && y > 0) {
			System.out.println(1);
		} else if (x < 0 && y > 0) {
			System.out.println(2);
		} else if (x < 0 && y < 0) {
			System.out.println(3);
		} else if (x > 0 && y < 0) {
			System.out.println(4);
		}

	}
}
