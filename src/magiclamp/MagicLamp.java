package magiclamp;

/**
 * Lâmpada mágica
 */
public class MagicLamp {

	/** Número máximo de desejos */
	private int limit;


	/** Número total de esfregadelas. */
	private int totalRubs;

	/** Número de esfregadelas desde o último carregamento. */
	private int rubs;

	/** Número de recargas. */
	private int demons;

	/**
	 * @param limit
	 *            Quantos génios podem sair da lâmpada.
	 */
	public MagicLamp(int aLimit) {
		limit = aLimit;
	}

	/**
	 * @return número máximo de génios.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @return quantas vezes foi esfregada desde a última recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * @param aRubs define o número de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	
	/**
	 * @return número total de esfregadelas.
	 */
	public int getTotalRubs() {
		return totalRubs;
	}

	/**
	 * @return número de génios disponíveis.
	 */
	public int getGenies() {
		return getLimit() - getRubs();
	}

	/**
	 * @return número de demónios.
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * Método para esfregar a lâmpada
	 * Esfregamos a lâmpada mágica para obter um génio. Sé o número for par sem contar a vez atual, retorna um génio mau;
	 * Se o número for maior que o limite, a lâmpada cria um pequeno demónio;
	 * Em todas as outras situações, retorna um génio normal.
	 * 
	 * @param limit
	 *            máximo número de desejos que o génio pode realizar
	 * 
	 * @return um génio ou demónio.
	 */
	public Genie rub(int aLimit) {
		if (rubs < limit) {
			rubs++;
			totalRubs++;
			if (totalRubs % 2 == 0)
				return new NiceGenie(aLimit);
			return new BadGenie(aLimit);
		}
		return new Demon(aLimit);
	}

	/**
	 * Recarrega a lâmpada mágica colocando nela um demónio.
	 * Um demónio pode ser usado somente se ainda não foi reciclado
	 * 
	 * @param demon
	 *            o demónio reciclável.
	 */
	public void rechargeLamp(Demon demon) {
		if (!demon.recycled()) {
			demon.recycle();
			rubs = 0;
			demons++;
		}
	}
	
}
