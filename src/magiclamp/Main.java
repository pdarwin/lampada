package magiclamp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author P. Perneta e J. Rocha
 *
 */

public class Main {

	public static void main(String[] args)
	{		
		

		Scanner sc = new Scanner(System.in); // Cria e inicializa o scanner de input
		
		boolean musicOn = false; // Cria e inicializa o boleano do estado do sequenciador de Midis
		
		printWelcomeToTheLamp(); // Imprime o ecrã de boas-vindas

		MidiSequencer midiSequencer = new MidiSequencer(); // inicializa o sequenciador de Midis
		try {
			/** Inicia a música */

			midiSequencer.playMidi();
			musicOn = true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			ErrorHandler.errorHandler(e1, sc, midiSequencer);
		}
		
		waitForEnter(); // aguarda que a tecla 'enter' seja pressionada
		
		/** Cria uma nova lâmpada */
		MagicLamp lamp; // Variável lâmpada
		
		int limit = 0; // cria e inicializa o n.º limite do random
		
		clearConsole(); // Limpa a consola com 50 linhas em branco
		
		/** Pergunta pelo limite do random que vai gerar os génios */
		System.out.println("Escolha o limite do número aleatório de génios que a lâmpada pode gerar");

		boolean ok = false; // Boleano para ciclos, inicializado a falso
				
		do
		{
			try {
				Random rand = new Random();
				/** Gera o limite de desejos a partir do random */
				limit = rand.nextInt(ErrorHandler.tryScannerNextInt(sc)); // Tenta atribuir o valor do scanner ao inteiro
				ok = true;
			}
			catch (Exception e1) {
				ErrorHandler.errorHandler(e1, sc, midiSequencer); // trata o erro
			}
		} while (!ok);
		
			
		if (limit <= 0) limit= 1; // para nunca dar 0 no random

			
		lamp = new MagicLamp(limit);
		
		/** Mostra o menu */
		printMenu(lamp, musicOn);


		/**
		 * cria e inicializa a variável que guarda a escolha do utilizador
		 */
		int choice = ErrorHandler.tryScannerNextInt(sc);
		
		
		ok = false;
		do 	{
				switch (choice)
				{
					case 1:						
						System.out.println("Quantas vezes deseja esfregar a lâmpada?"); // Pergunta
						int rubs = ErrorHandler.tryScannerNextInt(sc); // Guarda o nº de esfregadelas
			
						lamp.setRubs(rubs); // Esfrega a lâmpada o nº de vezes escolhido
						
						Genie genie = lamp.rub(sc); // Cria o génio - passa o scanner como parâmetro, 
													// para que possa definir o nº de desejos ao esfregar a lâmpada
						
						genie.showMe(); // mostra o génio
						int i;
						String wish = sc.nextLine(); // Cria a string, e limpa o nextLine 
						
						/** dois ciclos diferentes para pedir os desejos, caso seja génio ou demónio */
						
						if (genie instanceof Demon)
						{
							Demon demon = (Demon) genie; // Faz o cast para transformar o génio genérico em demónio
							System.out.println("Peça um desejo!");
							wish = sc.nextLine(); // Guarda o desejo no scanner
							
							demon.grantWishDemon(wish, sc); // chama a função recursiva que pede infinitos desejos ao demónio, 
															// até escolher parar

							lamp.rechargeLamp(demon); // recarrega a lâmpada
							
						}
						else {
							for (i = 1; i <= genie.getNumWishes(); i++ ) // Ciclo para realizar os desejos pedidos
							{
								System.out.println("Peça um desejo!");
								wish = sc.nextLine(); // Guarda o desejo no scanner
								genie.grantWish(wish); // Realiza o desejo
							}
						}
						
						System.out.println("Prima Enter para continuar");
						waitForEnter(); // aguarda que a tecla enter seja pressionada
						
						printMenu(lamp, musicOn); // Mostra menu
						choice = ErrorHandler.tryScannerNextInt(sc); // Coloca scanner à escuta para nova escolha
						break;
					case 2:
						if (!musicOn) // Verifica se a música está a tocar
						{
							midiSequencer = new MidiSequencer(); //Se não estiver, liga a música
							midiSequencer.playMidi();
							musicOn = true;
						}
						else 
						{
							midiSequencer.stopSequencer(); // Desliga a música
							musicOn = false; // Música desligada
						}
						clearConsole(); // Limpa consola
						printMenu(lamp, musicOn); // Mostra menu
						choice = ErrorHandler.tryScannerNextInt(sc); // Coloca scanner à escuta para nova escolha
						break;
					case 3: /* sequência de saída */
				        printGameOver(sc); // imprime mensagem de despedida
						
				        midiSequencer.stopSequencer(); // Desliga a música
						sc.close(); // Fecha o scanner
					
				        System.exit(0); // Sai do sistema
					default:
						System.out.println(choice + " não é uma opção válida. Escolha outra opção, por favor.");
						choice = ErrorHandler.tryScannerNextInt(sc); // Coloca scanner à escuta para nova escolha
						break;
				}
			} while (!ok);
	}
	
	/**
	 * Imprime o ecrã de boas vindas
	 */
	public static void printWelcomeToTheLamp () {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@((#(&&&&&&&&&#((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@(%((#@@@&@&&&&&@@@@@&((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@#%@@@@@@@&%%@@@@@@@@@&((&(#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@#@@@@@@@@%%%@@@@((@@@@@@@@@#(@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@(##((/(((@@@@(@@@@@@(%@@@@@@(&@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@/((//##((%@/,@@(((((/*&@@(@@@@@@@(@@@@&(@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@/((((((/(#(@ .,@(((@@@@@(/@@@(@@@@@@@/@@&(@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@/((((((((/*(/((((#@@  &@#((@@@@/@@@@@@@(@(&@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@/((((((((((((((((//*/@((((((@@@&&@@@@@@@%(@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@#((//(((((((((/((((.  /(((((((@@@@(@@@@@#(@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@#((((((((((*    (((/,/((((((((#@@@@(@%(@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@(((@@@@@#((((((((((...,,.,,./((((((((((@@%(/@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@(((%@@@@#((((((((((,,,,,,,*(((((((((((((((%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@%((#(((((%@@@@@#((((((((****/./((((((((((((/((((&@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@#(#(((((((#%%%(#@@@#((((#/////(((((((((((((((/(((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@#(((@@@@@@@@@@&(((((#@     (((((((((((((@@%&((@@@@@@#((@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@/    (((((((**(((((((((((%%%(#(((#@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@%*#(((((((((((***/@@@@@@@@%#%%#(((((((@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@**(((((((((((((****@@@@@@@@@@@@@@((((((#@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@**(((((((((((((****,@@@@@@@@@@@@@@@@#((((%@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@,,#((((((((((((*****,@@@@@@@@@@@@@@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@#(((((((((((((((,,@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@#((((((((((((((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@#((((((((((((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@##(/*******@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@,*****/(&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#((((#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#(((((((((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#((((@@@(((@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@                 @@@@@@@@@@@((@@#(@@@@@@@@@@@@@@@@@@@@@@@##@@@@@@@@@@@@@@@");
		System.out.println("@@@@@    Bem-vinda/o    @@@@@@@@@@@&@#(@@#@@@@@@@@@@@@@@@@@@#######%%@@@@@@@@@@@");
		System.out.println("@@@@@        à          @@@@@@@@@@@@@(@@@#(#%%%%&@@@@@@@@@###########%%@@%%@@%%@");
		System.out.println("@@@@@   Lâmpada Mágica! @@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%@%%%%%%%%%%%%%%%%%%@@@@%");
		System.out.println("@@@@@@                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%@@%%%@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%%%%%&@%%%@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%&%%##@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@    Prima Enter para continuar     @@@@@@@@@@@@@@@@@@@@@@@@@@");
		
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
	 * imprime o escrã final
	 */
	public static void printGameOver(Scanner sc)
	{

		boolean ok = false;
		
		do {
			clearConsole();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@        _                                                                  @@");
			System.out.println("@@       | |_  ____ ____   ___   ___    ____   ____ ____   ____              @@");
			System.out.println("@@       |  _)/ _  )    \\ / _ \\ /___)  |  _ \\ / _  )  _ \\ / _  |             @@");
			System.out.println("@@       | |_( (/ /| | | | |_| |___ |  | | | ( (/ /| | | ( ( | |_ _ _        @@");
			System.out.println("@@        \\___)____)_|_|_|\\___/(___/   | ||_/ \\____)_| |_|\\_||_(_|_|_)       @@");
			System.out.println("@@                                     |_|                                   @@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ * * * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@ * * * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ * * * @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@   Mas o jogo acabou    @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@ * * * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ * * * @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@     Até à próxima!     @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@ * * * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ * * * @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ * * * @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clearConsole();
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@        _                                                                  @@");
			System.out.println("@@       | |_  ____ ____   ___   ___    ____   ____ ____   ____              @@");
			System.out.println("@@       |  _)/ _  )    \\ / _ \\ /___)  |  _ \\ / _  )  _ \\ / _  |             @@");
			System.out.println("@@       | |_( (/ /| | | | |_| |___ |  | | | ( (/ /| | | ( ( | |_ _ _        @@");
			System.out.println("@@        \\___)____)_|_|_|\\___/(___/   | ||_/ \\____)_| |_|\\_||_(_|_|_)       @@");
			System.out.println("@@                                     |_|                                   @@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@   Mas o jogo acabou    @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@     Até à próxima!     @@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		} while (!ok);	
			
		
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

