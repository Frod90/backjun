import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B7576 {

	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] split = bufferedReader.readLine().split(" ");

		int w = Integer.parseInt(split[0]);
		int h = Integer.parseInt(split[1]);

		int[][] map = new int[h][w];
		boolean[][] visitMap = new boolean[h][w];

		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < h; i++) {

			String[] row = bufferedReader.readLine().split(" ");

			for (int j = 0; j < w; j++) {

				int eachTomato = Integer.parseInt(row[j]);

				if (eachTomato == 1) {
					queue.add(new Point(j, i));
					visitMap[i][j] = true;
				}

				map[i][j] = eachTomato;
			}
		}

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int i = 0; i < dx.length; i++) {

				int x = point.x + dx[i];
				int y = point.y + dy[i];

				if (x >= w || x < 0 || y >= h || y < 0 || visitMap[y][x] || map[y][x] == -1) {
					continue;
				}

				queue.add(new Point(x, y));
				map[y][x] = map[point.y][point.x] + 1;
				visitMap[y][x] = true;

			}

		}

		int answer = 0;

		Loop:
		for (int[] ints : map) {
			for (int anInt : ints) {

				if (anInt == 0) {
					answer = 0;
					break Loop;
				}

				answer = Math.max(answer, anInt);
			}
		}

		System.out.println(answer - 1);

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
