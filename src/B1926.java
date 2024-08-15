import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1926 {

	private static final int[] dx = {0, 0, 1, -1};
	private static final int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String input = bufferedReader.readLine();
		String[] split = input.split(" ");

		int xLength = Integer.parseInt(split[0]);
		int yLength = Integer.parseInt(split[1]);

		int[][] map = new int[xLength][yLength];

		for (int i = 0; i < xLength; i++) {

			String[] splitRow = bufferedReader.readLine().split(" ");
			for (int j = 0; j < yLength; j++) {
				map[i][j] = Integer.parseInt(splitRow[j]);
			}
		}

		boolean[][] visitMap = new boolean[xLength][yLength];

		int max = 0;
		int count = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {

				if (visitMap[i][j] || map[i][j] == 0) {
					continue;
				}

				int size = 1;

				Queue<Point> queue = new LinkedList<>();
				queue.add(new Point(i, j));
				visitMap[i][j] = true;

				while (!queue.isEmpty()) {

					Point poll = queue.poll();

					for (int k = 0; k < dx.length; k++) {

						int x = poll.x + dx[k];
						int y = poll.y + dy[k];

						if (x >= xLength || x < 0 || y >= yLength || y < 0 || visitMap[x][y] || map[x][y] == 0) {
							continue;
						}

						queue.add(new Point(x, y));
						visitMap[x][y] = true;
						size++;

					}

				}

				if (size > 0) {
					count++;
					max = Math.max(max, size);
				}

			}

		}

		System.out.println(count);
		System.out.println(max);

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
