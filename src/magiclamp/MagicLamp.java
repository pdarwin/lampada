package magiclamp;

import java.util.Scanner;

/**
 * Classe da lâmpada mágica
 * @author P. Perneta e J. Rocha
 * 
 */
public class MagicLamp {

	/** Número máximo de génios disponíveis */
	private int limGenies;
	
	/** Número atual de génios disponíveis */
	private int numGenies;

	/** Número de esfregadelas desde o último carregamento */
	private int rubs;

	/** Número de recargas (demónios consumidos) */
	private int demons;
	
	/**
	 * @param limit
	 *            Quantos génios podem sair da lâmpada.
	 */
	public MagicLamp(int aLimit) {
		this.limGenies = aLimit;
		this.numGenies = aLimit;
		this.demons = 0;
	}

	/**
	 * Método para esfregar a lâmpada
	 * Esfregamos a lâmpada mágica para obter um génio. Sé o número for par sem contar a vez atual, retorna um génio mau;
	 * Se o número for maior que o limite, a lâmpada cria um pequeno demónio;
	 * Em todas as outras situações, retorna um génio normal.
	 * 
	 * @param limit
	 *            máximo número de desejos que o génio pode realizar
	 * @return um génio ou demónio.
	 */
	public Genie rub(Scanner sc) {
		
		/* Dá a informação de quantas vezes esfregou a lâmpada, e pergunta o n.º de desejos a realizar */ 
		System.out.print("Está a esfregar a lâmpada " + rubs + 
				" vezes. Quantos desejos pretende realizar?");
		
		/* Vai buscar o n.+ de desejos */
		int numWishes = MyErrorHandler.tryScannerIntFromNextLine(sc);
		
		if (numGenies > 0) // se existirem génios
		{
			numGenies -= 1; // remove um génio
			
			/* Condição de saída do génio mal humorado: "Sempre que a lâmpada for esfregada 
			 * um par de vezes, sem contar a atual" - Ou seja, sempre que seja par ou 
			 * = 1, sai bem humorado
			 */
			
			if ((rubs % 2 == 0) || (rubs == 1))
			{
				return new NiceGenie(numWishes); //retorna um génio bom, com o nº de desejos escolhido
			}
			else
			{
				return new BadGenie(); //Senão, retorna um génio mau
			}
			
		}
		else
		{
			return new Demon(numWishes); //chama o demónio, com o nº de desejos escolhido
		}
	}

	
	/**
	 * Recarrega a lâmpada mágica colocando nela um demónio.
	 * Um demónio pode ser usado somente se ainda não foi reciclado
	 * 
	 * @param demon
	 *            o demónio reciclável.
	 */
	public void rechargeLamp(Demon demon) {
		
		if (!demon.isRecycled()) //se o demónio não foi reciclado
		{
			demon.recycle(); //recicla o demónio
			rubs = 0; // faz reset ao n.º de esfregadelas
			numGenies = limGenies; // faz reset ao n.º de génios disponíveis, pelo máximo atribuído no início
			demons++; // aumenta o nº de demónios consumidos (= recargas da lâmpada)
		}
	}
	
	

	/**
	 * Obtém quantas vezes a lâmpada já foi esfregada
	 * 
	 * @return quantas vezes foi esfregada desde a última recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * Assigna um valor ao nº de vezes que a lâmpada foi esfregada
	 * 
	 * @param aRubs define o número de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	

	/**
	 * Obtém o nº de recargas / demónios consumidos
	 * 
	 * @return número de regarcas / demónios consumidos
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * Obtém o n.º de géniso disponíveis na lâmpada
	 * 
	 * @return número de génios disponíveis na lâmpada
	 */
	public int getNumGenies() {
		return numGenies;
	}
	
	/**
	 * Obtém o máximo de géniso disponíveis na lâmpada
	 * 
	 * @return n.º máximo de génios disponíveis na lâmpada
	 */
	public int getLimGenies() {
		return limGenies;
	}
	
}
