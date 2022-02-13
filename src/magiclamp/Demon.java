package magiclamp;

import java.util.Scanner;

/**
 * Dem�nio recicl�vel
 * @author P. Perneta e J. Rocha
 * 
 */
public class Demon extends Genie {

	/*
	 * Verdadeiro se foi reciclado, sen�o falso 
	 */
	private boolean recycled = false;
	
	/**
	 * Construtor do dem�nio
	 * 
	 * @param aLimit
	 *            n�mero de desejos a realizar (ignorado, independente do limite
	 *            mas passa na mesma para o caso de alguma funcionalidade futura)
	 */
	public Demon (int aNumWishes) {
		super();
	}
	

	/**
	 * Retorna o estado do dem�nio
	 * 
	 * @return 
	 * 		verdadeiro se reciclado, sen�o falso
	 */
	public boolean isRecycled() {
		return recycled;
	}

	/**
	 * Recicla o dem�nio - fun��o chamada pela l�mpada m�gica
	 */
	public void recycle() {
		System.out.println("O dem�nio est� a ser consumido!");
		AudioPlayer player = new AudioPlayer();
		player.play("Demon_dying.wav"); // Toca som do dem�nio a morrer
		recycled = true; // Coloca o dem�nio como consumido
		System.out.println("Dem�nio consumido. L�mpada em reciclagem...");
	}

	/**
	 * Fun��o recursiva que pede ao dem�nio que realize um desejo, e pergunta 
	 * se quer realizar outro, indefinidamente, at� que se digite o c�digo
	 * de sa�da ("x")
	 * 
	 * @param 
	 * 		aWish - o desejo, em String
	 * @param 
	 * 		sc - o scanner ativo
	 * @return 
	 * 		verdadeiro se continua a realizar, sen�o falso
	 */
	public boolean grantWishDemon (String aWish, Scanner sc) 
	{
		System.out.println("Desejo concedido! " + aWish + " foi realizado. Escolha outro desejo, ou \"x\" para sair.");
		String resposta = MyErrorHandler.tryScannerNextLine(sc) ; // Guarda o desejo escolhido na vari�vel
		
		if (!resposta.equals("x")) // se a resposta � diferente de x (c�digo de sa�da)
			{
			this.grantWishDemon(resposta, sc); // realiza o desejo
			return true;
			}
		else return false; // retirna falso, se for escolhido o c�digo de sa�da "x"

	}
	
	/**
	 * Mostra o dem�nio.
	 */
	public void showMe ()
	{	
		Main.clearConsole(); // limpa a consola
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
