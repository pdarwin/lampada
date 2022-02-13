package magiclamp;

/**
 * Génio mau - só concede um desejo
 * @author P. Perneta e J. Rocha
 * 
 */
public class BadGenie extends Genie {

	/**
	 * Construtor do génio mau
	 * 
	 * @param limit
	 *            número de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie() {
		super();
		this.numWishes = 1; // inicializa o n.º total de desejos
		this.remWishes = 1; // inicializa o n.º de desejos restantes
	}

	/**
	 * Mostra o génio.
	 */
	public void showMe ()
	{
		Main.clearConsole(); // limpa a consola
		System.out.println("                                                                                ");
		System.out.println("                                                                                ");
		System.out.println("                                                                                ");
		System.out.println("               ##                                                %              ");
		System.out.println("              %&@@,                                            /@&@.            ");
		System.out.println("              @@@@@@*                                        (&&@@&@            ");
		System.out.println("             &@@@@@&&&(                                    %@@@@@@@@,           ");
		System.out.println("             @@@@@@@@@&@&                                &@@@@@@@@@@*           ");
		System.out.println("             @@@@@@@@@@@@@&                            &@&@@@@@@@@@@*           ");
		System.out.println("             %@@@@@@@@@@@@@@@                       .&&@@@@@@@@@@@&@,           ");
		System.out.println("              &@@@@@@@@@@@@@@@&,                  /&@@@@@@@@@@@@@@&#            ");
		System.out.println("               @@@@@@@@@@@@@@@@@@#              &@@@@@@@@@@@@@@@@@&        &    ");
		System.out.println("                %@@@@&@@@@@@@@@@@&@#          &@@&@@@@@@@@@@@@@&&(        *&    ");
		System.out.println("     *  ..         ,&@@@@@@@@@@@@&@%          &@@@@@@@@@@@@@&&,          .&*    ");
		System.out.println("     &,  @(                &@@&@@/..          #.&&@@@&&.                 @@     ");
		System.out.println("     .@( /@&                                                            &@&     ");
		System.out.println("      (@& @@@.                                                        .&@&.     ");
		System.out.println("       &@@@@@@&                                                      (&&@#      ");
		System.out.println("        %&@&@@@&,   *&                                         #.   &@@@&       ");
		System.out.println("         *@@@@@@@&. #@&&                                      @@@ #@&&&&        ");
		System.out.println("           @@@@@@@@@@@@@@@        *&             .@&,       *&@@@@&&.#%         ");
		System.out.println("             @&@@@@@@@@@@@@@     .@@@&          &&@@&&     &&@@@@&&  ,          ");
		System.out.println("               .  &@@&@@@@&&@@#  &@@@@@@      /@@@@@@@@  @@@@@&&@%              ");
		System.out.println("                   .@&@@@@@&@&@&@@@@@@@&&&  /&@@@@@&@@@@@&&  .@@                ");
		System.out.println("                      @@@@   *@@@@@@@@@@@@&&@@@@@@@(@@@&&                       ");
		System.out.println("                         *       /@@@@    &@@@@&&                               ");
		System.out.println("                                                                                ");
		System.out.println("                                                                                ");
		System.out.println("                                                                                ");
		System.out.println("          Eu sou o génio mau, e vou conceder apenas um desejo!                  ");
		
		AudioPlayer player = new AudioPlayer(); 
		player.play("Evil_laugh.wav"); // toca a gargalhada do génio mau
	}
	
}
