public class preprocessor {
	private String initial_string;
	private String preprocessed_string;
		
	public preprocessor(String str) {
		initial_string=str;
	}

	public void preprocess() {
		// do not edit this method
		capitalize();
		clean();
	}
	
	private void capitalize() {
		preprocessed_string=initial_string.toUpperCase();
	}

	private void clean() {
		// Create a StringBuffer to store the preprocessed string
		StringBuffer sb = new StringBuffer();

		// Iterate over each character of the input string for preprocessing
		for (int i = 0; i < preprocessed_string.length(); ++i) {
			// Check if the current character is an uppercase letter (ASCII range: 65-90) or a lowercase letter (ASCII range: 97-122)
			if ((preprocessed_string.charAt(i) < 91 && preprocessed_string.charAt(i) > 64) || // Uppercase letters (A-Z)
					(preprocessed_string.charAt(i) < 123 && preprocessed_string.charAt(i) > 96)) { // Lowercase letters (a-z)
				// If the character is a letter, append it to the StringBuffer
				sb.append(preprocessed_string.charAt(i));
			}
			// ASCII characters outside the range of letters (e.g., punctuation, digits, etc.) are excluded
			// do not need continue
		}
		// Update the preprocessed string with the contents of the StringBuffer
		preprocessed_string = sb.toString();
	}

	
	public String get_preprocessed_string() {
		return preprocessed_string;
	}
}