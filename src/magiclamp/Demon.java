package magiclamp;

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
		this.numWishes = aNumWishes;
		this.remWishes = aNumWishes;
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
		recycled = true;
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
		System.out.println("@@@@@@@@@   Eu sou o demónio reciclável, e posso realizar " + remWishes + 
				" desejo" + (remWishes > 1 ? "s" : " ") + " @@@@@@@@@@@");
	}

}
