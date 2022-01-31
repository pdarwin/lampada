package magiclamp;

/**
 * Demónio reciclável
 */
public class Demon extends Genie {

	/*
	 * Verdadeiro se foi reciclado, senão falso 
	 */
	private boolean recycled = false;
	
	/**
	 * @param aLimit
	 *            número de desejos a realizar (ignorado, independente do limite)
	 */
	public Demon (int aLimit) {
		super(aLimit);

	}
	
	/**
	 * O demónio reciclável concede todos os desejos que lhe forem colocados, exceto quando foi reciclado.
	 * 
	 * @return verdadeiro quando não foi ainda reciclado, senão falso
	 */
	@Override
	public boolean canGrantWish() {
		return !recycled;
	}

	/**
	 * @return estado de reciclagem do demónio
	 */
	public boolean recycled() {
		return recycled;
	}

	/**
	 * Recicla o demónio - chamada pela lâmpada mágica
	 */
	public void recycle() {
		recycled = true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return recycled ? "O demónio foi reciclado." : "O demónio reciclável concedeu "
				+ getGranted() + " desejos.";
	}

}
