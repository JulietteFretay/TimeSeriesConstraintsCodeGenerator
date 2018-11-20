package test;

public class TestFeature {

	public static void main(String[] args) {
		
		int[] serie = new int[] {4,4,2,2,3,5,5,6,3,1,1,2,2,2,2,2,2,1};
		
		//Min_Decreasing
		/*System.out.println("Test Min Decreasing");
		FEATURE_DECREASING fd = new FEATURE_DECREASING();
		fd.getResultForATimeSerie(serie,"FEATURE_MIN",0,0);*/
		/*
		 * ctr_example(min_decreasing,min_decreasing([[var-3],[var-4],[var-2],[var-2],[var-5],[var-6],[var-6],[var-4],[var-4],[var-3],[var-1],[var-1],[var-4],[var-6],[var-4],[var-4]],[[var-0],[var-2],[var-0],[var-0],[var-0],[var-0],[var-4],[var-0],[var-3],[var-1],[var-0],[var-0],[var-0],[var-4],[var-0],[var-0]],0)).
		 */

		// Peak
		System.out.println("Test Max Peak");
		FEATURE_PEAK fp = new FEATURE_PEAK();
		fp.getResultForATimeSerie(serie,"FEATURE_MAX",0,0);

	}
}
