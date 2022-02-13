package magiclamp;

import java.util.Scanner;

/**
 * Classe da l�mpada m�gica
 * @author P. Perneta e J. Rocha
 * 
 */
public class MagicLamp {

	/** N�mero m�ximo de g�nios dispon�veis */
	private int limGenies;
	
	/** N�mero atual de g�nios dispon�veis */
	private int numGenies;

	/** N�mero de esfregadelas desde o �ltimo carregamento */
	private int rubs;

	/** N�mero de recargas (dem�nios consumidos) */
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
	 * @return um g�nio ou dem�nio.
	 */
	public Genie rub(Scanner sc) {
		
		/* D� a informa��o de quantas vezes esfregou a l�mpada, e pergunta o n.� de desejos a realizar */ 
		System.out.print("Est� a esfregar a l�mpada " + rubs + 
				" vezes. Quantos desejos pretende realizar?");
		
		/* Vai buscar o n.+ de desejos */
		int numWishes = MyErrorHandler.tryScannerIntFromNextLine(sc);
		
		if (numGenies > 0) // se existirem g�nios
		{
			numGenies -= 1; // remove um g�nio
			
			/* Condi��o de sa�da do g�nio mal humorado: "Sempre que a l�mpada for esfregada 
			 * um par de vezes, sem contar a atual" - Ou seja, sempre que seja par ou 
			 * = 1, sai bem humorado
			 */
			
			if ((rubs % 2 == 0) || (rubs == 1))
			{
				return new NiceGenie(numWishes); //retorna um g�nio bom, com o n� de desejos escolhido
			}
			else
			{
				return new BadGenie(); //Sen�o, retorna um g�nio mau
			}
			
		}
		else
		{
			return new Demon(numWishes); //chama o dem�nio, com o n� de desejos escolhido
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
		
		if (!demon.isRecycled()) //se o dem�nio n�o foi reciclado
		{
			demon.recycle(); //recicla o dem�nio
			rubs = 0; // faz reset ao n.� de esfregadelas
			numGenies = limGenies; // faz reset ao n.� de g�nios dispon�veis, pelo m�ximo atribu�do no in�cio
			demons++; // aumenta o n� de dem�nios consumidos (= recargas da l�mpada)
		}
	}
	
	

	/**
	 * Obt�m quantas vezes a l�mpada j� foi esfregada
	 * 
	 * @return quantas vezes foi esfregada desde a �ltima recarga.
	 */
	public int getRubs() {
		return rubs;
	}

	/**
	 * Assigna um valor ao n� de vezes que a l�mpada foi esfregada
	 * 
	 * @param aRubs define o n�mero de esfregadelas
	 */
	public void setRubs(int aRubs) {
		this.rubs = aRubs;
	}
	

	/**
	 * Obt�m o n� de recargas / dem�nios consumidos
	 * 
	 * @return n�mero de regarcas / dem�nios consumidos
	 */
	public int getDemons() {
		return demons;
	}

	/**
	 * Obt�m o n.� de g�niso dispon�veis na l�mpada
	 * 
	 * @return n�mero de g�nios dispon�veis na l�mpada
	 */
	public int getNumGenies() {
		return numGenies;
	}
	
	/**
	 * Obt�m o m�ximo de g�niso dispon�veis na l�mpada
	 * 
	 * @return n.� m�ximo de g�nios dispon�veis na l�mpada
	 */
	public int getLimGenies() {
		return limGenies;
	}
	
}
