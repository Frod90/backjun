import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {

			String inputCmd = bufferedReader.readLine();
			String[] split = inputCmd.split("");

			Stack<String> strings = new Stack<>();
			boolean correctSign = true;

			for (String each : split) {
				if (each.equals("(")) {
					strings.push(each);

				} else if (each.equals(")")) {

					if (strings.isEmpty()) {
						correctSign = false;
						break;
					} else {
						strings.pop();
					}
				}
			}

			if (!strings.isEmpty()) {
				correctSign = false;
			}

			if (correctSign) {
				bufferedWriter.write("YES\n");
			} else {
				bufferedWriter.write("NO\n");
			}
		}

		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
	}
}
