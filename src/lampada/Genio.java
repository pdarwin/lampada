package lampada;

public abstract class Genio {

	private int numDesejos;

	public Genio(int numDesejos) {
		super();
		this.numDesejos = numDesejos;
	}

	public int getNumDesejos() {
		return numDesejos;
	}

	public void setNumDesejos(int numDesejos) {
		this.numDesejos = numDesejos;
	}

	public boolean realizaDesejo (){
		
		boolean resultado = true;
		
		return resultado;
	}

}
