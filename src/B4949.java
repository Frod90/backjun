import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B4949 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String input = bufferedReader.readLine();
			if (input.equals(".")) {
				break;
			}

			String[] split = input.split("");
			Stack<String> strings = new Stack<>();
			boolean correctSign = true;

			for (String s : split) {

				if (s.equals("(") || s.equals("[")) {
					strings.push(s);

				} else if (s.equals(")")) {

					if (strings.isEmpty() || !strings.peek().equals("(")) {
						correctSign = false;
						break;
					} else {
						strings.pop();
					}

				} else if (s.equals("]")) {

					if (strings.isEmpty() || !strings.peek().equals("[")) {
						correctSign = false;
						break;
					} else {
						strings.pop();
					}
				} else if (s.equals(".")) {
					break;
				}

			}

			if (!strings.isEmpty()) {
				correctSign = false;
			}

			if (correctSign) {
				bufferedWriter.write("yes\n");
			} else {
				bufferedWriter.write("no\n");
			}
		}

		bufferedWriter.flush();
		bufferedReader.close();
		bufferedReader.close();

	}
}
