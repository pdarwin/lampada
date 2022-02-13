package magiclamp;

/**
 * Génio mau - só concede um desejo
 */
public class BadGenie extends Genie {

	/**
	 * @param limit
	 *            número de desejos a realizar - ignorado, apenas para compatibilidade
	 */
	public BadGenie() {
		super();
		this.numWishes = 1;
		this.remWishes = 1;
	}

	/**
	 * Mostra o génio.
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
		System.out.println("          Eu sou o génio mau, e vou conceder apenas um desejo!                  ");
		AudioPlayer player = new AudioPlayer();
		player.play("Evil_laugh.wav");
	}
	
}
