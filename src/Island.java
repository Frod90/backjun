import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Island {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			String input = scanner.nextLine();

			List<Integer> rectangleSize = Arrays.stream(input.split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

			List<List<Integer>> islandInformations = new ArrayList<>();

			for (int i = 0; i < rectangleSize.get(1); i++) {

				String inputIslandInformation = scanner.nextLine();

				List<Integer> eachIslandInformation = Arrays.stream(inputIslandInformation.split(" "))
					.map(Integer::parseInt)
					.collect(Collectors.toList());

				islandInformations.add(eachIslandInformation);
			}

			if (input.equals("0 0")) {
				break;
			}

			System.out.println(calculateIslandCount(islandInformations));

		}
	}

	private static int calculateIslandCount(List<List<Integer>> islandInformations) {

		int count = 0;

		for(int i = 0; i < islandInformations.size(); i++) {
			for(int j = 0; j < islandInformations.get(i).size(); j++) {

				if(findIsland(islandInformations, i, j)) {
					count++;
				}
			}
		}

		return count;
	}

	private static boolean findIsland(List<List<Integer>> islandInformations, int i, int j) {

		if (i < 0 || islandInformations.size() - 1 < i || j < 0 || islandInformations.get(i).size() - 1 < j) {
			return false;
		}

		if (islandInformations.get(i).get(j) == 1) {

			islandInformations.get(i).set(j, 0);

			for(List<Integer> eachRow : islandInformations) {
				System.out.println(eachRow);
			}
			System.out.println();

			findIsland(islandInformations, i + 1, j);
			findIsland(islandInformations, i - 1, j);
			findIsland(islandInformations, i, j + 1);
			findIsland(islandInformations, i, j - 1);

			findIsland(islandInformations, i - 1, j - 1);
			findIsland(islandInformations, i + 1, j - 1);
			findIsland(islandInformations, i - 1, j + 1);
			findIsland(islandInformations, i + 1, j + 1);

			return true;
		}

		return false;
	}
}
