import java.util.HashMap;

public class PalindromePermutation {
//	: Given a string, write a function to check if it is a permutation of a palindrome.
//	A palindrome is a word or phrase that is the same forwards and backwards. A permutation
//	is a rearrangement of letters. The palindrome does not need to be limited to just dictionary
//	words.

	public static void main(String[] args) {

		// Since it is not clear in the book if spaces are counted or no,
		// here I will be eliminating spaces from each string
		// also all characters are going to be lowercase letters.

		String s[] = { "tact coa", "civic", "ivicc", "civil", "livci" };
		for (int i = 0; i < s.length; i++) {
			palindromePermutation(s[i]);
		}
	}

	public static void palindromePermutation(String a) {
		a = a.toLowerCase();
		HashMap<Character, Integer> hm1 = new HashMap<>();

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != ' ') {
				if (hm1.containsKey(a.charAt(i))) {
					hm1.replace(a.charAt(i), hm1.get(a.charAt(i)) + 1);
				} else {
					hm1.put(a.charAt(i), 1);
				}
			}
		}

		int oddOccurencesOfLetters = 0;
		for (char c : hm1.keySet()) {
			if (hm1.get(c) % 2 == 1) {
				oddOccurencesOfLetters++;
			}
		}
		if (oddOccurencesOfLetters > 1) {
			System.out.println(a + " is not a palindrome permutation");
		} else {
			System.out.println(a + " is a palindrome permutation");
		}
	}

}
