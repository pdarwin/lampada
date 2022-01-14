package lampada;

import java.util.Scanner;
import java.util.Random;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static int menu()
	{
		System.out.println("\nBem-vindo a Lampada Mágica!");
		System.out.println("Escolha a opçao que prentende:");
		System.out.println("1 -Esfregar");
		System.out.println("2 -Sair");

		int opcao = sc.nextInt();
		return opcao;
	}

	public static void main(String[] args)
	{

		Random rand = new Random();
		int numGenios = rand.nextInt(11);
		Lampada nLamp = new Lampada(numGenios);

		while (menu() != 2)
		{
			System.out.println("Quantas vezes quer esfregar a lampada?");
			int rubs = sc.nextInt();

			nLamp.setNumEsfregadelas(rubs);

			int esfregadelas = nLamp.getNumEsfregadelas();

			System.out.println("Lampada esfregada " + esfregadelas + " vezes");
			
			boolean bom = esfregadelas % 2 == 0;
			
			String tipoGenio;
			if (bom == true) 
			{
				tipoGenio = "bom";
			}
			else
			{
				tipoGenio = "mau";
			}
			
			System.out.println("Foram " + esfregadelas + " - Chama genio " + tipoGenio);
				
			System.out.println("Quantos desejos pretende pedir?");
				
			int desejos = sc.nextInt();
				
			if (bom == true)
			{
				GenioBom genio =  new GenioBom(desejos);
				genio.realizaDesejo();
			}
			else
			{
				desejos = 1;
				GenioMau genio = new GenioMau(desejos);
				genio.realizaDesejo();
			}
				
			System.out.println(desejos + " desejos realizados!");
			
			
		}

	}
	
}
