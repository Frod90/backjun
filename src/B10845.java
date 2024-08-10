import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10845 {

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bufferedReader.readLine());
		int rear = 0;
		int front = 0;
		int[] queue = new int[10_000];

		for (int i = 0; i < n; i++) {

			String[] split = bufferedReader.readLine().split(" ");
			String cmd = split[0];

			if (cmd.equals("push")) {
				queue[rear++] = Integer.parseInt(split[1]);
			} else if (cmd.equals("pop")) {

				if (rear == front) {
					bufferedWriter.write("-1\n");
				} else {
					bufferedWriter.write(queue[front++] + "\n");
				}

			} else if (cmd.equals("size")) {
				bufferedWriter.write((rear - front) + "\n");

			} else if (cmd.equals("empty")) {

				if (rear == front) {
					bufferedWriter.write("1\n");
				} else {
					bufferedWriter.write("0\n");
				}

			} else if (cmd.equals("front")) {

				if (rear == front) {
					bufferedWriter.write("-1\n");
				} else {
					bufferedWriter.write(queue[front] + "\n");
				}

			} else if (cmd.equals("back")) {

				if (rear == front) {
					bufferedWriter.write("-1\n");
				} else {
					bufferedWriter.write(queue[rear - 1] + "\n");
				}
			}

		}

		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();

	}
}
