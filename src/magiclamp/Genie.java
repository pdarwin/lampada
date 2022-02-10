package magiclamp;

public abstract class Genie {

	/**
	 * Número de desejos pedidos
	 */
	protected int numWishes;

	/**
	 * Número de desejos ainda não realizados
	 */
	protected int remWishes;

	/**
	 * @param laLimWishes número máximo de desejos a conceder
	 */
	public Genie () {
		super();
	}

	/**
	 * @return retorna o número de desejos pedidos
	 */
	public int getNumWishes() {
		return numWishes;
	}

	/**
	 * @return retorna o número de desejos ainda disponíveis
	 */
	public int getRemWishes() {
		return remWishes;
	}


	/**
	 * Pede ao génio que realize um desejo.
	 * Nunca pode permitir mais desejos que o limite definido
	 * 
	 * @return verdadeiro se o desejo foi concedido, senão falso
	 */
	public boolean grantWish (String aWish) {
		
		
		if (remWishes > 0) {
			remWishes-=1;
			System.out.println("Desejo concedido! " + aWish + " foi realizado. " + (remWishes==0 ? "Não lhe restam mais" : "Ainda lhe restam " + remWishes + " de " + numWishes) + " desejos.");
			return true;
		}
		return false;
	}
	
	
	/**
	 * Mostra o génio. Não faz nada, as subclasses definirão o que acontece aqui
	 */
	public void showMe() {
		// NADA
	}
}
