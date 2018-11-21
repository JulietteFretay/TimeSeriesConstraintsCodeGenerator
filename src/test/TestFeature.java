package test;

public class TestFeature {
	
	public static void demarcation_pattern() {
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
	}
	
	public static void demarcation_feature() {
		
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
	}

	public static void main(String[] args) {
		
		//Width_DecreasingSequence
		System.out.println("Test : Width DecreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,2,0,0]");
		System.out.println();
		FEATURE_DECREASING_SEQUENCE width_decreasingSequence = new FEATURE_DECREASING_SEQUENCE();
		width_decreasingSequence.getResultForATimeSerie(new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_DecreasingTerrace	
		System.out.println("Test : Width DecreasingTerrace / Résultat attendu = [0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0]");
		System.out.println();
		FEATURE_DECREASING_TERRACE width_decreasingTerrace = new FEATURE_DECREASING_TERRACE();
		width_decreasingTerrace.getResultForATimeSerie(new int[] {6,4,4,4,5,2,2,1,3,3,5,4,4,3,3,3},"FEATURE_WIDTH",0,0);
		
		//Width_Gorge
		System.out.println("Test : Width Gorge / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,0,0,2,0,1,0]");
		System.out.println();
		FEATURE_GORGE width_gorge = new FEATURE_GORGE();
		width_gorge.getResultForATimeSerie(new int[] {1,7,3,4,4,5,5,4,2,2,6,5,4,6,5,7},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_IncreasingSequence
		System.out.println("Test : Width IncreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,2,0,0]");
		System.out.println();
		FEATURE_INCREASING_SEQUENCE width_increasingSequence = new FEATURE_INCREASING_SEQUENCE();
		width_increasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,3,3,4,6,6,3,1,3,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_IncreasingTerrace
		System.out.println("Test : Width IncreasingTerrace / Résultat attendu = [0,0,0,0,0,0,2,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_INCREASING_TERRACE width_increasingTerrace = new FEATURE_INCREASING_TERRACE();
		width_increasingTerrace.getResultForATimeSerie(new int[] {1,3,3,3,2,5,5,6,4,4,2,3,3,3,4,4},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Inflexion
		System.out.println("Test : Width Inflexion / Résultat attendu = [0,0,0,3,0,0,3,1,1,1,1,1,0,2,0,0]");
		System.out.println();
		FEATURE_INFLEXION width_inflexion = new FEATURE_INFLEXION();
		width_inflexion.getResultForATimeSerie(new int[] {1,2,6,6,4,4,3,5,2,5,1,5,3,3,4,4},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Peak
		System.out.println("Test : Width Peak / Résultat attendu = [0,0,0,0,0,2,0,0,0,0,3,0,0,0,3,0]");
		System.out.println();
		FEATURE_PEAK width_peak = new FEATURE_PEAK();
		width_peak.getResultForATimeSerie(new int[] {7,5,5,1,4,5,2,2,3,5,6,2,3,3,3,1},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Plain
		System.out.println("Test : Width Plain / Résultat attendu = [0,0,0,1,0,0,0,1,0,0,0,0,2,0,0,0]");
		System.out.println();
		FEATURE_PLAIN width_plain = new FEATURE_PLAIN();
		width_plain.getResultForATimeSerie(new int[] {2,3,6,5,7,6,6,4,5,5,4,3,3,6,6,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Plateau
		System.out.println("Test : Width Plateau / Résultat attendu = [0,0,0,0,0,0,4,0,0,0,3,0,0,0,0,0]");
		System.out.println();
		FEATURE_PLATEAU width_plateau = new FEATURE_PLATEAU();
		width_plateau.getResultForATimeSerie(new int[] {1,3,3,5,5,5,5,2,4,4,4,3,3,1,5,5},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_ProperPlain
		System.out.println("Test : Width ProperPlain / Résultat attendu = [0,0,0,2,0,0,0,0,2,0,0,0,0,0,3,0]");
		System.out.println();
		FEATURE_PROPER_PLAIN width_properPlain = new FEATURE_PROPER_PLAIN();
		width_properPlain.getResultForATimeSerie(new int[] {2,7,5,5,6,3,7,4,4,5,6,5,3,3,3,5},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_ProperPlateau
		System.out.println("Test : Width ProperPlateau / Résultat attendu = [0,0,0,2,0,0,0,0,2,0,0,0,0,0,3,0]");
		System.out.println();
		FEATURE_PROPER_PLATEAU width_properPlateau = new FEATURE_PROPER_PLATEAU();
		width_properPlateau.getResultForATimeSerie(new int[] {7,1,3,3,2,5,1,4,4,3,2,3,5,5,5,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_SteadySequence
		System.out.println("Test : Width SteadySequence / Résultat attendu = [0,2,0,0,3,0,0,0,2,0,2,0,0,0,2,0]");
		System.out.println();
		FEATURE_STEADY_SEQUENCE width_steadySequence = new FEATURE_STEADY_SEQUENCE();
		width_steadySequence.getResultForATimeSerie(new int[] {3,1,1,4,5,5,5,6,2,2,4,4,3,2,1,1},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_StrictlyDecreasingSequence
		System.out.println("Test : Width StrictlyDecreasingSequence / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,3,0,0,0,2,0]");
		System.out.println();
		FEATURE_STRICTLY_DECREASING_SEQUENCE width_strictlyDecreasingSequence = new FEATURE_STRICTLY_DECREASING_SEQUENCE();
		width_strictlyDecreasingSequence.getResultForATimeSerie(new int[] {4,4,6,4,1,1,3,4,4,6,6,5,2,2,4,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_StrictlyIncreasingSequence
		System.out.println("Test : Width StrictlyIncreasingSequence / Résultat attendu = [0,2,0,0,0,0,5,0,0,0,0,0,0,3,0,0]");
		System.out.println();
		FEATURE_STRICTLY_INCREASING_SEQUENCE width_strictlyIncreasingSequence = new FEATURE_STRICTLY_INCREASING_SEQUENCE();
		width_strictlyIncreasingSequence.getResultForATimeSerie(new int[] {4,3,5,5,2,1,1,2,3,4,6,6,3,1,2,3},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Summit
		System.out.println("Test : Width Summit / Résultat attendu = [0,0,3,0,0,0,0,0,0,0,0,0,2,0,1,0]");
		System.out.println();
		FEATURE_SUMMIT width_summit = new FEATURE_SUMMIT();
		width_summit.getResultForATimeSerie(new int[] {7,1,5,4,4,3,3,4,6,6,2,3,4,2,3,1},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Valley
		System.out.println("Test : Width Valley / Résultat attendu = [0,0,0,0,2,0,0,0,0,0,4,0,0,0,3,0]");
		System.out.println();
		FEATURE_VALLEY width_valley = new FEATURE_VALLEY();
		width_valley.getResultForATimeSerie(new int[] {1,3,7,4,3,6,6,5,3,3,2,6,5,5,5,7},"FEATURE_WIDTH",0,0);
		
		demarcation_pattern();
		
		//Width_Zigzag
		System.out.println("Test : Width Zigzag / Résultat attendu = [0,0,3,0,0,0,2,0,0,0,6,0,0,0,0,0]");
		System.out.println();
		FEATURE_ZIGZAG width_zigzag = new FEATURE_ZIGZAG();
		width_zigzag.getResultForATimeSerie(new int[] {4,1,3,1,4,6,1,5,5,2,7,2,3,1,6,1},"FEATURE_WIDTH",0,0);
		
		demarcation_feature();
	}
}
