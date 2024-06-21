import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3273 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		String input = bufferedReader.readLine().trim();
		int x = Integer.parseInt(bufferedReader.readLine().trim());
		bufferedReader.close();

		int[] list = Arrays.stream(input.trim().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		int answer = 0;
		int i = 0;
		int j = list.length - 1;

		while (i < j) {

			int a = list[i];
			int b = list[j];
			int sum = a + b;

			if (sum == x) {
				answer++;
				i++;
				j--;
			} else if (sum < x) {
				i++;
			} else {
				j--;
			}
		}

		System.out.println(answer);
	}
}
