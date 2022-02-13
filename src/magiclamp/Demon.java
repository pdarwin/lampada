package magiclamp;

import java.util.Scanner;

/**
 * Demónio reciclável
 * @author P. Perneta e J. Rocha
 * 
 */
public class Demon extends Genie {

	/*
	 * Verdadeiro se foi reciclado, senão falso 
	 */
	private boolean recycled = false;
	
	/**
	 * Construtor do demónio
	 * 
	 * @param aLimit
	 *            número de desejos a realizar (ignorado, independente do limite
	 *            mas passa na mesma para o caso de alguma funcionalidade futura)
	 */
	public Demon (int aNumWishes) {
		super();
	}
	

	/**
	 * Retorna o estado do demónio
	 * 
	 * @return 
	 * 		verdadeiro se reciclado, senão falso
	 */
	public boolean isRecycled() {
		return recycled;
	}

	/**
	 * Recicla o demónio - função chamada pela lâmpada mágica
	 */
	public void recycle() {
		System.out.println("O demónio está a ser consumido!");
		AudioPlayer player = new AudioPlayer();
		player.play("Demon_dying.wav"); // Toca som do demónio a morrer
		recycled = true; // Coloca o demónio como consumido
		System.out.println("Demónio consumido. Lâmpada em reciclagem...");
	}

	/**
	 * Função recursiva que pede ao demónio que realize um desejo, e pergunta 
	 * se quer realizar outro, indefinidamente, até que se digite o código
	 * de saída ("x")
	 * 
	 * @param 
	 * 		aWish - o desejo, em String
	 * @param 
	 * 		sc - o scanner ativo
	 * @return 
	 * 		verdadeiro se continua a realizar, senão falso
	 */
	public boolean grantWishDemon (String aWish, Scanner sc) 
	{
		System.out.println("Desejo concedido! " + aWish + " foi realizado. Escolha outro desejo, ou \"x\" para sair.");
		String resposta = MyErrorHandler.tryScannerNextLine(sc) ; // Guarda o desejo escolhido na variável
		
		if (!resposta.equals("x")) // se a resposta é diferente de x (código de saída)
			{
			this.grantWishDemon(resposta, sc); // realiza o desejo
			return true;
			}
		else return false; // retirna falso, se for escolhido o código de saída "x"

	}
	
	/**
	 * Mostra o demónio.
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
		System.out.println("@@@   Eu sou o demónio reciclável, e posso realizar todos os seus desejos!  @@@@");
	}
}
