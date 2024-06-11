import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B18108 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(bufferedReader.readLine().trim());

		System.out.println(input - 543);

	}
}
