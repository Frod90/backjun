import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BB1475 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();

		int[] ints = new int[9];

		for (char c : input.toCharArray()) {

			if (c == '9') {
				ints[6]++;
				continue;
			}

			ints[c - '0']++;
		}

		if (ints[6] % 2 != 0) {
			ints[6] = ints[6] / 2 + 1;
		} else {
			ints[6] = ints[6] / 2;
		}

		int max = 0;
		for (int i : ints) {
			max = Math.max(max, i);
		}

		System.out.println(max);

	}
}
