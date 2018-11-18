package calculator;

public class SignsCalculator {
	
	int[] timeSerie;

	public SignsCalculator(int[] timeSerie){
		
		this.timeSerie = timeSerie;
	}
	
	public String[] getSigns(int[] timeSerie) {
		
		int nbElements = timeSerie.length;
		String[] tabSignes = new String[nbElements - 1];
		
		for (int i = 0; i < nbElements - 1; i++) {
			if (timeSerie[i] == timeSerie[i+1]) {
				tabSignes[i] = "=";
			} else if (timeSerie[i] < timeSerie[i+1]) {
				tabSignes[i] = "<";
			} else {
				tabSignes[i] = ">";
			}
		}
		return tabSignes;
	}
}
