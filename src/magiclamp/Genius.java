package magiclamp;

public abstract class Genius {

	private int numWishes;

	public Genius(int aNumWishes) {
		super();
		this.numWishes = aNumWishes;
	}

	public int getNumDesejos() {
		return numWishes;
	}

	public void setNumDesejos(int aNumWishes) {
		this.numWishes = aNumWishes;
	}

	public boolean makeWish (){
		
		boolean result = true;
		
		return result;
	}

}
