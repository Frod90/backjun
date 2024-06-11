import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2753 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(bufferedReader.readLine().trim());

		if (input % 4 == 0 && input % 100 != 0 || input % 400 == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}
}
