import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10807 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int[] nums = Arrays.stream(bufferedReader.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();
		int v = Integer.parseInt(bufferedReader.readLine());

		int answer = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == v) {
				answer++;
			} else if (nums[i] > v) {
				break;
			}

		}

		System.out.println(answer);

	}
}
