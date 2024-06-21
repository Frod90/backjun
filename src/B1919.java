import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1919 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String input01 = bufferedReader.readLine();
		String input02 = bufferedReader.readLine();

		char[] charArray01 = input01.toCharArray();
		char[] charArray02 = input02.toCharArray();

		int[] counts = new int['z' - 'a' + 1];

		for (int i = 0; i < charArray01.length; i++) {
			counts[charArray01[i] - 'a']++;
		}

		for (int i = 0; i < charArray02.length; i++) {
			counts[charArray02[i] - 'a']--;
		}

		int answer = 0;
		for (int i = 0; i < counts.length; i++) {
			answer += Math.abs(counts[i]);
		}

		System.out.println(answer);
	}
}
