package magiclamp;

import java.util.Scanner;

/**
 * Lâmpada mágica
 */
public class MagicLamp {

	/** Número de génios disponíveis */
	private int limGenies;
	
	/** Número de génios disponíveis */
	private int numGenies;

	/** Número de esfregadelas desde o último carregamento. */
	private int rubs;

	/** Número de recargas. */
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
	 * 
	 * @return um génio ou demónio.
	 */
	public Genie rub(Scanner sc) {
		
		System.out.print("Está a esfregar a lâmpada " + rubs + " vezes. Quantos desejos pretende realizar?");
		
		int numWishes = MyErrorHandler.tryScannerIntFromNextLine(sc);
		
		if (numGenies > 0)
		{
			
			numGenies -= 1;
			if ((rubs % 2 == 0) || (rubs == 1))
			{
				return new NiceGenie(numWishes);
			}
			else
			{
				return new BadGenie();
			}
			
		}
		else
		{
			return new Demon(numWishes);
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
		if (!demon.recycled()) {
			demon.recycle();
			rubs = 0;
			numGenies = limGenies;
			demons++;
		}
	}
	
	

	/**
	 * @return quantas vezes foi esfregada desde a última recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * @param aRubs define o número de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	

	/**
	 * @return número de demónios.
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * @return número de génios disponíveis na lâmpada
	 */
	public int getNumGenies() {
		return numGenies;
	}
	
	/**
	 * @return limite de génios disponíveis na lâmpada
	 */
	public int getLimGenies() {
		return limGenies;
	}



	
}
