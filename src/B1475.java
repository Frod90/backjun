import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1475 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();

		char[] inputCharArray = input.toCharArray();
		char[] counts = new char[10];

		for (char eachInput : inputCharArray) {

			counts[eachInput - '0']++;
		}

		for (char count : counts) {
			System.out.print(count);
		}
	}

}
