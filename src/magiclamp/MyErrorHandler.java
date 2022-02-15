package magiclamp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Classe geral para tratamento de erros
 * @author P. Perneta e J. Rocha
 *
 */
public class MyErrorHandler {

	/**
	 * M�todo geral para tratamento de erros
	 * 
	 * @param err
	 * 			o erro a ser tratado
	 * @param sc
	 * 			o scanner corrente, para fechar em caso de erro fatal
	 * @param midiSequencer
	 * 			sequenciador de Midis aberto, para fechar em caso de erro fatal
	 */
	public static void errorHandler (Exception err, Scanner sc, MidiSequencer midiSequencer)
	{
		
		try {
			throw err; // atira o erro recebido, para tratamento pelos catch abaixo
		}
		catch (InputMismatchException e) // quando n�o � um n.� inteiro
		{
			System.out.println("Op��o inv�lida. Por favor escolha um n�mero."); // imprime mensagem de erro
		}
		catch (NumberFormatException e) // quando est� fora do formato de dados aceite
		{
			System.out.println("Op��o inv�lida. Por favor escolha outro n�mero."); // imprime mensagem de erro
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Op��o inv�lida. Por favor escolha um n�mero maior que zero."); // imprime mensagem de erro
		}
		catch (FileNotFoundException e) // ficheiro n�o encontrado
		{
			System.out.println("Ficheiro audio n�o encontrado, executando sem som.\nDetalhes: " +
					e.getMessage()); // Mostra a mensagem do erro, para que se perceba qual � o ficheiro em falta
		}
		catch (IllegalStateException e) // estado ilegal (relacionado ao sequenciador de Midis)
		{
			// n�o faz nada por agora, s� passa � frente
		}
	    catch (UnsupportedAudioFileException e) //ficheiro audio n�o suportado (classe AudioPlayer)
		{
	        System.out.println("Ficheiro audio n�o suportado.");
	        e.printStackTrace();
	    } catch (LineUnavailableException e) // linha de audio indispon�vel (classe AudioPlayer)
		{
	        System.out.println("Sem linha dispon�vel para tocar o audio.");
	        e.printStackTrace();
	    }
		catch (NoSuchElementException e)
		{
			// System.out.println("Sem linha dispon�vel para tocar o audio.");
	        // e.printStackTrace();
		}
		catch (IOException e) // erro I/O (classe AudioPlayer)
		{
	        System.out.println("Erro ao tocar o audio.");
	        e.printStackTrace();
	    }
		catch (Exception e) // Outros erros n�o previstos acima
		{
			e.printStackTrace();
	        System.out.println("Ocorreu um erro imprevisto. Finalizando programa..."); // imprime mensagem de despedida
			
	        if (midiSequencer != null) midiSequencer.stopSequencer(); // Desliga a m�sica, se o sequenciador existir
	        if (sc != null) sc.close(); // Fecha o scanner, se n�o for nulo
			
	        System.exit(0); // Sai do sistema
		}
		
	}
	
	/**
	 * Testa os inteiros inseridos no Scanner
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
	 * @return o inteiro inserido pelo utilizador, se v�lido
	 */
	public static int tryScannerIntFromNextLine (Scanner sc)
	{
	
		int nInt = 0; // inicializa a vari�vel que guarda o inteiro a devolver
		
		do
		{
			try 
			{
				nInt = Integer.parseInt (tryScannerNextLine(sc)) ; // Tenta atribuir o valor do scanner ao inteiro
				break;
			}
			catch (Exception e1) {
				errorHandler(e1, sc, null); // Trata o erro
			}
		} while (true);
		
		return nInt;
	}
	
	/**
	 * Testa a String inserida no Scanner, para ver se � vazia ou s� com espa�os
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
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
				
				if (sString.trim().isEmpty()) // Se a tring estiver vazia
				{
					System.out.println("O valor inserido estava vazio, ou s� continha espa�os. Por favor digite outra vez.");
				}
				else
				{
					break;
				}					
					
			}
			catch (Exception e)
			{// quando n � uma String v�lida
				errorHandler(e, sc, null); // Trata o erro
			}
		} while (true);
		
		return sString;
	}
	
	/**
	 * Valida o n�mero da escolha inicial (m�ximo do random)
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
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
	
	/**
	 * Valida op��es do menu
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
	 * @return - o inteiro escolhido pelo utilizador e validado pelo sistema
	 */
	public static int tryOption (Scanner sc) 
	{
		
		int option;
		
		do
		{
	
			option = tryScannerIntFromNextLine(sc);
			
			if (option > 0 && option <= 3)
			{
				break;
			}
			else
			{
				System.out.println("Op��o inv�lida. Por favor escolha uma op��o entre 1 e 3.");

			}
		} while (true);
		
		return option;
	}
	
}
