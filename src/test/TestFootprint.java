package test;

public class TestFootprint {
	
	public static void demarcation() {
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
	}

	public static void main(String[] args) {
		
		int[] serie = new int[] {4,4,2,2,3,5,5,6,3,1,1,2,2,2,2,2,2,1};
		
		//Bump_on_decreasing_sequence
		System.out.println("Test : Bump on decreasing sequence");
		System.out.println();
		FOOTPRINT_BUMP_ON_DECREASING_SEQUENCE bump_on_decreasing_sequence = new FOOTPRINT_BUMP_ON_DECREASING_SEQUENCE();
		bump_on_decreasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Decreasing_sequence
		System.out.println("Test : Decreasing sequence");
		System.out.println();
		FOOTPRINT_DECREASING_SEQUENCE decreasing_sequence = new FOOTPRINT_DECREASING_SEQUENCE();
		decreasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Decreasing_terrace
		System.out.println("Test : Decreasing terrace");
		System.out.println();
		FOOTPRINT_DECREASING_TERRACE decreasing_terrace = new FOOTPRINT_DECREASING_TERRACE();
		decreasing_terrace.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Decreasing
		System.out.println("Test : Decreasing");
		System.out.println();
		FOOTPRINT_DECREASING decreasing = new FOOTPRINT_DECREASING();
		decreasing.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Dip_on_increasing_sequence
		System.out.println("Test : Dip on increasing sequence");
		System.out.println();
		FOOTPRINT_DIP_ON_INCREASING_SEQUENCE dip_on_increasing_sequence = new FOOTPRINT_DIP_ON_INCREASING_SEQUENCE();
		dip_on_increasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Gorge
		System.out.println("Test : Gorge");
		System.out.println();
		FOOTPRINT_GORGE gorge = new FOOTPRINT_GORGE();
		gorge.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Increasing_sequence
		System.out.println("Test : Increasing sequence");
		System.out.println();
		FOOTPRINT_INCREASING_SEQUENCE increasing_sequence = new FOOTPRINT_INCREASING_SEQUENCE();
		increasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Increasing_terrace
		System.out.println("Test : Increasing terrace");
		System.out.println();
		FOOTPRINT_INCREASING_TERRACE increasing_terrace = new FOOTPRINT_INCREASING_TERRACE();
		increasing_terrace.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Increasing
		System.out.println("Test : Increasing");
		System.out.println();
		FOOTPRINT_INCREASING increasing = new FOOTPRINT_INCREASING();
		increasing.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Inflexion
		System.out.println("Test : Inflexion");
		System.out.println();
		FOOTPRINT_INFLEXION inflexion = new FOOTPRINT_INFLEXION();
		inflexion.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Peak
		System.out.println("Test : Peak");
		System.out.println();
		FOOTPRINT_PEAK peak = new FOOTPRINT_PEAK();
		peak.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Plain
		System.out.println("Test : Plain");
		System.out.println();
		FOOTPRINT_PLAIN plain = new FOOTPRINT_PLAIN();
		plain.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Plateau
		System.out.println("Test : Plateau");
		System.out.println();
		FOOTPRINT_PLATEAU plateau = new FOOTPRINT_PLATEAU();
		plateau.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Proper_plain
		System.out.println("Test : Proper plain");
		System.out.println();
		FOOTPRINT_PROPER_PLAIN proper_plain = new FOOTPRINT_PROPER_PLAIN();
		proper_plain.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Proper_plateau
		System.out.println("Test : Proper plateau");
		System.out.println();
		FOOTPRINT_PROPER_PLATEAU proper_plateau = new FOOTPRINT_PROPER_PLATEAU();
		proper_plateau.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Steady_sequence
		System.out.println("Test : Steady sequence");
		System.out.println();
		FOOTPRINT_STEADY_SEQUENCE steady_sequence = new FOOTPRINT_STEADY_SEQUENCE();
		steady_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Steady
		System.out.println("Test : Steady");
		System.out.println();
		FOOTPRINT_STEADY steady = new FOOTPRINT_STEADY();
		steady.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Strictly_decreasing_sequence
		System.out.println("Test : Strictly decreasing sequence");
		System.out.println();
		FOOTPRINT_STRICTLY_DECREASING_SEQUENCE strictly_decreasing_sequence = new FOOTPRINT_STRICTLY_DECREASING_SEQUENCE();
		strictly_decreasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Strictly_increasing_sequence
		System.out.println("Test : Strictly increasing sequence");
		System.out.println();
		FOOTPRINT_STRICTLY_INCREASING_SEQUENCE strictly_increasing_sequence = new FOOTPRINT_STRICTLY_INCREASING_SEQUENCE();
		strictly_increasing_sequence.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Summit
		System.out.println("Test : Summit");
		System.out.println();
		FOOTPRINT_SUMMIT summit = new FOOTPRINT_SUMMIT();
		summit.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Valley
		System.out.println("Test : Valley");
		System.out.println();
		FOOTPRINT_VALLEY valley = new FOOTPRINT_VALLEY();
		valley.getResultForATimeSerie(serie,null,0,0);
		
		demarcation();
		
		//Zigzag
		System.out.println("Test : Zigzag");
		System.out.println();
		FOOTPRINT_ZIGZAG zigzag = new FOOTPRINT_ZIGZAG();
		zigzag.getResultForATimeSerie(serie,null,0,0);
	}
}
