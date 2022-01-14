package lampada;

public class Lampada {

	private int numGenios;
	private int numInicializacoes;
	private int numEsfregadelas = 0;
	
	public Lampada(int numGenios) {
		super();
		this.numGenios = numGenios;
	}


	public int getNumGenios() {
		return numGenios;
	}

	public void setNumGenios(int numGenios) {
		this.numGenios = numGenios;
	}

	public int getNumInicializacoes() {
		return numInicializacoes;
	}

	public void setNumInicializacoes(int numInicializacoes) {
		this.numInicializacoes = numInicializacoes;
	}

	public int getNumEsfregadelas() {
		return numEsfregadelas;
	}

	public void setNumEsfregadelas(int numEsfregadelas) {
		this.numEsfregadelas = this.numEsfregadelas + numEsfregadelas;
	}

	
}
