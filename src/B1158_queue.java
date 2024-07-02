import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class B1158_queue {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		StringJoiner stringJoiner = new StringJoiner(", ", "<", ">");

		int i = 1;
		while (!queue.isEmpty()) {

			Integer poll = queue.poll();

			if (i < k) {
				queue.add(poll);
			} else {
				stringJoiner.add(String.valueOf(poll));
				i = 0;
			}

			i++;
		}

		System.out.println(stringJoiner);
	}
}
