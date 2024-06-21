import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class B5397 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {

			List<String> listCmd = Arrays.stream(bufferedReader.readLine().split(""))
				.collect(Collectors.toList());

			List<String> answer = new LinkedList<>();
			ListIterator<String> iterator = answer.listIterator();

			for (String s : listCmd) {

				if (s.equals("<")) {
					if (iterator.hasPrevious()) {
						iterator.previous();
					}

				} else if (s.equals(">")) {
					if (iterator.hasNext()) {
						iterator.next();
					}

				} else if (s.equals("-")) {
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}

				} else {
					iterator.add(s);
				}
			}

			for (String eachAnswer : answer) {
				bufferedWriter.write(eachAnswer);
			}
			bufferedWriter.write("\n");
			bufferedWriter.flush();
		}

		bufferedWriter.close();
	}
}
