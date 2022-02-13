package magiclamp;

/**
 * Classe abstracta para g�nios de qualquer tipo
 * @author P. Perneta e J. Rocha
 *
 */
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
	 * Construtor do g�nio
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
	 * Fun��o geral que pede ao g�nio que realize um desejo.
	 * Nunca pode permitir mais desejos que o limite definido
	 * @param aWish o desejo pedido, em String
	 * @return verdadeiro se o desejo foi concedido, sen�o falso
	 */
	public boolean grantWish (String aWish) {
		
		if (remWishes > 0) // Se ainda existirem desejos por realizar
		{ 
			// Aqui ficaria o c�digo para realiza��o do desejo, em caso de
			// desta funcionalidade
			
			remWishes-=1; // subtrai 1 desejo
			System.out.println("Desejo concedido! " + aWish + " foi realizado. " + 
					(remWishes==0 ? "N�o lhe restam mais" : "Ainda lhe restam " + remWishes + 
					" de " + numWishes) + " desejos."); // mensagem informativa ao utilizador
			
			return true; //verdadeiro se realizado
		}
		return false; // falso se n�o realizado (n�o existem mais desejos)
	}
	
	
	/**
	 * Mostra o g�nio. N�o faz nada, as subclasses definir�o o que acontece aqui
	 */
	public void showMe() 
	{
		// NADA
	}
}
