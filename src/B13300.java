import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B13300 {
	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String s = bufferedReader.readLine();
		String[] split = s.split(" ");
		int k = Integer.parseInt(split[1]);

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < Integer.parseInt(split[0]); i++) {
			String input = bufferedReader.readLine();
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		int answer = 0;
		for (String string : map.keySet()) {

			int each = map.get(string);
			answer += each / k;
			if (each % k != 0) {
				answer++;
			}
		}

		System.out.println(answer);

	}
}
