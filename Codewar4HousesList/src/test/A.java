package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A {

	public static void main(String[] args) {
		// blue, gray, green, purple, black, red, pink, white, orange

		// gray, green, purple, blue, red, pink, black, white, orange

		// gray, red, pink, black, green, purple, blue, white, orange

		String[] houseColors = { "red", "blue", "green", "pink", "black", "orange", "gray", "white", "purple" };
		String[] houseConditions = { "purple is next to the right of green", "orange is next to the right of white",
				"red is next to the left of pink", "white is on the right of pink",
				"green is in beetween of red and white", "blue is in the middle of black and orange" };

		String[] housesList = new A().housesList(houseColors, houseConditions);

		System.out.println(Arrays.asList(housesList));

	}

	List<List<String>> allPermutations(String[] a) {

		List<List<String>> result = new LinkedList<>();

		List<String> base = Arrays.asList(a);
		Collections.sort(base);

		do {
			result.add(new ArrayList<>(base));
		} while (findNextPermutation(base));

		return result;
	}

	private boolean findNextPermutation(List<String> base) {
		if (base.isEmpty()) {
			return false;
		}

		int n = base.size();
		int last = n - 2;

		while (last >= 0) {
			if (base.get(last).compareTo(base.get(last + 1)) < 0) {// a < b
				break;
			}
			last--;
		}

		if (last < 0) {
			return false;
		}

		int nextGreater = n - 1;
		for (int i = n - 1; i > last; i--) {
			if (base.get(i).compareTo(base.get(last)) > 0) {
				nextGreater = i;
				break;
			}
		}

		swap(base, nextGreater, last);
		for (int i = last + 1, j = n - 1; i < j; i++, j--) {
			swap(base, i, j);
		}

		return true;
	}

	String[] housesList(String[] houseColors, String[] houseConditions) {
		if (houseConditions.length == 0) {
			Arrays.sort(houseColors);
			return houseColors;
		}

		List<List<String>> permutations = allPermutations(houseColors);

		for (List<String> list : permutations) {
			Map<String, Integer> mapIndex = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				String e = list.get(i);
				mapIndex.put(e, i);

			}

			if (isAllOK(mapIndex, list, houseConditions)) {
				String[] result = new String[list.size()];
				list.toArray(result);
				return result;
			}

		}
		return new String[0];
	}

	final String idx[] = { "is next to the right of", "is on the right of", "is next to the left of",
			"is on the left of", "is in the middle of", "is in beetween of" };

	private boolean isAllOK(Map<String, Integer> mapIndex, List<String> list, String[] houseConditions) {

//		String xxx[] = { "black", "gray", "red", "pink", "blue", "green", "purple", "white", "orange" };
//
//		boolean bx = true;
//		for (int i = 0; i < list.size(); i++) {
//			if (!xxx[i].equals(list.get(i))) {
//				bx = false;
//			}
//		}
//		if (!bx) {
//			return false;
//		}
//
//		System.out.println(list);

		for (String condition : houseConditions) {
//			System.out.println(condition);
//
			if (condition.contains(idx[0])) {
				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);

				// i2 i1
				if (i2.intValue() + 1 != i1.intValue()) {
					return false;
				}

			} else if (condition.contains(idx[1])) {
				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);
				// i2 ... i1
				if (i2.intValue() >= i1.intValue()) {
					return false;
				}

			} else if (condition.contains(idx[2])) {
				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);

				// i1 i2
				if (i1.intValue() + 1 != i2.intValue()) {
					return false;
				}

			} else if (condition.contains(idx[3])) {

				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);

				// i1 ... i2
				if (i1.intValue() >= i2.intValue()) {
					return false;
				}

			} else if (condition.contains(idx[4])) {
				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 3];
				String c = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);
				Integer i3 = mapIndex.get(c);

				// i2 |i1| i3
				// i3 |i1| i2

				int _min = Math.min(i2, i3);
				int _max = Math.max(i2, i3);

				if (i1.intValue() <= _min || i1.intValue() >= _max) {
					return false;
				}

//				System.out.println(_min + "--" + _max);
				if ((_max - _min + 1) % 2 == 0) {
					return false;
				}
//				System.out.println("A.isAllOK()");

				if (i1.intValue() - _min != _max - i1.intValue()) {
					return false;
				}

			} else if (condition.contains(idx[5])) {
				String[] split = condition.split(" ");
				String a = split[0];
				String b = split[split.length - 3];
				String c = split[split.length - 1];

				Integer i1 = mapIndex.get(a);
				Integer i2 = mapIndex.get(b);
				Integer i3 = mapIndex.get(c);

				int _min = Math.min(i2, i3);
				int _max = Math.max(i2, i3);

				if (i1.intValue() <= _min || i1.intValue() >= _max) {
					return false;
				}

			}
		}

		return true;
	}

	void swap(List<String> a, int i, int j) {
		String tmp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, tmp);
	}
}
