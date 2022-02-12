package magiclamp;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ErrorHandler {

	/**
	 * Classe geral para tratamento de erros
	 * @param err - o erro a ser tratado
	 * @param sc - scanner, para fechar em caso de erro
	 * @param midiSequencer - sequenciador de Midis (para fechar em caso de erro)
	 */
	public static void errorHandler (Exception err, Scanner sc, MidiSequencer midiSequencer)
	{
		
		try {
			throw err;
		}
		catch (InputMismatchException e) // quando n é um inteiro
		{
			System.out.println("Opção inválida. Por favor digite um número inteiro."); // imprime mensagem de erro
			sc.next(); // limpa o scanner
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Opção inválida. Por favor digite um inteiro maior que zero."); // imprime mensagem de erro
		}
		catch (Exception e)
		{
			e.printStackTrace();
	        System.out.println("Ocorreu um erro imprevisto. Finalizando programa..."); // imprime mensagem de despedida
			
	        midiSequencer.stopSequencer(); // Desliga a música
			sc.close(); // Fecha o scanner
			
	        System.exit(0); // Sai do sistema
		}
		
	}
	
	/**
	 * 
	 * @param sc - scanner
	 * @param midiSequencer - sequenciador de Midis (para fechar em caso de erro)
	 * @return - o valor dado pelo utilizador
	 */
	public static int tryScannerNextInt (Scanner sc)
	{
	
		boolean ok = false;
		int n = 0;
		do
		{
			try {
				
				/** Gera o limite de desejos a partir do random */
				n = sc.nextInt(); // Tenta atribuir o valor do scanner ao inteiro
				ok = true;
			}
			catch (InputMismatchException e) // quando n é um inteiro
			{
				System.out.println("Opção inválida. Por favor digite um número inteiro."); // imprime mensagem de erro
				sc.next(); // limpa o scanner
			}
			catch (Exception e1) {
				e1.printStackTrace(); // mostra o erro
			}
		} while (!ok);
		
		return n;
	}
	
}
