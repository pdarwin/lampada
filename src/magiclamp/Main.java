package magiclamp;

import java.util.Scanner;

import java.util.Random;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static int menu()
	{
		System.out.println("\nBem-vindo a Lampada M�gica!");
		System.out.println("Escolha a op�ao que prentende:");
		System.out.println("1 -Esfregar");
		System.out.println("2 -Sair");

		int opcao = sc.nextInt();
		return opcao;
	}

	public static void main(String[] args)
	{

		/** Cria um random */
		Random rand = new Random();
		
		/** Gera o limite de desejos a partir do random */
		int limit = rand.nextInt(11);
		if (limit <= 0) limit= 1; // para nunca dar 0 no random
		System.out.println("Limite de g�nios:" + limit);
			
		/** Cria uma nova l�mpada */
		MagicLamp lamp = new MagicLamp(limit);

		/** Gera o menu */
		while (menu() != 2)
		{
			System.out.println("Quantas vezes quer esfregar a lampada?");
			int rubs = sc.nextInt();

			lamp.setRubs(rubs);

			System.out.println("Lampada esfregada " + rubs + " vezes");
			
			Genie genio = lamp.rub(); // Esfrega a l�mpada o n� de vezes escolhido
			
			System.out.println("num desejos " + genio.getGranted());
			System.out.println(genio instanceof NiceGenie ? "G�nio bom" : genio instanceof BadGenie ? "G�nio mau" : "Dem�nio");
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
	
}
