package magiclamp;

/**
 * G�nio mau - s� concede um desejo
 */
public class BadGenie extends Genie {

	/**
	 * @param limit
	 *            n�mero de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie(int aLimitnumDesejos) {
		super(1);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (getGranted() == 1) ? "O g�nio mau realizou um desejo."
				: "O g�nio mau tem um desejo para realizar.";
	}
	
}
