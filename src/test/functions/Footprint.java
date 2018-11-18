package test.functions;

public class Footprint {

	String name;
	int typeCalculPi;
	int typeCalculC;
	
	public Footprint(String name, int typeCalculPi, int typeCalculC) {
		
		this.name = name;
		this.typeCalculPi = typeCalculPi;
		this.typeCalculC = typeCalculC;
	}

	public String getName() {
		return name;
	}

	public int getTypeCalculPi() {
		return typeCalculPi;
	}

	public int getTypeCalculC() {
		return typeCalculC;
	}
	
	public int calculPi(int valPi, int valC) {
		
		switch(this.typeCalculPi) {
		case 0:
			return 0;
		case 1:
			return -1;
		case 2:
			return valC+1;
		case 3:
			return valC;
		default:
			return 0;
		}
	}
	
	public int calculC(int valC) {
		
		switch(this.typeCalculC) {
		case 0:
			return valC;
		case 1:
			return valC+1;
		default:
			return 0;
		}
	}
}
