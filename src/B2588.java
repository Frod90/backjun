import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B2588 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int input01 = Integer.parseInt(bufferedReader.readLine());

		String input02 = bufferedReader.readLine();

		List<Integer> split = Arrays.stream(input02.split(""))
			.mapToInt(Integer::parseInt)
			.boxed()
			.collect(Collectors.toList());

		for (int i = split.size() - 1; i >= 0; i--) {
			System.out.println(input01 * split.get(i));
		}

		System.out.println(input01 * Integer.parseInt(input02));
	}
}
