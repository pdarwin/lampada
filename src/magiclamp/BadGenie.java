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
		return (getGranted() == 1) ? "Eu sou o g�nio mau e realizei um desejo."
				: "Ol�! Eu sou o g�nio mau e posso realizar um desejo.";
	}
	
}
