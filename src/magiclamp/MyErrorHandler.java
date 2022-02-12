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
	 * M�todo geral para tratamento de erros
	 * @param err - o erro a ser tratado
	 * @param sc - scanner, para fechar em caso de erro
	 * @param midiSequencer - sequenciador de Midis (para fechar em caso de erro)
	 */
	public static void errorHandler (Exception err, Scanner sc, MidiSequencer midiSequencer)
	{
		
		try {
			throw err;
		}
		catch (InputMismatchException e) // quando n � um inteiro
		{
			System.out.println("Op��o inv�lida. Por favor escolha um n�mero."); // imprime mensagem de erro
			//sc.next(); // limpa o scanner
		}
		catch (NumberFormatException e)
		{
			System.out.println("Op��o inv�lida. Por favor escolha um n�mero."); // imprime mensagem de erro
			//sc.next(); // limpa o scanner
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Op��o inv�lida. Por favor escolha um n�mero maior que zero."); // imprime mensagem de erro
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Erro: Ficheiro \"Aladdin-(Medley-Of-All-Songs).mid\" n�o encontrado, executando programa sem som.");
		}
		catch (IllegalStateException e)
		{
			// n�o faz nada, s� passa � frente
		}
		catch (Exception e)
		{
			e.printStackTrace();
	        System.out.println("Ocorreu um erro imprevisto. Finalizando programa..."); // imprime mensagem de despedida
			
	        midiSequencer.stopSequencer(); // Desliga a m�sica
			sc.close(); // Fecha o scanner
			
	        System.exit(0); // Sai do sistema
		}
		
	}
	
	/**
	 * 
	 * @param sc - scanner
	 * @return - o inteiro inserido pelo utilizador, se v�lido
	 */
	public static int tryScannerIntFromNextLine (Scanner sc)
	{
	
		boolean ok = false;
		int nInt = 0; // inicializa a vari�vel que guarda o inteiro a devolver
		do
		{
			try 
			{
				nInt = Integer.parseInt (tryScannerNextLine(sc)) ; // Tenta atribuir o valor do scanner ao inteiro
				ok = true;
			}
			catch (Exception e1) {
				errorHandler(e1, sc, null); // mostra o erro
			}
		} while (!ok);
		
		return nInt;
	}
	
	/**
	 * 
	 * @param sc - scanner
	 * @return - a string inserida pelo utilizador, se v�lida
	 */
	public static String tryScannerNextLine (Scanner sc)
	{
		String sString = "";
		do
		{
			try 
			{
				sString = sc.nextLine(); // Tenta atribuir o valor do scanner � String
				
				if (sString.trim().isEmpty())
				{
					System.out.println("O valor inserido estava vazio, ou s� continha espa�os. Por favor digite outra vez.");
					//sc.next(); // limpa o scanner
				}
				else
				{
					break;
				}					
					
			}
			catch (InputMismatchException e) // quando n � uma String v�lida
			{
				; // imprime mensagem de erro
				//sc.next(); // limpa o scanner
			}
			catch (Exception e1) {
				e1.printStackTrace(); // mostra o erro
			}
		} while (true);
		
		return sString;
	}
	
	/**
	 * 
	 * @param sc - O scanner ativo na sess�o
	 * @return - o inteiro escolhido pelo utilizador e validado pelo sistema
	 */
	public static int tryStartNum (Scanner sc) 
	{
		
		int num;
		
		do
		{
	
			num = tryScannerIntFromNextLine(sc);
			
			if (num > 0 && num <= 20)
			{
				break;
			}
			else
			{
				System.out.println("Por favor escolha um n�mero entre 1 e 20");

			}
		} while (true);
		
		return num;
	}
	
}
