import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1697_2T {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");

		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);

		if (n == k) {
			System.out.println(0);
			return;
		}

		int[] map = new int[100_001];
		map[n] = 1;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);

		int answer = 0;

		Loop:
		while (!queue.isEmpty()) {

			int idx = queue.poll();

			for (int i = 0; i < 3; i++) {

				int next = 0;

				if (i == 0) {
					next = idx + 1;
				}

				if (i == 1) {
					next = idx - 1;
				}

				if (i == 2) {
					next = idx * 2;
				}

				if (next == k) {
					answer = map[idx];
					break Loop;
				}

				if (next >= 0 && next < 100_001 && map[next] == 0) {
					queue.add(next);
					map[next] = map[idx] + 1;
				}
			}
		}

		System.out.println(answer);

	}

}
