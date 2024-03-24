import java.util.Scanner;

public class B10026DFS {

	public static void main(String[] args) {

		// 입력
		Scanner scanner = new Scanner(System.in);
		int mapSize = scanner.nextInt();
		scanner.nextLine();

		String[][] map = new String[mapSize][mapSize];

		for (int i = 0; i < mapSize; i++) {
			String row = scanner.nextLine();
			map[i] = row.split("");

		}

		// 로직
		int normalCount = 0;
		int weaknessCount = 0;

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {

				if (colorWeaknessBlock("Q", map, "R", mapSize, i, j)) {
					normalCount++;
				} else if (colorWeaknessBlock("Q", map, "G", mapSize, i, j)) {
					normalCount++;
				}

				if (colorWeaknessBlock("W", map, "B", mapSize, i, j)) {
					normalCount++;
				}
			}
		}

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {

				if (colorWeaknessBlock("A", map, "Q", mapSize, i, j)) {
					weaknessCount++;
				} else if (colorWeaknessBlock("A", map, "W", mapSize, i, j)) {
					weaknessCount++;
				}
			}
		}

		System.out.println(normalCount + " " + weaknessCount);
	}

	private static boolean colorWeaknessBlock(String sign, String[][] map, String color, int mapSize, int i, int j) {

		if (i < 0 || mapSize <= i || j < 0 || mapSize <= j) {
			return false;
		}

		if (map[i][j].equals(color)) {

			map[i][j] = sign;

			colorWeaknessBlock(sign, map, color, mapSize, i + 1, j);
			colorWeaknessBlock(sign, map, color, mapSize, i - 1, j);
			colorWeaknessBlock(sign, map, color, mapSize, i, j + 1);
			colorWeaknessBlock(sign, map, color, mapSize, i, j - 1);

			return true;
		}

		return false;

	}

}
