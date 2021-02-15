
public class OneAway {

//	There are three types of edits that can be performed on strings: insert a character,
//	remove a character, or replace a character. Given two strings, write a function to 
//	check if they are one edit (or zero edits) away.

	public static void main(String[] args) {

		String s[] = { "pale", "ple", "bale", "pales" };
		for (String st1 : s) {
			for (String st2 : s) {
				oneAway(st1, st2);
			}
		}

	}

	private static void oneAway(String a, String b) {
		if (a.equals(b)) {
			System.out.println(a + " & " + b + ": true");
			return;
		}
		if (Math.abs(a.length() - b.length()) > 1) {
			System.out.println(a + " & " + b + ": false");
			return;
		}

		String s1 = (a.length() >= b.length()) ? a : b;
		String s2 = (a.length() >= b.length()) ? b : a;

		int i1 = 0, i2 = 0;

		boolean oneDifference = false;
		while (i1 < s1.length() && i2 < s2.length()) {

			if (s1.charAt(i1) == s2.charAt(i2)) {
				// if the two characters are equal move both cursor by 1
				i1++;
				i2++;
			} else {
				// if this is not the first time we find a difference,
				// then one of the strings is not one edit away from the other
				if (oneDifference) {
					System.out.println(a + " & " + b + ": false");
					return;
				}
				oneDifference = true;

				// if both strings are of equal length then the only way to have a true answer
				// is to replace the current s1.charAt(i1) by s2.charAt(i2) or vice versa
				if (s1.length() == s2.length()) {
					i1++;
					i2++;

				} else
					i1++;
			}
		}
		// if we are here then one string is one edit away from the other one.
		System.out.println(a + " & " + b + ": true");

	}
}
