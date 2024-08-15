import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B4963 {

	private static final int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	private static final int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] split = bufferedReader.readLine().split(" ");

			int w = Integer.parseInt(split[0]);
			int h = Integer.parseInt(split[1]);

			if (w == 0 && h == 0) {
				break;
			}

			int[][] map = new int[h][w];
			boolean[][] visitMap = new boolean[h][w];

			for (int i = 0; i < h; i++) {

				String[] row = bufferedReader.readLine().split(" ");

				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}

			int count = 0;

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {

					if (map[i][j] == 0 || visitMap[i][j]) {
						continue;
					}

					count++;

					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(j, i));
					visitMap[i][j] = true;

					while (!queue.isEmpty()) {

						Point point = queue.poll();

						for (int k = 0; k < dx.length; k++) {

							int x = point.x + dx[k];
							int y = point.y + dy[k];

							if (x >= w || x < 0 || y >= h || y < 0) {
								continue;
							}

							if (visitMap[y][x] || map[y][x] == 0) {
								continue;
							}

							queue.add(new Point(x, y));
							visitMap[y][x] = true;

						}
					}

				}
			}

			System.out.println(count);
		}
	}

	private static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
