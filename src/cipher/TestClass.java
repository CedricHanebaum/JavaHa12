package cipher;

public class TestClass {

	public static void main(String[] args) {
		CaeserCipher c = new CaeserCipher();
		VigenereCipher v = new VigenereCipher();
		String source1 = "JAVA HAUSAUFGABE";
		String source2 = "Java";
		Object keyC = 22;
		Object keyV = "AKEY";
		// Funktionierende Faelle
		verschluesseleTest(c, source1, keyC);
		verschluesseleTest(v, source1, keyV);
		verschluesseleTest(c, source1, keyV);
		verschluesseleTest(v, source2, keyV);
	}

	public static void verschluesseleTest(Verschluesselungsverfahren v, String source, Object key) {
		String s = "";
		try {
			s += v.getName() + ": " + source + "--> " + v.verschluessele(source, key);
			s += "--> " + v.entschluessele(v.verschluessele(source, key), key);
		} catch (EncryptionException ee) {
			s = ee.getMessage();
		}
		System.out.println(s);
	}

}
