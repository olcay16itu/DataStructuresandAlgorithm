import java.util.Iterator;
import java.util.Map;

public class encryptor {
	private Map<Character, Map<Character, Character>> map;
	private String key;
	private String keystream = "";
	private String plain_text;
	private String cipher_text = "";
	
	public encryptor(Map<Character, Map<Character, Character>> _map, String _key, String text) {
		map=_map;
		key=_key;
		plain_text=text;
	}
	
	public void encrypt() {
		// do not edit this method
		generate_keystream();
		generate_cipher_text();
	}
	
	private void generate_keystream() {
		// Check if the length of the plaintext is greater than the length of the key
		if (plain_text.length() > key.length()) {
			// If the plaintext is longer than the key, repeat the key to match the length of the plaintext
			for (int i = 0; i < plain_text.length(); i++) {
				keystream += (key.charAt(i % key.length()));
			}
		}
		// Check if the length of the plaintext is shorter than the length of the key
		else if (plain_text.length() < key.length()) {
			// If the plaintext is shorter than the key, truncate the key to match the length of the plaintext
			for (int i = 0; i < plain_text.length(); i++) {
				keystream += (key.charAt(i));
			}
		}
		// If the lengths of the plaintext and the key are equal
		else {
			// Use the key as the keystream
			keystream += key;
		}
	}
	
	private void generate_cipher_text() {
		// Iterate over the characters of the keystream
		for (int i = 0; i < keystream.length(); i++) {
			// Retrieve the mapping for the current plaintext character and keystream character,
			// and append the corresponding ciphertext character to the ciphertext string
			cipher_text += map.get(plain_text.charAt(i)).get(keystream.charAt(i));
		}
	}

	public String get_keystream() {
		return keystream;
	}
	
	public String get_cipher_text() {
		return cipher_text;
	}
}
