package magiclamp;

public abstract class Genie {

	/**
	 * Número máximo de desejos
	 */
	private int limit;

	/**
	 * Número de desejos realizados
	 */
	private int granted;

	/**
	 * @param laLimWishes número máximo de desejos a conceder
	 */
	public Genie (int aLimit) {
		super();
		this.limit = aLimit;
	}

	/**
	 * Retorna o número de desejos já realizados
	 */	
	public int getGranted() {
		return granted;
	}
	
	/**
	 * Retorna o número máximo de desejos
	 */	
	public int getLimit() {
		return limit;
	}

	/**
	 * @param aLimWishes define o número máximo de desejos a conceder
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
	 * Pede ao génio que realize um desejo.
	 * Nunca pode poermitir mais desejos que o limite definido
	 * 
	 * @return verdadeiro se o desejo foi concedido, senão falso
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
	 * Decide se o génio pode realizar o desejo
	 * 
	 * @return verdadeiro ou falso
	 */
	public boolean canGrantWish() {
		return granted < limit;
	}
	
	/**
	 * Realizar desejo. Não faz nada, as subclasses definirão o que acontece aqui
	 */
	public void doGrantWish() {
		// NADA
	}
	
}
