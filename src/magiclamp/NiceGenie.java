package magiclamp;

/**
 * G�nio bom - concede todos os desejos
 */
public class NiceGenie extends Genie {

	/**
	 * @param aLimit - m�ximo n�mero de desejos a realizar
	 */

	public NiceGenie(int aLimit) {
		super(aLimit);
	}

	/**
	 * @return retorna o n�mero de desejos ainda dispon�veis.
	 */
	public int getRemainingWishes() {
		return getLimit() - getGranted();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eu sou o g�nio bom e j� concedi " + getGranted() + " desejos. Ainda tem "
				+ getRemainingWishes() + " desejos para pedir.";
	}

}
