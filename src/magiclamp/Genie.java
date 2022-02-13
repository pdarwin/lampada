package magiclamp;

/**
 * Classe abstracta para génios de qualquer tipo
 * @author P. Perneta e J. Rocha
 *
 */
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
	 * Construtor do génio
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
	 * Função geral que pede ao génio que realize um desejo.
	 * Nunca pode permitir mais desejos que o limite definido
	 * @param aWish o desejo pedido, em String
	 * @return verdadeiro se o desejo foi concedido, senão falso
	 */
	public boolean grantWish (String aWish) {
		
		if (remWishes > 0) // Se ainda existirem desejos por realizar
		{ 
			// Aqui ficaria o código para realização do desejo, em caso de
			// desta funcionalidade
			
			remWishes-=1; // subtrai 1 desejo
			System.out.println("Desejo concedido! " + aWish + " foi realizado. " + 
					(remWishes==0 ? "Não lhe restam mais" : "Ainda lhe restam " + remWishes + 
					" de " + numWishes) + " desejos."); // mensagem informativa ao utilizador
			
			return true; //verdadeiro se realizado
		}
		return false; // falso se não realizado (não existem mais desejos)
	}
	
	
	/**
	 * Mostra o génio. Não faz nada, as subclasses definirão o que acontece aqui
	 */
	public void showMe() 
	{
		// NADA
	}
}
