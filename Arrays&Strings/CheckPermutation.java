import java.util.Arrays;
import java.util.HashMap;

public class CheckPermutation {
//	Given two strings, write a method to decide if one is a permutation of the
//	other. 
	public static void main(String[] args) {

		String s1 = "abcd";
		String s2 = "abdc";
		String s3 = "abcde";

		// this basic approach will have a time complexity of O(nlogn) where n is the
		System.out.println("Using the Basic approach:");
		checkPermutationBasic(s1, s2);
		checkPermutationBasic(s1, s3);

		// this advanced approach will have a time complexity of O(n)
		System.out.println("\nUsing the Advanced approach:");
		checkPermutationAdvanced(s1, s2);
		checkPermutationAdvanced(s1, s3);

	}

	public static void checkPermutationBasic(String a, String b) {

		// We will sort the two strings and check if they are equal -> true -> anagram
		// not true -> not anagrams
		if (a.length() != b.length()) {
			System.out.println("The two strings '" + a + " & " + b + "' are not anagrams");
			return;
		}
		char c1[] = a.toCharArray();
		char c2[] = b.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);
		if (String.valueOf(c1).equals(String.valueOf(c2))) {
			System.out.println("The two strings '" + a + " & " + b + "' are anagrams");
		} else {
			System.out.println("The two strings '" + a + " & " + b + "' are not anagrams");
		}
	}

	public static void checkPermutationAdvanced(String a, String b) {

		// We will use two hashmaps to store the the characters and their counts, then
		// we will see if the two are equal

		if (a.length() != b.length()) {
			System.out.println("The two strings '" + a + " & " + b + "' are not anagrams");
			return;
		}

		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {
			if (hm1.containsKey(a.charAt(i))) {
				hm1.replace(a.charAt(i), hm1.get(a.charAt(i)) + 1);
			} else {
				hm1.put(a.charAt(i), 1);
			}
			if (hm2.containsKey(b.charAt(i))) {
				hm2.replace(b.charAt(i), hm2.get(b.charAt(i)) + 1);
			} else {
				hm2.put(b.charAt(i), 1);
			}
		}

		if (hm1.equals(hm2)) {
			System.out.println("The two strings '" + a + " & " + b + "' are anagrams");
		} else {
			System.out.println("The two strings '" + a + " & " + b + "' are not anagrams");
		}

	}
}
