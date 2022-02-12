package magiclamp;

import java.util.Scanner;

/**
 * L�mpada m�gica
 */
public class MagicLamp {

	/** N�mero de g�nios dispon�veis */
	private int limGenies;
	
	/** N�mero de g�nios dispon�veis */
	private int numGenies;

	/** N�mero de esfregadelas desde o �ltimo carregamento. */
	private int rubs;

	/** N�mero de recargas. */
	private int demons;
	
	/**
	 * @param limit
	 *            Quantos g�nios podem sair da l�mpada.
	 */
	public MagicLamp(int aLimit) {
		this.limGenies = aLimit;
		this.numGenies = aLimit;
		this.demons = 0;
	}

	/**
	 * M�todo para esfregar a l�mpada
	 * Esfregamos a l�mpada m�gica para obter um g�nio. S� o n�mero for par sem contar a vez atual, retorna um g�nio mau;
	 * Se o n�mero for maior que o limite, a l�mpada cria um pequeno dem�nio;
	 * Em todas as outras situa��es, retorna um g�nio normal.
	 * 
	 * @param limit
	 *            m�ximo n�mero de desejos que o g�nio pode realizar
	 * 
	 * @return um g�nio ou dem�nio.
	 */
	public Genie rub(Scanner sc) {
		
		System.out.print("Est� a esfregar a l�mpada " + rubs + " vezes. Quantos desejos pretende realizar?");
		
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
	 * Recarrega a l�mpada m�gica colocando nela um dem�nio.
	 * Um dem�nio pode ser usado somente se ainda n�o foi reciclado
	 * 
	 * @param demon
	 *            o dem�nio recicl�vel.
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
	 * @return quantas vezes foi esfregada desde a �ltima recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * @param aRubs define o n�mero de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	

	/**
	 * @return n�mero de dem�nios.
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * @return n�mero de g�nios dispon�veis na l�mpada
	 */
	public int getNumGenies() {
		return numGenies;
	}
	
	/**
	 * @return limite de g�nios dispon�veis na l�mpada
	 */
	public int getLimGenies() {
		return limGenies;
	}



	
}
