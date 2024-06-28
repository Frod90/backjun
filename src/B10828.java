import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B10828 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] split = bufferedReader.readLine().split(" ");
			String cmd = split[0];

			if (cmd.equals("push")) {
				list.add(Integer.parseInt(split[1]));
			} else if (cmd.equals("pop")) {

				if (list.isEmpty()) {
					bufferedWriter.write("-1\n");
				} else {
					int pop = list.remove(list.size() - 1);
					bufferedWriter.write(pop + "\n");
				}

			} else if (cmd.equals("size")) {
				bufferedWriter.write(list.size() + "\n");

			} else if (cmd.equals("empty")) {

				if (list.isEmpty()) {
					bufferedWriter.write("1\n");
				} else {
					bufferedWriter.write("0\n");
				}

			} else if (cmd.equals("top")) {

				if (list.isEmpty()) {
					bufferedWriter.write("-1\n");
				} else {
					int top = list.get(list.size() - 1);
					bufferedWriter.write(top + "\n");
				}
			}

		}

		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();

	}
}
