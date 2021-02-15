public class StringCompression {
//	 Implement a method to perform basic string compression using the counts
//	 of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
//	 "compressed" string would not become smaller than the original string, your method should return
//	 the original string. You can assume the string has only uppercase and lowercase letters (a - z).

	public static void main(String[] args) {

		String strings[] = { "aabcccccaaa", "abc", "aabbcc", "aaaabc", "aaaaabc", "a", };

		for (String s : strings) {
			compressString(s);
		}
	}

	private static void compressString(String s) {
		String res = "";
		if (s.length() == 1) {
			res += s.charAt(0) + "1";
			System.out.println(s + ": the compressed string is not smaller than the original one " + res
					+ " -> length = " + res.length());
			return;
		}

		int count = 1;
		int i = 0;
		for (i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i + 1) == s.charAt(i)) {
				count++;
			} else {
				res += s.charAt(i);
				res += count;
				count = 1;
			}
		}
		if (count != 1) {
			if (s.charAt(s.length() - 1) == s.charAt(i)) {
				res += s.charAt(i);
				res += count;
				count = 1;
			}
		} else if (count == 1) {
			res += s.charAt(i);
			res += count;
			count = 1;
		}
		if (res.length() >= s.length()) {
			System.out.println(s + ": the compressed string is not smaller than the original one " + res
					+ " -> length = " + res.length());
		} else {
			System.out.println(s + ": the compressed string is " + res);
		}

	}
}
