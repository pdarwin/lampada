package magiclamp;

import java.util.Scanner;

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
	public Demon (int aNumWishes) {
		super();
	}
	
	/**
	 * O demónio reciclável concede todos os desejos que lhe forem colocados, exceto quando foi reciclado.
	 * 
	 * @return verdadeiro quando não foi ainda reciclado, senão falso
	 */
	/*
	 * @Override public boolean canGrantWish() { return !recycled; }
	 */

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
		System.out.println("Demónio consumido. Lâmpada em reciclagem...");
		recycled = true;
	}

	/**
	 * Pede ao demónio que realize um desejo, e pergunta se quer realizar outro
	 * 
	 * @return verdadeiro se continua a realizar, senão falso
	 */
	public boolean grantWish (String aWish, Scanner sc) {
		System.out.println("Desejo concedido! " + aWish + " foi realizado. Escolha outro desejo, ou \"n\" para sair.");
		String resposta = sc.nextLine();
		if (!resposta.equals("n"))
			{
			//sc.nextLine(); // Limpar scanner
			this.grantWish(resposta, sc);
			return true;
			}
		else return false;

	}
	
	/**
	 * Mostra o génio.
	 */
	public void showMe ()
	{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@ (@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ *@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@(. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/  @@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@, & @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@, % &@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@& #@  @@@@@@@%   *%@&&&&&@(.   &@@@@@@@  %. @@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@# #%@  &  (#*******************&. .( .@%, @@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@  #  &***************************/  %  @@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@( .*,*****************************,%  @@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@  /,  ,,,***********************,,, .,#  @@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@% .*,,. &&  ,,*****************,,  @. ,,*/  @@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@&  **,,,  @@@@%  ,***********,  @@@@@  ,,**/  @@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@  ****,,, .@@@@@@@( .*****  &@@@@@@@  ,,,**** ,@@@@@@@@@@@@@@@  /@@@@");
		System.out.println("@@@@@@@@@@@  *****,,,. /@@@@@.   ***   (@@@@@  ,,,******  @@@@@@@  ,,,,, *** @@@");
		System.out.println("@@@@@@@@@@@  *********,,,,*.  ********,  .,,,,**********  @@@@@ * ,@@@@.,,,.  (@");
		System.out.println("@@@@@@@@@@@  ******************************************, .@@@@ * &@@@@(%@@@@@@@@");
		System.out.println("@@@@@@@@@@@* .*****************************************  @@@@,,,.@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@  ,***************************************  &@@@@ * @@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@. .,***********************************,  @@@@@ *,.@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@  ,********************************,. /@@@@@ *, @@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@  ,,***************************,  .,**,,**, &@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@&  .,,*******************,,. .@@@@(.  *@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@&   ,,,,,,,,,,,,,,,  *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@   Eu sou o demónio reciclável, e posso realizar todos os seus desejos!  @@@@");
	}

}
