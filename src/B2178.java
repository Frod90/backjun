import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2178 {

	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = bufferedReader.readLine().split(" ");

		int h = Integer.parseInt(split[0]);
		int w = Integer.parseInt(split[1]);

		int[][] map = new int[h][w];
		boolean[][] visitMap = new boolean[h][w];

		for (int i = 0; i < h; i++) {

			String[] row = bufferedReader.readLine().split("");

			for (int j = 0; j < row.length; j++) {
				map[i][j] = Integer.parseInt(row[j]);
			}

		}

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visitMap[0][0] = true;

		while (!queue.isEmpty()) {

			Point poll = queue.poll();

			for (int i = 0; i < dx.length; i++) {

				int x = poll.x + dx[i];
				int y = poll.y + dy[i];

				if (x >= w || x < 0 || y >= h || y < 0 || visitMap[y][x] || map[y][x] == 0) {
					continue;
				}

				queue.add(new Point(x, y));
				visitMap[y][x] = true;
				map[y][x] = map[poll.y][poll.x] + 1;

			}
		}

		System.out.println(map[h - 1][w - 1]);

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
