package magiclamp;

import java.util.Scanner;

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
	public Demon (int aNumWishes) {
		super();
	}
	
	/**
	 * O dem�nio recicl�vel concede todos os desejos que lhe forem colocados, exceto quando foi reciclado.
	 * 
	 * @return verdadeiro quando n�o foi ainda reciclado, sen�o falso
	 */
	/*
	 * @Override public boolean canGrantWish() { return !recycled; }
	 */

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
		System.out.println("Dem�nio consumido. L�mpada em reciclagem...");
		recycled = true;
	}

	/**
	 * Pede ao dem�nio que realize um desejo, e pergunta se quer realizar outro
	 * 
	 * @return verdadeiro se continua a realizar, sen�o falso
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
	 * Mostra o g�nio.
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
		System.out.println("@@@   Eu sou o dem�nio recicl�vel, e posso realizar todos os seus desejos!  @@@@");
	}

}
