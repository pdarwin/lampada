package magiclamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author P. Perneta e J. Rocha
 *
 */

public class Main {

	static long now = System.currentTimeMillis();   
	
	public static void main(String[] args)
	{			

		Scanner sc = new Scanner(System.in); // Cria e inicializa o scanner de input
		
		boolean musicOn = false; // Cria e inicializa o boleano do estado do sequenciador de Midis
		
		printWelcomeToTheLamp(); // Imprime o ecrã de boas vindas
		
		MidiSequencer midiSequencer = new MidiSequencer(); // inicializa o sequenciador de Midis
		try {
			/** Inicia a música */

			midiSequencer.playSound("Aladdin-(Medley-Of-All-Songs).mid");
			musicOn = true;
		} 
		catch (Exception e1) 
		{
			MyErrorHandler.errorHandler(e1, sc, midiSequencer);
		}
		
		/**
		 * lamp - variável que guarda a lâmpada mágica
		 */
		MagicLamp lamp; 
		
		int limit = 0; // cria e inicializa o n.º limite do random

		boolean ok = false; // Boleano para ciclos inicializado a falso
				
		do
		{
			try {
				Random rand = new Random();
				/** Gera o limite de desejos a partir do random */
				limit = rand.nextInt(MyErrorHandler.tryStartNum(sc)); // Tenta atribuir o valor do scanner ao inteiro
				ok = true;
			}
			catch (Exception e1) {
				MyErrorHandler.errorHandler(e1, sc, midiSequencer); // trata o erro
			}
		} while (!ok);
		
			
		if (limit <= 0) limit= 1; // para nunca dar 0 no random

			
		lamp = new MagicLamp(limit);
		
		/** Mostra o menu */
		printMenu(lamp, musicOn);


		/**
		 * cria e inicializa a variável que guarda a escolha do utilizador
		 */
		int choice = MyErrorHandler.tryScannerIntFromNextLine(sc);
		
		
		ok = false;
		do 	{
				switch (choice)
				{
					case 1:						
						System.out.println("Quantas vezes deseja esfregar a lâmpada?"); // Pergunta
						int rubs = MyErrorHandler.tryScannerIntFromNextLine(sc); // Guarda o nº de esfregadelas
			
						lamp.setRubs(rubs); // Esfrega a lâmpada o nº de vezes escolhido
						
						Genie genie = lamp.rub(sc); // Cria o génio - passa o scanner como parâmetro, para que possa definir o nº de desejos ao esfregar a lâmpada
						
						genie.showMe(); // mostra o génio
						int i;
						String wish = ""; // Cria a string 
						
						/** dois ciclos diferentes para pedir os desejos, caso seja génio ou demónio */
						
						if (genie instanceof Demon)
						{
							Demon demon = (Demon) genie; // Faz o cast para transformar o génio genérico em demónio
							
							System.out.println("Peça um desejo!");
							wish = MyErrorHandler.tryScannerNextLine(sc); // Guarda o desejo no scanner
							
							demon.grantWishDemon(wish, sc); // chama a função recursiva que pede infinitos desejos ao demónio, até escolher parar

							lamp.rechargeLamp(demon); // recarrega a lâmpada
							
						}
						else {
							for (i = 1; i <= genie.getNumWishes(); i++ ) // Ciclo para realizar os desejos pedidos
							{
								System.out.println("Peça um desejo!");
								wish = MyErrorHandler.tryScannerNextLine(sc); // Guarda o desejo no scanner
								genie.grantWish(wish); // Realiza o desejo
							}
						}
						
						System.out.println("Prima Enter para continuar");
						waitForEnter(); // aguarda que a tecla enter seja pressionada
						
						printMenu(lamp, musicOn); // Mostra menu
						sc.nextLine();
						choice = MyErrorHandler.tryScannerIntFromNextLine(sc); // Coloca scanner à escuta para nova escolha
				
						break;
					case 2:
						try { // idealmente não correria se o ficheiro não existisse
							if (!musicOn) // Verifica se a música está a tocar
							{
								midiSequencer = new MidiSequencer(); //Se não estiver, liga a música
								midiSequencer.playSound("Aladdin-(Medley-Of-All-Songs).mid");
								musicOn = true;
							}
							else 
							{
								midiSequencer.stopSequencer(); // Desliga a música
								musicOn = false; // Música desligada
							}
						} catch (Exception e) {
							MyErrorHandler.errorHandler(e, sc, midiSequencer);
						}
						
						clearConsole(); // Limpa consola
						printMenu(lamp, musicOn); // Mostra menu
					
						choice = MyErrorHandler.tryScannerIntFromNextLine(sc); // Coloca scanner à escuta para nova escolha
						break;
					
					case 3: /* sequência de saída */
				        printGameOver(sc); // imprime mensagem de despedida
						
				        midiSequencer.stopSequencer(); // Desliga a música
						sc.close(); // Fecha o scanner
					
				        System.exit(0); // Sai do sistema
					default:
						System.out.println(choice + " não é uma opção válida. Escolha outra opção, por favor.");
						choice = MyErrorHandler.tryScannerIntFromNextLine(sc); // Coloca scanner à escuta para nova escolha
						break;
				}
			} while (!ok);
	}
	
	/**
	 * Imprime o ecrã de boas vindas
	 */
	public static void printWelcomeToTheLamp () {
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		System.out.println("───  _     /\\                      _        __  __   __      _          ───");
		System.out.println("─── | |   |/\\| _ __  _ __  __ _ __| |__ _  |  \\/  |_/_/ __ _(_)__ __ _  ───");
		System.out.println("─── | |__/ _` | '  \\| '_ \\/ _` / _` / _` | | |\\/| / _` / _` | / _/ _` | ───");
		System.out.println("─── |____\\__,_|_|_|_| .__/\\__,_\\__,_\\__,_| |_|  |_\\__,_\\__, |_\\__\\__,_| ───");
		System.out.println("───                 |_|                                |___/            ───");
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("────────────────────▓╫─▄▀────────────▄▀───────────▄▀─╫▓────────────────────");
		System.out.println("────────────────────▓╫─▀▄───────────▐█────────────▀▄─╫▓────────────────────");
		System.out.println("────────────────────▓╫─▄▌▄───────────▀▄───────────▄▌▄╫▓────────────────────");
		System.out.println("── Nas areias     ──▓▄▀░▓░▀▄──────────▌─────────▄▀░▓░▀▓── Para descobrir ──");
		System.out.println("── do deserto,    ──▓░░░░░░░▌──────▄▄▀▀▄▄──────▐▓░░░░░▓── o que ela      ──");
		System.out.println("── achou uma      ──▓▓░░░░░▓▀────▄▀░░▓▓░░▀▄────▀▄░░░░░▓── guarda, comece ──");
		System.out.println("── misteriosa     ──▓╫▓█▓█▓─────▐▓░░P░D░S░▓▌─────▓█▓█▓▓── por escolher   ──");
		System.out.println("── lâmpada...     ──▓╫▐░░░▌─────██▀▀▀▀▀▀▀▀██─────▐░░░╫▓── um número      ──");
		System.out.println("────────────────────▓╫▐░█░▌───▄▄████████████▄▄───▐░█░╫▓── entre 1 e 20   ──");
		System.out.println("────────────────────▓╫▐░░░▌───▐▓▓▓▌▐▒▓▓▒▌▐▓▓▓▌───▐░░░╫▓────────────────────");
		System.out.println("────────────────────▓╫▐░█░▌───▐▓▓▓▌▐▓▒▒▓▌▐▓▓▓▌───▐░█░╫▓────────────────────");
		System.out.println("────────────────────▓╫▐░░░▌▄▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▄▐░░░╫▓────────────────────");
		System.out.println("────────────────────▓╫▐░█░███▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓███░█░╫▓────────────────────");
		System.out.println("────────────────────▓╫▐░░░▌░█▒▒▒▒▒▒▒▒▒▓▒▒▒▒▒▒▒▓▒▒▐░█░╫▓────────────────────");
		System.out.println("════════════════════◙═════════════════════════════════◙════════════════════");
		System.out.println("───────────────────────────────────────────────────────────────────────────");
		System.out.println("─────────────── Digite um número entre 1 e 20 para iniciar ────────────────");	
	}
	
	/**
	 * imprime o menu
	 * @param aLamp - a Lâmpada Mágica
	 * @param aMusicOn - o estado do som (ligado/ desligado)
	 */
	public static void printMenu (MagicLamp aLamp, boolean aMusicOn)
	{
		clearConsole();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@   * * *  Menu da Lâmpada Mágica    * * *   @@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@((#(@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@((#(@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/*(#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/,,***,,*%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@&%&&@@@@@@@@@@@@@@@@@@@@@@@(,,*(#%&&%#*,.*&@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@*#****/*#%(&@@@@@@@@@@@@@@@@@(*,,//(#%%#(*,,,/#@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@&%(**#%(#@@@@@@@@@@@@**,,,*********,****%@@@@@@@@@@@@&#((#%@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@&%(*,/%%#/&@@@@@@/,**/(((((((////**,,,%@@@@@@@#/%*(&@@%*#/(@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@&%#/*,**#%####################%%%%%%%###@&/(%@@@@@@@@@@,(#@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@%%#//**********//((##%%%#(/********/*/,@@%(%@@@@@@@@/(#@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%##%#//*///*****************////////*@/%/%@@@@@@%/#(@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@#(#%&%%#/////////////////(#%%%%((@@%*%*/%%(,##/%@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#(##%%%%%%%%%%%%%%%%%%%%%%#(@@@@@@@%(//(#&@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%*///(((######(((///&@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@    Génios: " + aLamp.getNumGenies() +
				 " de " + aLamp.getLimGenies() + 
				 (aLamp.getNumGenies()< 10 ? " " :"") + 
				 (aLamp.getLimGenies()< 10 ? " " :"") + "   @@@@@@@@@@@@&%(///(&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,(#/,(*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@   N.º de recargas: " + aLamp.getDemons() 
			+"   @@@@@@@@@(*#&%/**(/#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,*(%&&#//,*/%/,@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,*//(((#############(((//**@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@     1 - Esfregar lâmpada         2 - " + 
				(aMusicOn ? "Desl" : "L") + "igar música" + (aMusicOn ? "" : "   ") + "          3 - Sair     @@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	/**
	 * imprime o escrã final, com animação
	 */
	public static void printGameOver(Scanner sc)
	{

		// geração do buffer para sair do ciclo infinito
		InputStreamReader inputStream = new InputStreamReader(System.in); // Cria o leitor de streams
		BufferedReader bufferedReader = new BufferedReader(inputStream); // Cria o buffer com o leitor de streams
		
		do { // Ciclo infinito para alternar entre as duas telas, mostrando os créditos finais
			 // Sai do ciclo quando dá enter, apanhado pelo buffer abaixo
			try {
				if (bufferedReader.ready()) //coloca o buffer em escuta
				 {
				     bufferedReader.readLine(); // se lê uma linha...

				     break; // sai do ciclo
				 }
			} catch (IOException e1) {

				MyErrorHandler.errorHandler(e1, sc, null);
			}
			
			clearConsole(); // limpa a consola
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@                                                                           @@");
			System.out.println("@@      ________              .__         ________                           @@");
			System.out.println("@@      /  _____/  ____   ____ |__| ____   \\_____  \\___  __ ___________      @@");
			System.out.println("@@     /   \\  ____/ __ \\ /    \\|  |/ __ \\   /   |   \\  \\/ // __ \\_  __ \\     @@");
			System.out.println("@@     \\    \\_\\  \\  ___/|   |  \\  \\  ___/  /    |    \\   /\\  ___/|  | \\/     @@");
			System.out.println("@@      \\______  /\\___  >___|  /__|\\___  > \\_______  /\\_/  \\___  >__|        @@");
			System.out.println("@@             \\/     \\/     \\/        \\/          \\/          \\/            @@");
			System.out.println("@@                                                                           @@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ _(^.^)_ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@ _(^.^)_ @@@@@@@   *   *  Créditos:   *   *   @@@@@@ _(^.^)_ @@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@                              @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@ *   * @@@@@@@@        Paulo Perneta         @@@@@@@ *   * @@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@          João Rocha          @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@ \\(^.^)/ @@@@@@@   Disney (Tema do Aladino)   @@@@@@ \\(^.^)/ @@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@                              @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ _(^.^)_ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@      Prima enter para sair      @@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Thread.sleep(500); // dorme durante 0,5 segundos
			} catch (InterruptedException e) {
				
				MyErrorHandler.errorHandler(e, sc, null);
			}
			clearConsole(); // Limpa a consola
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@                                                                           @@");
			System.out.println("@@      ________              .__         ________                           @@");
			System.out.println("@@      /  _____/  ____   ____ |__| ____   \\_____  \\___  __ ___________      @@");
			System.out.println("@@     /   \\  ____/ __ \\ /    \\|  |/ __ \\   /   |   \\  \\/ // __ \\_  __ \\     @@");
			System.out.println("@@     \\    \\_\\  \\  ___/|   |  \\  \\  ___/  /    |    \\   /\\  ___/|  | \\/     @@");
			System.out.println("@@      \\______  /\\___  >___|  /__|\\___  > \\_______  /\\_/  \\___  >__|        @@");
			System.out.println("@@             \\/     \\/     \\/        \\/          \\/          \\/            @@");
			System.out.println("@@                                                                           @@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \\(^.^)/ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@ \\(^.^)/ @@@@@@@     *    Créditos:     *     @@@@@@ \\(^.^)/ @@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@                              @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@   *   @@@@@@@@        Paulo Perneta         @@@@@@@   *   @@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@          João Rocha          @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@ \\(^.^)/ @@@@@@@   Disney (Tema do Aladino)   @@@@@@ \\(^.^)/ @@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@                              @@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ \\(^.^)/ @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@      Prima enter para sair      @@@@@@@@@@@@@@@@@@@@@@@@");
			
			try 
			{
				Thread.sleep(500); // dorme durante 0,5 segundos
			} 
			catch (InterruptedException e) 
			{
				MyErrorHandler.errorHandler(e, sc, null);
			}
						
		} while (true);

	}
	
	/**
	 * Imprime 50 linhas em branco para limpar a consola
	 */
	public static void clearConsole()
	{
		for(int i = 0; i < 50; i++)  
		    System.out.println();   
	}
	
	/**
	 * Aguarda que a tecla enter seja pressionada
	 */
	public static void waitForEnter()
	{
		try{
			System.in.read();
			}
		catch(Exception e){
		}
	}
	
}

