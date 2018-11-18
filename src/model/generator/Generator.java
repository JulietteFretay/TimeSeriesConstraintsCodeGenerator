package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.seedTemplate.SeedTemplate;

public class Generator {
	private StringBuffer generateCodeBuffer;
	private GeneratorSeedTemplate generatorSeedTemplate;

	public Generator(DecorationTable decorationTable, SeedTemplate seedTemplate){
		generateCodeBuffer = new StringBuffer();
		
		generatorSeedTemplate = new GeneratorSeedTemplate(seedTemplate);
		//Class
		generateCodeBuffer.append("public class generateCode { \n");
		
		//Variables
		generateCodeBuffer.append("\tprivate int[] timeSerie; \n");
		generateCodeBuffer.append("\tprivate HashMap<String, ArrayList<Integer>> result; \n");
		generateCodeBuffer.append("\tprivate String  currentState; \n");
		generateCodeBuffer.append("\tprivate int currentIndex; \n");
		generateCodeBuffer.append("\tprivate String[] timeSerieSigns; \n");
		generateCodeBuffer.append("\tprivate String[] timeSerieStates; \n");

		//Get Result 
		generateCodeBuffer.append("\tpublic HashMap<String, ArrayList<Integer>> getResultForATimeSerie(int[] timeSerie) {\n");		
		
		generateCodeBuffer.append("\t\tthis.result = new HashMap<String, ArrayList<Integer>>();\n");	
		generateCodeBuffer.append("\t\tthis.timeSerie = timeSerie;\n");	
		generateCodeBuffer.append("\t\tthis.currentState = \"" + seedTemplate.getStartingState() + "\";\n");	
		//generateCodeBuffer.append("\t\tthis.timeSerieSigns = \"" + TimeSerieToSigns.getSigns(timeSerie) + "\";\n");	
		
		generateCodeBuffer.append("\t\twhile(this.currentIndex < timeSerieSigns.length - 1) {\n");
		generatorSeedTemplate.setIndentation("\t\t\t");
		generatorSeedTemplate.append(generateCodeBuffer);
		generateCodeBuffer.append("\t\t}\n");
		
		generateCodeBuffer.append("\t\treturn this.result;\n");	
		generateCodeBuffer.append("\t}\n");		

		generateCodeBuffer.append("}");
	}
	
	public void seeCodeInConsole(){
		System.out.println(generateCodeBuffer);		
	}
	
	public void saveCodeInFile(String fileName){
		
	}
}
