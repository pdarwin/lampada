package magiclamp;

public abstract class Genie {

	/**
	 * N�mero m�ximo de desejos
	 */
	private int limit;

	/**
	 * N�mero de desejos realizados
	 */
	private int granted;

	/**
	 * @param laLimWishes n�mero m�ximo de desejos a conceder
	 */
	public Genie (int aLimit) {
		super();
		this.limit = aLimit;
	}

	/**
	 * Retorna o n�mero de desejos j� realizados
	 */	
	public int getGranted() {
		return granted;
	}
	
	/**
	 * Retorna o n�mero m�ximo de desejos
	 */	
	public int getLimit() {
		return limit;
	}

	/**
	 * @param aLimWishes define o n�mero m�ximo de desejos a conceder
	 */
	public void setLimit(int aLimit) {
		this.limit = aLimit;
	}

	/**
	 * Incrementar o contador de desejos
	 */
	public void incrementGranted() {
		granted++;
	}

	/**
	 * Pede ao g�nio que realize um desejo.
	 * Nunca pode poermitir mais desejos que o limite definido
	 * 
	 * @return verdadeiro se o desejo foi concedido, sen�o falso
	 */
	public boolean grantWish() {
		if (canGrantWish()) {
			incrementGranted();
			doGrantWish();
			return true;
		}
		return false;
	}


	/**
	 * Decide se o g�nio pode realizar o desejo
	 * 
	 * @return verdadeiro ou falso
	 */
	public boolean canGrantWish() {
		return granted < limit;
	}
	
	/**
	 * Realizar desejo. N�o faz nada, as subclasses definir�o o que acontece aqui
	 */
	public void doGrantWish() {
		// NADA
	}
	
}
