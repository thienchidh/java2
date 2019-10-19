import java.util.HashMap;
import java.util.Map.Entry;

public class TestHashMap {
	HashMap<String, String> map = new HashMap<>();

	private void run() {

		map.put("One", "Một");
		map.put("Two", "Hai");

//		System.out.println(map);

		for (Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}

	public static void main(String[] args) {
		new TestHashMap().run();
	}

}
