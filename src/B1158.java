import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringJoiner;

public class B1158 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = bufferedReader.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");

		int j = 0;
		for (int i = 0; i < n; i++) {

			j = (j + k - 1) % list.size();
			int remove = list.remove(j);
			stringJoiner.add(String.valueOf(remove));
		}

		System.out.println(stringJoiner.toString());

	}
}
