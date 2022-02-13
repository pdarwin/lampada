package magiclamp;

/**
 * G�nio mau - s� concede um desejo
 * @author P. Perneta e J. Rocha
 * 
 */
public class BadGenie extends Genie {

	/**
	 * Construtor do g�nio mau
	 * 
	 * @param limit
	 *            n�mero de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie() {
		super();
		this.numWishes = 1; // inicializa o n.� total de desejos
		this.remWishes = 1; // inicializa o n.� de desejos restantes
	}

	/**
	 * Mostra o g�nio.
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
		System.out.println("          Eu sou o g�nio mau, e vou conceder apenas um desejo!                  ");
		
		AudioPlayer player = new AudioPlayer(); 
		player.play("Evil_laugh.wav"); // toca a gargalhada do g�nio mau
	}
	
}
