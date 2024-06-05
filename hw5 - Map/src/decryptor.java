import java.util.Map;
import java.util.Iterator;

public class decryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text = "";
	private String cipher_text;
	
	public decryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map=_map;
		key=_key;
		cipher_text=text;
	}

	public void decrypt() {
		// do not edit this method
		generate_keystream();
		generate_plain_text();
	}
	
	private void generate_keystream() {
		// Check if the length of the ciphertext is greater than the length of the key
		if(cipher_text.length()>key.length()){
			for(int i =0;i<cipher_text.length();i++){
				// Append the characters of the key to the keystream, repeating the key if necessary
				keystream+=(key.charAt(i%key.length()));
			}
		}
		// Check if the length of the ciphertext is shorter than the length of the key
		else if(cipher_text.length()<key.length()){
			for(int i=0;i<cipher_text.length();i++){
				// Append the characters of the key to the keystream, truncating the key if necessary
				keystream+=(key.charAt(i));
			}
		}
		// If the lengths of the ciphertext and the key are equal
		else{
			// Use the key as the keystream
			keystream+=key;
		}
	}
	
	private void generate_plain_text() {
		// You must use map.get(x).keySet() with an iterator in this method
		// Initialize an iterator over the keys of the map
		Iterator<Character> setIterator = map.keySet().iterator();
		int a = 0; // Index for tracking the position in the keystream
		// Iterate over the keys of the map and the keystream simultaneously
		while (setIterator.hasNext() && a < keystream.length()) {
			char i = setIterator.next(); // Current character from the keys of the map
			// Check if the current character from the keys of the map matches the corresponding keystream character
			if (i == keystream.charAt(a)) {
				// Iterate over the characters associated with the current key in the map
				Iterator<Character> it = map.get(i).keySet().iterator();
				while (it.hasNext()) {
					char z = it.next(); // Current character from the associated characters in the map
					// Check if the character associated with the current key in the map matches the ciphertext character
					if (map.get(i).get(z) == cipher_text.charAt(a)) {
						plain_text += z; // Append the decrypted character to the plaintext
						// Reset the iterator over the keys of the map to iterate from the beginning
						setIterator = map.keySet().iterator();
						break; // Exit the inner loop
					}
				}
				a++; // Move to the next character in the keystream
			}
		}
	}


	public String get_keystream() {
		return keystream;
	}
	
	public String get_plain_text() {
		return plain_text;
	}
}
