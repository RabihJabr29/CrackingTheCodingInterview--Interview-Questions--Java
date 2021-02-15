import java.util.HashSet;

public class IsUnique {
//	Implement an algorithm to determine if a string has all unique characters. What if you
//	cannot use additional data structures? 
	public static void main(String[] args) {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strings[] = { "abcdef", "abccdef", "a", "abc"};

		// basic approach will have a time complexity of O(n)
		System.out.println("Using basic approach");
		for (int i = 0; i < strings.length; i++) {
			isUniqueBasic(strings[i]);
		}
		
		// advanced approach - using datastructures
		System.out.println("\nUsing Advanced approach");
		for (int i = 0; i < strings.length; i++) {
			isUniqueAdvanced1(strings[i]);
		}
	}

	public static void isUniqueBasic(String str) {
		// Assuming strings are made only of characters from a to z and all characters
		// are lowercase letters
		if (str.length() > 26) {
			System.out.println(str + ": String is not Unique.");
			return;
		}
		int chars[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if (chars[str.charAt(i) - 97] > 0) {
				System.out.println(str + ": String is not Unique.");
				return;
			}
			chars[str.charAt(i) - 97]++;
		}
		System.out.println(str + ": String is Unique.");

	}

	public static void isUniqueAdvanced1(String str) {
		HashSet<Character> set = new HashSet<>();
		boolean isUnique = true;
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i))) {
				isUnique = false;
				break;
			}
			set.add(str.charAt(i));
		}
		if (isUnique) {
			System.out.println(str + ": String is Unique.");
		} else {
			System.out.println(str + ": String is not Unique.");
		}
		
	}

}
