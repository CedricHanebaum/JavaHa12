package cipher;

public class VigenereCipher implements Verschluesselungsverfahren {

	@Override
	public String verschluessele(String source, Object key) {
		String veginereKey = "";
		String ret = "";
		CaeserCipher cc = new CaeserCipher();
		
		try{
			veginereKey = (String) key;
		} catch (ClassCastException e){
			throw new EncryptionException("Falscher Schluessel!");
		}
		for(int i = 0; i < veginereKey.length(); i++){
			if(!((veginereKey.charAt(i) >= 65 && veginereKey.charAt(i) <= 90))) throw new EncryptionException("Nur Großbuchstaben als schluessel erlaubt!");
		}
		
		for(int i = 0; i < source.length(); i++){
			char c = source.charAt(i);
			if(c == 32) ret += " ";
			else {
				int ceaserKey = (int) veginereKey.charAt(i % veginereKey.length());
				ret += cc.verschluessele(source.charAt(i) + "", ceaserKey - 65);
			}
		}
		
		return ret;
	}

	@Override
	public String entschluessele(String source, Object key) {
		String veginereKey = "";
		String ret = "";
		CaeserCipher cc = new CaeserCipher();
		
		try{
			veginereKey = (String) key;
		} catch (ClassCastException e){
			throw new EncryptionException("Falscher Schluessel!");
		}
		for(int i = 0; i < veginereKey.length(); i++){
			if(!((veginereKey.charAt(i) >= 65 && veginereKey.charAt(i) <= 90))) throw new EncryptionException("Nur Großbuchstaben als schluessel erlaubt!");
		}
		
		for(int i = 0; i < source.length(); i++){
			char c = source.charAt(i);
			if(c == 32) ret += " ";
			else {
				int ceaserKey = (int) veginereKey.charAt(i % veginereKey.length());
				ret += cc.entschluessele(source.charAt(i) + "", ceaserKey - 65);
			}
		}
		
		return ret;
	}

	@Override
	public String getName() {
		return "Vigenere";
	}

}
