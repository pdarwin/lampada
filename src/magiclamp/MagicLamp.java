package magiclamp;

/**
 * L�mpada m�gica
 */
public class MagicLamp {

	/** N�mero m�ximo de desejos */
	private int limit;


	/** N�mero total de esfregadelas. */
	private int totalRubs;

	/** N�mero de esfregadelas desde o �ltimo carregamento. */
	private int rubs;

	/** N�mero de recargas. */
	private int demons;

	/**
	 * @param limit
	 *            Quantos g�nios podem sair da l�mpada.
	 */
	public MagicLamp(int aLimit) {
		limit = aLimit;
	}

	/**
	 * @return n�mero m�ximo de g�nios.
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @return quantas vezes foi esfregada desde a �ltima recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * @param aRubs define o n�mero de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	
	/**
	 * @return n�mero total de esfregadelas.
	 */
	public int getTotalRubs() {
		return totalRubs;
	}

	/**
	 * @return n�mero de g�nios dispon�veis.
	 */
	public int getGenies() {
		return getLimit() - getRubs();
	}

	/**
	 * @return n�mero de dem�nios.
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * M�todo para esfregar a l�mpada
	 * Esfregamos a l�mpada m�gica para obter um g�nio. S� o n�mero for par sem contar a vez atual, retorna um g�nio mau;
	 * Se o n�mero for maior que o limite, a l�mpada cria um pequeno dem�nio;
	 * Em todas as outras situa��es, retorna um g�nio normal.
	 * 
	 * @param limit
	 *            m�ximo n�mero de desejos que o g�nio pode realizar
	 * 
	 * @return um g�nio ou dem�nio.
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
	 * Recarrega a l�mpada m�gica colocando nela um dem�nio.
	 * Um dem�nio pode ser usado somente se ainda n�o foi reciclado
	 * 
	 * @param demon
	 *            o dem�nio recicl�vel.
	 */
	public void rechargeLamp(Demon demon) {
		if (!demon.recycled()) {
			demon.recycle();
			rubs = 0;
			demons++;
		}
	}
	
}
