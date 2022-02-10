package magiclamp;

public abstract class Genie {

	/**
	 * N�mero de desejos pedidos
	 */
	protected int numWishes;

	/**
	 * N�mero de desejos ainda n�o realizados
	 */
	protected int remWishes;

	/**
	 * @param laLimWishes n�mero m�ximo de desejos a conceder
	 */
	public Genie () {
		super();
	}

	/**
	 * @return retorna o n�mero de desejos pedidos
	 */
	public int getNumWishes() {
		return numWishes;
	}

	/**
	 * @return retorna o n�mero de desejos ainda dispon�veis
	 */
	public int getRemWishes() {
		return remWishes;
	}


	/**
	 * Pede ao g�nio que realize um desejo.
	 * Nunca pode permitir mais desejos que o limite definido
	 * 
	 * @return verdadeiro se o desejo foi concedido, sen�o falso
	 */
	public boolean grantWish (String aWish) {
		
		
		if (remWishes > 0) {
			remWishes-=1;
			System.out.println("Desejo concedido! " + aWish + " foi realizado. " + (remWishes==0 ? "N�o lhe restam mais" : "Ainda lhe restam " + remWishes + " de " + numWishes) + " desejos.");
			return true;
		}
		return false;
	}
	
	
	/**
	 * Mostra o g�nio. N�o faz nada, as subclasses definir�o o que acontece aqui
	 */
	public void showMe() {
		// NADA
	}
}
