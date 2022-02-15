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
	 * Método geral para tratamento de erros
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
		catch (InputMismatchException e) // quando não é um n.º inteiro
		{
			System.out.println("Opção inválida. Por favor escolha um número."); // imprime mensagem de erro
		}
		catch (NumberFormatException e) // quando está fora do formato de dados aceite
		{
			System.out.println("Opção inválida. Por favor escolha outro número."); // imprime mensagem de erro
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Opção inválida. Por favor escolha um número maior que zero."); // imprime mensagem de erro
		}
		catch (FileNotFoundException e) // ficheiro não encontrado
		{
			System.out.println("Ficheiro audio não encontrado, executando sem som.\nDetalhes: " +
					e.getMessage()); // Mostra a mensagem do erro, para que se perceba qual é o ficheiro em falta
		}
		catch (IllegalStateException e) // estado ilegal (relacionado ao sequenciador de Midis)
		{
			// não faz nada por agora, só passa à frente
		}
	    catch (UnsupportedAudioFileException e) //ficheiro audio não suportado (classe AudioPlayer)
		{
	        System.out.println("Ficheiro audio não suportado.");
	        e.printStackTrace();
	    } catch (LineUnavailableException e) // linha de audio indisponível (classe AudioPlayer)
		{
	        System.out.println("Sem linha disponível para tocar o audio.");
	        e.printStackTrace();
	    }
		catch (NoSuchElementException e)
		{
			// System.out.println("Sem linha disponível para tocar o audio.");
	        // e.printStackTrace();
		}
		catch (IOException e) // erro I/O (classe AudioPlayer)
		{
	        System.out.println("Erro ao tocar o audio.");
	        e.printStackTrace();
	    }
		catch (Exception e) // Outros erros não previstos acima
		{
			e.printStackTrace();
	        System.out.println("Ocorreu um erro imprevisto. Finalizando programa..."); // imprime mensagem de despedida
			
	        if (midiSequencer != null) midiSequencer.stopSequencer(); // Desliga a música, se o sequenciador existir
	        if (sc != null) sc.close(); // Fecha o scanner, se não for nulo
			
	        System.exit(0); // Sai do sistema
		}
		
	}
	
	/**
	 * Testa os inteiros inseridos no Scanner
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
	 * @return o inteiro inserido pelo utilizador, se válido
	 */
	public static int tryScannerIntFromNextLine (Scanner sc)
	{
	
		int nInt = 0; // inicializa a variável que guarda o inteiro a devolver
		
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
	 * Testa a String inserida no Scanner, para ver se é vazia ou só com espaços
	 * 
	 * @param sc
	 * 			o scanner que estamos a usar para receber o input
	 * @return - a string inserida pelo utilizador, se válida
	 */
	public static String tryScannerNextLine (Scanner sc)
	{
		String sString = "";
		do
		{
			try 
			{
				sString = sc.nextLine(); // Tenta atribuir o valor do scanner à String
				
				if (sString.trim().isEmpty()) // Se a tring estiver vazia
				{
					System.out.println("O valor inserido estava vazio, ou só continha espaços. Por favor digite outra vez.");
				}
				else
				{
					break;
				}					
					
			}
			catch (Exception e)
			{// quando n é uma String válida
				errorHandler(e, sc, null); // Trata o erro
			}
		} while (true);
		
		return sString;
	}
	
	/**
	 * Valida o número da escolha inicial (máximo do random)
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
				System.out.println("Por favor escolha um número entre 1 e 20");

			}
		} while (true);
		
		return num;
	}
	
	/**
	 * Valida opções do menu
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
				System.out.println("Opção inválida. Por favor escolha uma opção entre 1 e 3.");

			}
		} while (true);
		
		return option;
	}
	
}
