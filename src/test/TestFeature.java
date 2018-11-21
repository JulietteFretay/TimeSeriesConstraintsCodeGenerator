package test;

public class TestFeature {

	public static void main(String[] args) {
		
		int[] serie = new int[] {4,4,2,2,3,5,5,6,3,1,1,2,2,2,2,2,2,1};
		int[] serie2 = new int[] {3,4,2,2,5,6,6,4,4,3,1,1,4,6,4,4};
		int[] serie3 = new int[] {7,5,5,1,4,5,2,2,3,5,6,2,3,3,3,1};
		
		//Min_decreasing
		//System.out.println("Test : Min decreasing");
		//System.out.println();
		//FEATURE_DECREASING min_decreasing = new FEATURE_DECREASING();
		//min_decreasing.getResultForATimeSerie(serie,"FEATURE_MIN",0,0);
		
		//ctr_example(min_decreasing,min_decreasing([[var-3],[var-4],[var-2],[var-2],[var-5],[var-6],[var-6],[var-4],[var-4],[var-3],[var-1],[var-1],[var-4],[var-6],[var-4],[var-4]],[[var-0],[var-2],[var-0],[var-0],[var-0],[var-0],[var-4],[var-0],[var-3],[var-1],[var-0],[var-0],[var-0],[var-4],[var-0],[var-0]],0)).

		//Peak
		System.out.println("Test : Max peak");
		System.out.println();
		FEATURE_PEAK max_peak = new FEATURE_PEAK();
		max_peak.getResultForATimeSerie(serie,"FEATURE_MAX",0,0);
		
		System.out.println("Test : width peak");
		System.out.println();
		FEATURE_PEAK width_peak = new FEATURE_PEAK();
		width_peak.getResultForATimeSerie(serie3,"FEATURE_WIDTH",0,0);
		
		System.out.println("Test : surface peak");
		System.out.println();
		FEATURE_PEAK surface_peak = new FEATURE_PEAK();
		surface_peak.getResultForATimeSerie(serie3,"FEATURE_SURFACE",0,0);

		
		//Decreasing
		System.out.println("Test : Min decreasing");
		System.out.println();
		FEATURE_DECREASING min_decreasing = new FEATURE_DECREASING();
		min_decreasing.getResultForATimeSerie(serie2,"FEATURE_MIN",0,0);
	}
}
