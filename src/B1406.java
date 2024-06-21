import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class B1406 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String inputStr = bufferedReader.readLine();
		int n = Integer.parseInt(bufferedReader.readLine());

		List<Character> list = new LinkedList<>();

		ListIterator<Character> iterator = list.listIterator();
		for (int i = 0; i < inputStr.length(); i++) {
			iterator.add(inputStr.charAt(i));
		}

		for (int i = 0; i < n; i++) {

			String inputCmd = bufferedReader.readLine();

			if (inputCmd.charAt(0) == 'L' && iterator.hasPrevious()) {
				iterator.previous();

			} else if (inputCmd.charAt(0) == 'D' && iterator.hasNext()) {
				iterator.next();

			} else if (inputCmd.charAt(0) == 'B' && iterator.hasPrevious()) {
				iterator.previous();
				iterator.remove();

			} else if (inputCmd.charAt(0) == 'P') {
				iterator.add(inputCmd.charAt(2));
			}

		}

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		for (char s : list) {
			bufferedWriter.write(s);
		}
		bufferedWriter.flush();
	}
}
