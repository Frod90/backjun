import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10808 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();

		int[] ap = new int[26];
		char[] charArray = input.toCharArray();

		for (char c : charArray) {
			ap[c - 'a']++;
		}

		System.out.print(ap[0]);
		for (int i = 1; i < ap.length; i++) {
			System.out.print(" " + ap[i]);
		}

		List<Integer> list = new ArrayList<>();
		list.get(1);

	}
}
