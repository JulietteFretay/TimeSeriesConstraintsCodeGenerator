package test.functions;

public class Test {
	
	public static String[] transfoSignes(int[] tabEntree) {
		
		int nbElements = tabEntree.length;
		String[] tabSignes = new String[nbElements - 1];
		
		for (int i = 0; i < nbElements - 1; i++) {
			if (tabEntree[i] == tabEntree[i+1]) {
				tabSignes[i] = "=";
			} else if (tabEntree[i] < tabEntree[i+1]) {
				tabSignes[i] = "<";
			} else {
				tabSignes[i] = ">";
			}
		}
		return tabSignes;
	}
	
	public static String[][] transfoStatesLinks(String[] tabSignes, Arc[] tabArcs) {
		
		int nbElements = tabSignes.length;
		String[] tabStates = new String[nbElements + 1];
		tabStates[0] = "s";
		String[] tabLinks = new String[nbElements];
		String[][] tabStatesLinks = new String[2][];
		
		for(int i = 0; i < nbElements; i++) {
			
			for (int j = 0; j < tabArcs.length; j++) {
				if (tabArcs[j].getFrom().equals(tabStates[i]) && tabArcs[j].getSigns().contains(tabSignes[i])) {
					tabStates[i+1] = tabArcs[j].getTo();
					tabLinks[i] = tabArcs[j].getName();
					break;
				}
			}
		}
		
		tabStatesLinks[0] = tabStates;
		tabStatesLinks[1] = tabLinks;
		return tabStatesLinks;
	}
	
	public static int[][] calculCandPi(String[] tabLinks, Footprint[] tabFootprints) {
		
		int nbElements = tabLinks.length;
		int[] tabC = new int[nbElements + 1];
		tabC[0] = 0;
		int[] tabPi = new int[nbElements + 1];
		tabPi[0] = 0;
		int[][] tabCandPi = new int[2][];
		
		for(int i = 0; i < nbElements; i++) {
			
			for (int j = 0; j < tabFootprints.length; j++) {
				if (tabFootprints[j].getName().equals(tabLinks[i])) {
					tabC[i+1] = tabFootprints[j].calculC(tabC[i]);
					tabPi[i+1] = tabFootprints[j].calculPi(tabPi[i], tabC[i]);
					break;
				}
			}
		}
		
		for (int i = tabPi.length-1; i > -1; i--) {
			
			if (tabPi[i] == -1) {
				tabPi[i] = tabPi[i+1];
			}
		}
		
		tabCandPi[0] = tabC;
		tabCandPi[1] = tabPi;
		return tabCandPi;
	}

	public static void main(String[] args) {
		
		Footprint footprint1 = new Footprint("out", 0, 0);
		Footprint footprint2 = new Footprint("out(r)", 0, 0);
		Footprint footprint3 = new Footprint("out(a)", 0, 0);
		Footprint footprint4 = new Footprint("maybe(b)", 1, 0);
		Footprint footprint5 = new Footprint("maybe(a)", 1, 0);
		Footprint footprint6 = new Footprint("found_end", 2, 1);
		Footprint footprint7 = new Footprint("found", 2, 1);
		Footprint footprint8 = new Footprint("in", 3, 0);
		Footprint[] tabFootprints = {footprint1, footprint2, footprint3, footprint4, footprint5, footprint6, footprint7, footprint8};
		
		Arc arc1 = new Arc("s", "s", "geq", "out");
		Arc arc2 = new Arc("s", "r", "lt", "out");
		Arc arc3 = new Arc("r", "t", "gt", "found");
		Arc arc4 = new Arc("r", "r", "leq", "maybe(b)");
		Arc arc5 = new Arc("t", "t", "gt", "in");
		Arc arc6 = new Arc("t", "t", "eq", "maybe(a)");
		Arc arc7 = new Arc("t", "r", "lt", "out(a)");
		Arc[] tabArcs = {arc1, arc2, arc3, arc4, arc5, arc6, arc7};
		
		int[] tabSerie = {4,4,2,2,3,5,5,6,3,1,1,2,2,2,2,2,2,1};		
		String[] tabSigns = transfoSignes(tabSerie);	
		String[][] tabStatesLinks = transfoStatesLinks(tabSigns, tabArcs);
		String[] tabStates = tabStatesLinks[0];
		String[] tabLinks = tabStatesLinks[1];
		int[][] tabCandPi = calculCandPi(tabLinks, tabFootprints);
		int[] tabC = tabCandPi[0];
		int[] tabPi = tabCandPi[1];
		
		for (int i = 0; i < tabSerie.length; i++) {
			System.out.print(tabSerie[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < tabSigns.length; i++) {
			System.out.print(tabSigns[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < tabStates.length; i++) {
			System.out.print(tabStates[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < tabLinks.length; i++) {
			System.out.print(tabLinks[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < tabC.length; i++) {
			System.out.print(tabC[i] + " ");
		}
		System.out.println();
		for (int i = 1; i < tabPi.length; i++) {
			System.out.print(tabPi[i] + " ");
		}
	}
}
