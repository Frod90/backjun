import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class B11328 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {

			String input = bufferedReader.readLine();
			String[] split = input.split(" ");


			char[] charArray01 = split[0].toCharArray();
			Arrays.sort(charArray01);

			char[] charArray02 = split[1].toCharArray();
			Arrays.sort(charArray02);

			boolean match = true;
			for (int j = 0; j < charArray01.length; j++) {

				if(charArray01[j] != charArray02[j]){
					match = false;
					break;
				}
			}

			if(match) {
				System.out.println("Possible");
			}else {
				System.out.println("Impossible");
			}
		}

	}
}
