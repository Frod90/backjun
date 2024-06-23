import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B3986 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine());

		int answer = 0;

		for (int i = 0; i < n; i++) {
			String input = bufferedReader.readLine();

			if (input.length() % 2 != 0) {
				continue;
			}

			Stack<Character> characters = new Stack<>();

			for (int j = 0; j < input.length(); j++) {

				char each = input.charAt(j);

				if (!characters.isEmpty() && characters.peek() == each) {
					characters.pop();
				} else {
					characters.push(each);
				}

			}

			if (characters.isEmpty()) {
				answer++;
			}
		}

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
	}
}
