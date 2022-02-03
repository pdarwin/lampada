package magiclamp;

import java.util.Scanner;

import java.util.Random;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		
		printWelcomeToTheLamp();

		/** Cria um random */
		Random rand = new Random();
		
		/** Gera o limite de desejos a partir do random */
		int limit = rand.nextInt(11);
		if (limit <= 0) limit= 1; // para nunca dar 0 no random
		System.out.println("Nesta iteração foram gerados aleatoriamente " + limit + " génios.");
			
		/** Cria uma nova lâmpada */
		MagicLamp lamp = new MagicLamp(limit);

		/** Gera o menu */
		while (menu() != 2)
		{
			System.out.println("Quantas vezes quer esfregar a lampada?");
			int rubs = sc.nextInt();

			lamp.setRubs(rubs);

			System.out.println("Lampada esfregada " + rubs + " vezes");
			
			Genie genio = lamp.rub(); // Esfrega a lâmpada o nº de vezes escolhido
			
			System.out.println("num desejos " + genio.getGranted());
			System.out.println(genio instanceof NiceGenie ? "Génio bom" : genio instanceof BadGenie ? "Génio mau" : "Demónio");
			System.out.println(lamp);
			
			System.out.println();
			System.out.println("Realizar desejo (S/N)?");
			
			String realiza = sc.next();
			
			if (realiza != "N") {
				genio.grantWish();
				System.out.println(genio);
			}
			
		

		}
		

	}
	
	public static void printWelcomeToTheLamp () {
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNXNWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNxo0NWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWk';kNWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWX:.,dKNNNWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWKKk;'';lkKNWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWN00xc;,'..dXWWWWWWWWW");
		System.out.println("WW       Bem-vindo        WWWWX0o:lol;..l0NNWWWWWW");
		System.out.println("WW    à Lampada Mágica!   WWWNKX0xx0Odc,.'dKNWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWXKXKkxOOoc;..lXWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNNNNXdo0xcc:;oKWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNNWNKxx0xlclxKNWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWNNNXkoxxlloxKXNWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWNXXNKxlc;cdOKNNWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWNKXKxdxxO0XNNNWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWKkxONNXNNXNNNWWWWWWW");
		System.out.println("WWWWWWXOxxkKNWWWWXo;dXWWWWWWWWWX0XNWNNNNWWWWWWWWWW");
		System.out.println("WWWWKo'.,,..:0WWNk, ,ONWWWWWWWWWWXXXWWWWWWWWWWWWWW");
		System.out.println("WWWXc ,ONXo. ;KO:.   .:0WWWWWWWWWNKKNMWWWWWWWWWWWW");
		System.out.println("WWM0' oWWO.  ,o,       ;ONWWWWWWNNXXNWWWWWWWWWWWWW");
		System.out.println("WWWNl.'OWXo'...         .,:x0XXd;,,:kNWWWWWWWWWWWW");
		System.out.println("WWWWNx,'lx:..              ..::.  ;kNWWWWWWWWWWWWW");
		System.out.println("WWWWWWXk:'.                  .  'dXWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWd.  ',.         ...',;ckXWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWNx..'xX0l..   ..l0XXXXNWWWWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWX0XWNKc.     .cKNNWWWWWWWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWKxoc,.         .';coxKWWWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWOlcccccccccccccccccclOWWWWWWWWWWWWWWWWWWW");
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
	}
	
	public static int menu()
	{
		System.out.println("\n╔=== Menu da Lampada Mágica ===╗");
		System.out.println("╠==============================╣");
		System.out.println("║Escolha a opção que prentende 	║");
		System.out.println("╠==============================╣");
		System.out.println("║                              ║");
		System.out.println("║  1 -Esfregar                 ║");
		System.out.println("║  2 -Sair                     ║");
		System.out.println("║                              ║");
		System.out.println("╚==============================╝");

		int opcao = sc.nextInt();
		return opcao;
	}
	
}
