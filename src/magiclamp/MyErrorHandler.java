package magiclamp;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe geral para tratamento de erros
 * @author PP & JR
 *
 */
public class MyErrorHandler {

	/**
	 * Método geral para tratamento de erros
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
		catch (NumberFormatException e)
		{
			System.out.println("Opção inválida. Por favor digite um número inteiro."); // imprime mensagem de erro
			sc.next(); // limpa o scanner
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Opção inválida. Por favor digite um inteiro maior que zero."); // imprime mensagem de erro
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Erro: Ficheiro \"Aladdin-(Medley-Of-All-Songs).mid\" não encontrado, executando programa sem som.");
		}
		catch (IllegalStateException e)
		{
			// não faz nada, só passa à frente
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
	 * @return - o inteiro inserido pelo utilizador, se válido
	 */
	public static int tryScannerIntFromNextLine (Scanner sc)
	{
	
		boolean ok = false;
		int nInt = 0; // inicializa a variável que guarda o inteiro a devolver
		do
		{
			try 
			{
				nInt = Integer.parseInt (tryScannerNextLine(sc)) ; // Tenta atribuir o valor do scanner ao inteiro
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
		
		return nInt;
	}
	
	/**
	 * 
	 * @param sc - scanner
	 * @return - a string inserida pelo utilizador, se válida
	 */
	public static String tryScannerNextLine (Scanner sc)
	{
		boolean ok = false;
		String sString = "";
		do
		{
			try 
			{
				sString = sc.nextLine(); // Tenta atribuir o valor do scanner à String
				
				if (sString.trim().isEmpty())
				{
					System.out.println("O valor inserido estava vazio, ou só continha espaços. Por favor digite outra vez.");
				}
				else
				{
					ok = true;
				}					
					
			}
			catch (InputMismatchException e) // quando n é uma String válida
			{
				; // imprime mensagem de erro
				sc.next(); // limpa o scanner
			}
			catch (Exception e1) {
				e1.printStackTrace(); // mostra o erro
			}
		} while (!ok);
		
		return sString;
	}
	
}
