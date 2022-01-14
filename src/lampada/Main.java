package lampada;

import java.util.Scanner;

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

		Lampada nLamp = new Lampada(5);

		while (menu() != 2)
		{
			System.out.println("Quantas vezes quer esfregar a lampada?");
			int rubs = sc.nextInt();

			nLamp.setNumEsfregadelas(rubs);

			int esfregadelas = nLamp.getNumEsfregadelas();

			System.out.println("Lampada esfregada " + esfregadelas + " vezes");

			System.out.println("Quantos desejos pretende pedir?");
			int desejos = sc.nextInt();

			if (esfregadelas % 2 == 0)
			{
				System.out.println("Chama genio bom");
			} else
			{
				System.out.println("Chama genio mau");
			}

		}

	}
	
}
