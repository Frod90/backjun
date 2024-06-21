import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class B2577 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int input01 = Integer.parseInt(bufferedReader.readLine());
		int input02 = Integer.parseInt(bufferedReader.readLine());
		int input03 = Integer.parseInt(bufferedReader.readLine());

		long result = (long)input01 * input02 * input03;

		String string = Objects.toString(result);

		char[] charArray = string.toCharArray();
		int[] num = new int[10];

		for (char c : charArray) {
			num[c - '0']++;
		}

		for (int i : num) {
			System.out.println(i);
		}

	}
}
