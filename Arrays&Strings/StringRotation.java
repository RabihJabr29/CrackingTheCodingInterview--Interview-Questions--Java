
public class StringRotation {

//	Assume you have a method isSubstring which checks if one word is a substring
//	of another. Given two strings, s1 and s2, write code to check if s2 is a
//	rotation of s1 using only one call to isSubstring 
//	(e.g., "waterbottle" is a rotation of"erbottlewat").
//  and "mainacode" is not a rotation of "codemania" 
	
	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "erbottlewat";

		if (isSubstring(s1, s2)) {
			System.out.println(s2 + " is a rotation of " + s1);
		} else {
			System.out.println(s2 + " is not a rotation of " + s1);
		}
	}

	private static boolean isSubstring(String s1, String s2) {
		// we can notice that if we make a string s of adding two copies of s2,
		// s1 will be a substring of this string s. then if s contains s1, then
		// s2 is a rotation of s1.
		if (s1.length() != s2.length()) {
			return false;
		}

		String s = s2 + s2;

		if (s.indexOf(s1) > 0) {
			return true;
		}
		return false;
	}
}
