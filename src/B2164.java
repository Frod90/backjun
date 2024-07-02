import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B2164 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int i = 0;

		while (queue.size() > 1) {

			if (i % 2 == 0) {
				queue.poll();
			} else {
				Integer poll = queue.poll();
				queue.add(poll);
			}

			i++;
		}

		System.out.println(queue.poll());
		bufferedReader.close();
	}

}
