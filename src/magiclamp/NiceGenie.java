package magiclamp;

/**
 * Génio bom - concede todos os desejos
 */
public class NiceGenie extends Genie {

	/**
	 * @param aLimit - máximo número de desejos a realizar
	 */

	public NiceGenie(int aLimit) {
		super(aLimit);
	}

	/**
	 * @return retorna o número de desejos ainda disponíveis.
	 */
	public int getRemainingWishes() {
		return getLimit() - getGranted();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eu sou o génio bom e já concedi " + getGranted() + " desejos. Ainda tem "
				+ getRemainingWishes() + " desejos para pedir.";
	}

}
