package magiclamp;

/**
 * Dem�nio recicl�vel
 */
public class Demon extends Genie {

	/*
	 * Verdadeiro se foi reciclado, sen�o falso 
	 */
	private boolean recycled = false;
	
	/**
	 * @param aLimit
	 *            n�mero de desejos a realizar (ignorado, independente do limite)
	 */
	public Demon (int aLimit) {
		super(aLimit);

	}
	
	/**
	 * O dem�nio recicl�vel concede todos os desejos que lhe forem colocados, exceto quando foi reciclado.
	 * 
	 * @return verdadeiro quando n�o foi ainda reciclado, sen�o falso
	 */
	@Override
	public boolean canGrantWish() {
		return !recycled;
	}

	/**
	 * @return estado de reciclagem do dem�nio
	 */
	public boolean recycled() {
		return recycled;
	}

	/**
	 * Recicla o dem�nio - chamada pela l�mpada m�gica
	 */
	public void recycle() {
		recycled = true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return recycled ? "O dem�nio foi reciclado." : "O dem�nio recicl�vel concedeu "
				+ getGranted() + " desejos.";
	}

}
