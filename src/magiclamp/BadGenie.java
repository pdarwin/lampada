package magiclamp;

/**
 * Génio mau - só concede um desejo
 */
public class BadGenie extends Genie {

	/**
	 * @param limit
	 *            número de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie(int aLimitnumDesejos) {
		super(1);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (getGranted() == 1) ? "O génio mau realizou um desejo."
				: "O génio mau tem um desejo para realizar.";
	}
	
}
