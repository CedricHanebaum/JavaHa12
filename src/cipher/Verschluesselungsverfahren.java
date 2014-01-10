package cipher;

public interface Verschluesselungsverfahren {

	/**Verschluesselt einen String mit dem uebergebenen Schluessel.
	 * @param source zu verschluesselnder String.
	 * @param key Schluessel.
	 * @return verschluesselter String.
	 */
	public String verschluessele(String source, Object key);
	
	/**Entschluesselt einen String mit dem uebergebenen Schluessel.
	 * @param source zu entschluesselnder String.
	 * @param key Schluessel.
	 * @return entschluesselter String.
	 */
	public String entschluessele(String source, Object key);
	
	/**Gibt den Namen des Verschluesselungsverfahrens zurueck.
	 * @return der Name des Verschluesselungsverfahren.
	 */
	public String getName();
}
