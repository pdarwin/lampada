package magiclamp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

	/** Scanner de input */
	static Scanner sc = new Scanner(System.in);
	
	/** Música ligada ou desligada */
	static boolean musicOn = false;
	public static void main(String[] args)
	{		
		
		/** Ecrã de boas vindas */
		printWelcomeToTheLamp();
		
		/** Inicia a música */
		MidiSequencer midiSequencer = new MidiSequencer();
		midiSequencer.playMidi();
		musicOn = true;
		
		/** Aqui aguarda que a tecla enter seja pressionada */
		try{
			System.in.read();
			}
		catch(Exception e){
			
		}
		
		/** Limpa a consola com 50 linhas em branco */
		clearConsole();
		
		/** Cria um random */
		Random rand = new Random();
		
		/** Gera o limite de desejos a partir do random */
		int limit = rand.nextInt(20);
		if (limit <= 0) limit= 1; // para nunca dar 0 no random

			
		/** Cria uma nova lâmpada */
		MagicLamp lamp = new MagicLamp(limit);

		/** Mostra o menu */
		showMenu(lamp, musicOn);

		/** choice - variável que guarda a escolha do utilizador */
		int choice = 0;
		
		boolean ok = false; // Boleano para o ciclo inicializado a falso
		do
		{
			try
			{
				choice = sc.nextInt(); // Tenta atribuir o valor do scanner ao inteiro
				ok = true; // Se conseguir, marca ok como verdadeiro para sair do ciclo
			}
			catch (InputMismatchException e) // Apanha como excepção tudo o que não seja um inteiro
			{
				System.out.println("Opção inválida. Escolha outra opção, por favor.");
				sc.next();
			}
		} while (!ok);
		
		ok = true;
		do 	{
				switch (choice)
				{
					case 1:
						clearConsole(); // Limpa a consola
						
						lamp.showMe(); // Mostra a lâmpada
						System.out.println("Quantas vezes deseja esfregar a lampada?"); // Pergunta
						int rubs = sc.nextInt(); // Guarda o nº de esfregadelas
			
						lamp.setRubs(rubs); // Esfrega a lâmpada o nº de vezes escolhido
						
						Genie genie = lamp.rub(sc); // Cria o génio - passa o scanner como parâmetro, para que possa definir o nº de desejos ao esfregar a lâmpada
						
						genie.showMe(); // mostra o génio
						int i;
						String wish = sc.nextLine(); // Cria a string, e limpa o nextLine 
						
						for (i = 1; i <= genie.getNumWishes(); i++ )
						{
							System.out.println("Peça um desejo!");
							wish = sc.nextLine();
							genie.grantWish(wish);
						}
						
						
						System.out.println("Prima Enter para continuar");
						/** Aqui aguarda que a tecla enter seja pressionada */
						try{
							System.in.read();
							}
						catch(Exception e){
							
						}
						
						clearConsole(); // Limpa consola
						showMenu(lamp, musicOn); // Mostra menu
						choice = sc.nextInt(); // Coloca scanner à escuta para nova escolha
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
						showMenu(lamp, musicOn); // Mostra menu
						choice = sc.nextInt(); // Coloca scanner à escuta para nova escolha
						break;
					case 3:
						break;
					case 4: /* sequência de saída */
				        System.out.println("Obrigado por usar a lâmpada mágica. Até à proxima!"); // imprime mensagem de despedida
						
				        midiSequencer.stopSequencer(); // Desliga a música
						sc.close(); // Fecha o scanner
						
				        System.exit(0); // Sai do sistema
					default:
						System.out.println(choice + " não é uma opção válida. Escolha outra opção, por favor.");
						choice = sc.nextInt(); // Coloca scanner à escuta para nova escolha
						break;
				}
			} while (ok);

	}
	
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
		System.out.println("@@@@@    Bemvinda/o     @@@@@@@@@@@&@#(@@#@@@@@@@@@@@@@@@@@@#######%%@@@@@@@@@@@");
		System.out.println("@@@@@        à          @@@@@@@@@@@@@(@@@#(#%%%%&@@@@@@@@@###########%%@@%%@@%%@");
		System.out.println("@@@@@   Lâmpada Mágica! @@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%@%%%%%%%%%%%%%%%%%%@@@@%");
		System.out.println("@@@@@@                 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%@@%%%@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%%%%%&@%%%@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%&%%##@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@    Prima Enter para continuar     @@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
	public static void showMenu (MagicLamp aLamp, boolean aMusicOn)
	{
		System.out.println("╔====  Bemvinda/o ao menu da Lampada Mágica  ====╗");
		System.out.println("╠================================================╣");
		System.out.println("║                                                ║");
		System.out.println("║       Lâmpada carregada com " + aLamp.getNumGenies() +
							 " de " + aLamp.getLimGenies() + " génios" + 
							 (aLamp.getNumGenies()< 10 ? " " :"") + 
							 (aLamp.getLimGenies()< 10 ? " " :"") + "    ║");
		System.out.println("║                                                ║");
		System.out.println("║              Escolha uma opção                 ║");
		System.out.println("╠================================================╣");
		System.out.println("║                                                ║");
		System.out.println("║       1 -Esfregar a lâmpada                    ║");
		System.out.println("║       2 -" + (aMusicOn ? "Desl" : "L") + 
										"igar música" + (aMusicOn ? "" : "   ") +
										"                       ║");
		System.out.println("║       3 -Reiniciar                             ║");
		System.out.println("║       4 -Sair                                  ║");
		System.out.println("║                                                ║");
		System.out.println("╚================================================╝");

	}
	
	public final static void clearConsole()
	{
		for(int i = 0; i < 50; i++) // 
		    System.out.println();   // Imprime 50 linhas em branco para limpar a consola
	}
	
}
