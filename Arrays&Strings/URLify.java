
public class URLify {
//	Write a method to replace all spaces in a string with '%20'. You may assume that the string
//	has sufficient space at the end to hold the additional characters, and that you are given the "true"
//	length of the string. (Note: If implementing in Java, please use a character array so that you can
//	perform this operation in place.) 

	public static void main(String[] args) {
		String input = "Mr John Smith";
		int n = input.length();
		
		
		urlify(input, n);
	}

	public static void urlify(String s, int trueLength) {
		// We will count the spaces, then create a new char array with the size of 
		// (trueLength+spacesCount*2) we multiplied it by 2 since we are adding for 
		// each space occurence 2 additional characters in the array. then we populate the array
		
		int spacesCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (s.charAt(i) == ' ')
				spacesCount++;
		}

		int newArrayLength = trueLength + spacesCount * 2;
		char c[] = new char[newArrayLength];
		int i = 0, j = 0;
		for (i = 0, j = 0; i < s.length() && j < newArrayLength; j++, i++) {
			if (s.charAt(i) != ' ') {
				c[j] = s.charAt(i);
			} else {
				c[j] = '%';
				c[j + 1] = '2';
				c[j + 2] = '0';
				j += 2;
			}
		}
		System.out.println(String.valueOf(c));
	}
}
