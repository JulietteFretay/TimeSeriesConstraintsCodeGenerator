package test;

public class TestFootprint {

	public static void main(String[] args) {
		int[] serie = new int[] {4,4,2,2,3,5,5,6,3,1,1,2,2,2,2,2,2,1};
		
		//Peak
		System.out.println("Test Peak");
		FOOTPRINT_PEAK peak = new FOOTPRINT_PEAK();
		peak.getResultForATimeSerie(serie,null,0);
		
		//Increasing
		System.out.println("\nTest Increasing");
		FOOTPRINT_INCREASING increasing = new FOOTPRINT_INCREASING();
		increasing.getResultForATimeSerie(serie,null,0);

	}

}
