import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1697 {

	private static int n;
	private static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] split = bufferedReader.readLine().split(" ");

		n = Integer.parseInt(split[0]);
		k = Integer.parseInt(split[1]);

		List<Integer> eachRoute = new ArrayList<>();
		move(n, eachRoute);

		int min = 100_000;

		for (List<Integer> route : routes) {
			if (route.contains(k)) {
				min = Math.min(min, route.indexOf(k));
			}
		}

		for (List<Integer> route : routes) {
			if (route.get(route.size() - 1) == k) {
				System.out.println(route);
			}
		}

		System.out.println(min);

	}

	private static List<List<Integer>> routes = new ArrayList<>();

	public static void move(int node, List<Integer> eachRoute) {

		eachRoute.add(node);

		if (node < 0 || node >= 2 * k) {
			routes.add(eachRoute);
			return;
		}

		if (!eachRoute.contains(node + 1)) {
			move(node + 1, new ArrayList<>(eachRoute));
		}

		if (!eachRoute.contains(node - 1)) {
			move(node - 1, new ArrayList<>(eachRoute));
		}

		if (!eachRoute.contains(node * 2)) {
			move(node * 2, new ArrayList<>(eachRoute));
		}

	}

}
