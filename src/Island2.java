import static java.util.Arrays.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Island2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			int xSize = scanner.nextInt();
			int ySize = scanner.nextInt();

			if (xSize == 0 && ySize == 0) {
				break;
			}

			int[][] islandInformations = new int[ySize][xSize];

			for (int i = 0; i < ySize; i++) {
				for (int j = 0; j < xSize; j++) {

					int information = scanner.nextInt();
					islandInformations[i][j] = information;
				}
			}

			System.out.println(calculateIslandCount(islandInformations));

		}
	}

	private static int calculateIslandCount(int[][] islandInformations) {

		int count = 0;

		for (int x = 0; x < islandInformations.length; x++) {
			for (int y = 0; y < islandInformations[x].length; y++) {

				if (findIsland(islandInformations, x, y)) {
					count++;
				}
			}
		}

		return count;
	}

	private static boolean findIsland(int[][] islandInformations, int x, int y) {

		if (islandInformations[x][y] == 1) {

			islandInformations[x][y] = 0;
			linkArea(islandInformations, x, y);

			return true;
		}

		return false;
	}

	private static void linkArea(int[][] islandInformations, int x, int y) {

		Queue<List<Integer>> queue = new LinkedList<>();
		queue.offer(asList(x, y));

		int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
		int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

		while (!queue.isEmpty()) {

			List<Integer> searchedArea = queue.poll();
			x = searchedArea.get(0);
			y = searchedArea.get(1);

			for (int i = 0; i < dx.length; i++) {

				int nearX = x + dx[i];
				int nearY = y + dy[i];

				if (nearX < 0 || islandInformations.length - 1 < nearX || nearY < 0
					|| islandInformations[x].length - 1 < nearY) {
					continue;
				}

				if (islandInformations[nearX][nearY] == 0) {
					continue;
				}

				if (islandInformations[nearX][nearY] == 1) {
					queue.offer(asList(nearX, nearY));
					islandInformations[nearX][nearY] = 0;
				}

				for(int[] eachRow : islandInformations) {
					for(int eachInformation : eachRow) {
						System.out.print(eachInformation +", ");
					}
					System.out.print("\n");
				}
				System.out.println();
			}

		}
	}

}
