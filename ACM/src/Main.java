import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		String startWord;
		n = Integer.parseInt(sc.next());
		startWord = sc.next();
		String s[] = new String[n];
		for (int i = 0; i < n; ++i) {
			s[i] = sc.next();
		}
		System.out.println(new Main().longestWordChain(s, startWord));
		sc.close();
	}

	List<String[]> vec = new LinkedList<>();

	void gen(String[] s, String startWord) {
		Arrays.sort(s);

		permute(s, 0, s.length - 1, startWord);
	}

	List<String> handle(String[] a) {
		List<String> rs = new LinkedList<>();
		rs.add(a[0]);

		for (int i = 1; i < a.length; ++i) {
			String u = a[i - 1];
			int n = u.length();

			String v = a[i];

			if (u.charAt(n - 1) == v.charAt(0)) {
				rs.add(v);
			} else {
				break;
			}
		}

		return rs;
	}

	String longestWordChain(String[] keywords, String startWord) {
		List<String> s = new LinkedList<>();
		for (String e : keywords) {
			s.add(e);
		}

		int n = s.size();
		for (int i = 0; i < n; ++i) {
			if (s.get(i).equals(startWord)) {
				s.remove(i);
				break;
			}
		}
		String t[] = new String[s.size()];
		s.toArray(t);

		gen(t, startWord);

		List<String> ans = new LinkedList<>();

		for (String[] e : vec) {
			List<String> x = handle(e);
			if (x.size() > ans.size()) {
				ans = x;
			}
		}

		String result = "";
		for (int i = 0; i < ans.size(); ++i) {
			if (i == ans.size() - 1) {
				result = result + ans.get(i);
			} else {
				result = result + ans.get(i) + "-";
			}
		}
		return result;
	}

	void permute(String[] a, int l, int r, String startWord) {
		if (l == r) {
			save(a, startWord);
		} else {
			for (int i = l; i <= r; ++i) {
				swap(a, l, i);
				permute(a, l + 1, r, startWord);
				swap(a, l, i);
			}
		}
	}

	void save(String[] s, String startWord) {
		String[] x = new String[s.length + 1];
		int i = 0;
		x[i++] = startWord;

		for (String e : s) {
			x[i++] = e;
		}
		vec.add(x);
	}

	private void swap(String a[], int l, int i) {
		String tmp = a[l];
		a[l] = a[i];
		a[i] = tmp;
	}
}
