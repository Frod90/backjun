import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {

			int xSize = scanner.nextInt();
			int ySize = scanner.nextInt();

			if(xSize == 0 && ySize == 0) {
				break;
			}

			int[][] islandInformation = new int[ySize][xSize];

			for(int i = 0; i < ySize; i++) {
				for(int j = 0; j < xSize; j++) {

					int information = scanner.nextInt();
					islandInformation[i][j] = information;
				}
			}

			for(int[] eachRow : islandInformation) {
				for(int eachArea : eachRow) {
					System.out.print(eachArea + ", ");
				}
				System.out.print("\n");
			}

			System.out.println();

		}
	}
}