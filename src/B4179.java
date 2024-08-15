import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B4179 {

	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = bufferedReader.readLine().split(" ");

		int h = Integer.parseInt(split[0]);
		int w = Integer.parseInt(split[1]);

		String[][] map = new String[h][w];
		int[][] distances = new int[h][w];

		Queue<Point> userQueue = new LinkedList<>();
		Queue<Point> fireQueue = new LinkedList<>();

		for (int i = 0; i < h; i++) {

			String[] row = bufferedReader.readLine().split("");

			for (int j = 0; j < w; j++) {

				if (row[j].equals("J")) {
					userQueue.add(new Point(j, i));
				}

				if (row[j].equals("F")) {
					fireQueue.add(new Point(j, i));
				}

				map[i][j] = row[j];
			}
		}

		String answer = "IMPOSSIBLE";

		Loop:
		while (!userQueue.isEmpty()) {

			int size = userQueue.size();

			for (int i = 0; i < size; i++) {

				Point userPoint = userQueue.poll();

				if (map[userPoint.y][userPoint.x].equals("F")) {
					continue;
				}

				for (int j = 0; j < dx.length; j++) {

					int userX = userPoint.x + dx[j];
					int userY = userPoint.y + dy[j];

					if (userX >= w || userX < 0 || userY >= h || userY < 0) {
						answer = distances[userPoint.y][userPoint.x] + 1 + "";
						break Loop;
					}

					if (".".equals(map[userY][userX])) {

						userQueue.add(new Point(userX, userY));
						map[userY][userX] = "J";
						distances[userY][userX] = distances[userPoint.y][userPoint.x] + 1;
					}

				}

			}

			size = fireQueue.size();
			for (int i = 0; i < size; i++) {
				Point firePoint = fireQueue.poll();

				for (int j = 0; j < dx.length; j++) {

					int fireX = firePoint.x + dx[j];
					int fireY = firePoint.y + dy[j];

					if (fireX >= w || fireX < 0 || fireY >= h || fireY < 0 ||
						"#".equals(map[fireY][fireX]) || "F".equals(map[fireY][fireX])) {
						continue;
					}

					fireQueue.add(new Point(fireX, fireY));
					map[fireY][fireX] = "F";
				}
			}

		}

		System.out.println(answer);

	}

	private static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
