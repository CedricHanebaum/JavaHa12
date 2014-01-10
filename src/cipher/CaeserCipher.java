package cipher;

public class CaeserCipher implements Verschluesselungsverfahren {

	@Override
	public String verschluessele(String source, Object key) {
		int caeserKey = this.isValid(source, key);
		String ret = "";

		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			if (c == 32) ret += " ";
			else {
				c += caeserKey;
				if (c > 90) c -= 26;
				ret += c;
			}
		}

		return ret;
	}

	@Override
	public String entschluessele(String source, Object key) {
		int caeserKey = this.isValid(source, key);
		String ret = "";

		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			if (c == 32) ret += " ";
			else {
				c -= caeserKey;
				if (c < 65) c += 26;
				ret += c;
			}
		}

		return ret;
	}

	@Override
	public String getName() {
		return "Caeser";
	}

	/**Prueft ob source und key gueltig sind. Formt den Schluessel fuer weitere Nutzung um.
	 * @param source zu verschluesselnder String.
	 * @param key Schluessel.
	 * @return umgeformter Schluessel.
	 */
	private int isValid(String source, Object key) {
		int caeserKey;
		for (int i = 0; i < source.length(); i++) {
			if (!((source.charAt(i) >= 65 && source.charAt(i) <= 90) || (source.charAt(i) == 32))) throw new EncryptionException("Nur Großbuchstaben sind erlaubt!");
		}
		try {
			caeserKey = Math.abs((int) key);
		} catch (ClassCastException e) {
			throw new EncryptionException("Falscher Schluessel");
		}

		if (caeserKey > 26) caeserKey -= 26 * (caeserKey / 26);
		return caeserKey;
	}
}
