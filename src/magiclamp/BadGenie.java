package magiclamp;

/**
 * G�nio mau - s� concede um desejo
 */
public class BadGenie extends Genie {

	/**
	 * @param limit
	 *            n�mero de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie() {
		super();
		this.numWishes = 1;
		this.remWishes = 1;
	}

	/**
	 * Mostra o g�nio.
	 */
	public void showMe ()
	{
		Main.clearConsole();
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
		player.play("Evil_laugh.wav");
	}
	
}
