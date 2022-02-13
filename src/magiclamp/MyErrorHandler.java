package magiclamp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
			System.out.println("Opção inválida. Por favor escolha um número."); // imprime mensagem de erro
			//sc.next(); // limpa o scanner
		}
		catch (NumberFormatException e)
		{
			System.out.println("Opção inválida. Por favor escolha um número."); // imprime mensagem de erro
			//sc.next(); // limpa o scanner
		}
		catch (IllegalArgumentException e) // quando apanha o zero na escolha do random
		{
			System.out.println("Opção inválida. Por favor escolha um número maior que zero."); // imprime mensagem de erro
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Ficheiro audio não encontrado, executando sem som.\nDetalhes: " +
					e.getMessage());
		}
		catch (IllegalStateException e)
		{
			// não faz nada, só passa à frente
		}
	    catch (UnsupportedAudioFileException ex)
		{
	        System.out.println("Ficheiro audio não suportado.");
	        ex.printStackTrace();
	    } catch (LineUnavailableException ex)
		{
	        System.out.println("Sem linha disponível para tocar o audio.");
	        ex.printStackTrace();
	    } catch (IOException ex) 
		{
	        System.out.println("Erro ao tocar o audio.");
	        ex.printStackTrace();
	    }
		catch (Exception e)
		{
			e.printStackTrace();
	        System.out.println("Ocorreu um erro imprevisto. Finalizando programa..."); // imprime mensagem de despedida
			
	        if (midiSequencer != null) midiSequencer.stopSequencer(); // Desliga a música, se o sequenciador existir
	        if (sc != null) sc.close(); // Fecha o scanner, se não for nulo
			
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
			catch (Exception e1) {
				errorHandler(e1, sc, null); // mostra o erro
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
		String sString = "";
		do
		{
			try 
			{
				sString = sc.nextLine(); // Tenta atribuir o valor do scanner à String
				
				if (sString.trim().isEmpty())
				{
					System.out.println("O valor inserido estava vazio, ou só continha espaços. Por favor digite outra vez.");
					//sc.next(); // limpa o scanner
				}
				else
				{
					break;
				}					
					
			}
			catch (InputMismatchException e) // quando n é uma String válida
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
	 * @param sc - O scanner ativo na sessão
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
	
}
