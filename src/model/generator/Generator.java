package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.InstructionFinal;
import model.parameters.decorationTable.InstructionInit;
import model.parameters.seedTemplate.SeedTemplate;

public class Generator {
	private StringBuffer generateCodeBuffer;
	private GeneratorTimeSerieSigns generatorTimeSerieSigns;
	private GeneratorTimeSerieStatesAndLetters generatorTimeSerieStates;
	private GeneratorTimeSerieCounters generatorTimeSerieCounters;
	private GeneratorTimeSerieResults generatorTimeSerieResults;

	public Generator(DecorationTable decorationTable, SeedTemplate seedTemplate){
		generateCodeBuffer = new StringBuffer();
		
		generatorTimeSerieSigns = new GeneratorTimeSerieSigns(seedTemplate);
		generatorTimeSerieStates = new GeneratorTimeSerieStatesAndLetters(seedTemplate);
		generatorTimeSerieCounters = new GeneratorTimeSerieCounters(seedTemplate,decorationTable);
		generatorTimeSerieResults = new GeneratorTimeSerieResults(seedTemplate,decorationTable);
		//Class
		generateCodeBuffer.append("import java.util.ArrayList; \n");
		generateCodeBuffer.append("import java.util.HashMap; \n");
		
		generateCodeBuffer.append("public class GeneratedCode { \n");
		
		//Variables
		generateCodeBuffer.append("\tprivate int[] timeSerie; \n");
		generateCodeBuffer.append("\tprivate HashMap<String, ArrayList<Integer>> timeSerieResults; \n");
		generateCodeBuffer.append("\tprivate String  currentState; \n");
		generateCodeBuffer.append("\tprivate int currentSignIndex; \n");
		generateCodeBuffer.append("\tprivate int currentValueIndex; \n");
		generateCodeBuffer.append("\tprivate String[] timeSerieSigns; \n");
		generateCodeBuffer.append("\tprivate String[] timeSerieStates; \n");
		generateCodeBuffer.append("\tprivate String[] timeSerieLetters; \n");
		generateCodeBuffer.append("\tprivate HashMap<String, ArrayList<Integer>> timeSerieCounters; \n");
		generateCodeBuffer.append("\tprivate HashMap<String, Integer> currentCounters; \n");

		//Get Result 
		generateCodeBuffer.append("\tpublic void getResultForATimeSerie(int[] timeSerie) {\n");		
		
		generateCodeBuffer.append("\t\tthis.timeSerieResults = new HashMap<String, ArrayList<Integer>>();\n");	
		generateCodeBuffer.append("\t\tthis.timeSerie = timeSerie;\n");	
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie Values : \"+this.listToString(timeSerie));\n");	
		generateCodeBuffer.append("\t\tthis.currentState = \"" + seedTemplate.getStartingState() + "\";\n");
		generateCodeBuffer.append("\t\tint nbElements = timeSerie.length;\n");
		generateCodeBuffer.append("\t\tcurrentSignIndex = 0;\n");
		generateCodeBuffer.append("\t\tthis.timeSerieStates = new String[nbElements];\n");
		generateCodeBuffer.append("\t\tthis.timeSerieStates[0] = \"" + seedTemplate.getStartingState() + "\";\n");
		generateCodeBuffer.append("\t\tthis.timeSerieLetters = new String[nbElements-1];\n");		
		generateCodeBuffer.append("\t\tthis.timeSerieCounters = new HashMap<String, ArrayList<Integer>>();\n");		
		generateCodeBuffer.append("\t\tthis.currentCounters = new HashMap<String, Integer>() ;\n");	
		for(InstructionFinal instruction : decorationTable.getInstructionsFinal()){
			generateCodeBuffer.append("\t\tArrayList<Integer> resultList = new ArrayList<Integer>();\n");
			generateCodeBuffer.append("\t\tfor(int i = 0; i < timeSerie.length-1; i++) {\n");
			generateCodeBuffer.append("\t\t\tresultList.add(new Integer(0));\n");
			generateCodeBuffer.append("\t\t}\n");
			generateCodeBuffer.append("\t\tthis.timeSerieResults.put(\""+instruction.getVar()+"\",resultList);\n");	
		}
		for(InstructionInit instruction : decorationTable.getInstructionsInit()){
			generateCodeBuffer.append("\t\tArrayList<Integer> counterList = new ArrayList<Integer>();\n");
			generateCodeBuffer.append("\t\tcounterList.add(new Integer("+instruction.getInit()+"));\n");
			generateCodeBuffer.append("\t\tfor(int i = 0; i < timeSerie.length-2; i++) {\n");
			generateCodeBuffer.append("\t\t\tcounterList.add(new Integer(0));\n");
			generateCodeBuffer.append("\t\t}\n");
			generateCodeBuffer.append("\t\tthis.timeSerieCounters.put(\""+instruction.getVar()+"\",counterList);\n");	
			generateCodeBuffer.append("\t\tthis.currentCounters.put(\""+instruction.getVar()+"\",0);\n");	
		}
		
		//generateCodeBuffer.append("\t\twhile(this.currentSignIndex < timeSerieSigns.length - 1) {\n");
		generatorTimeSerieSigns.setIndentation("\t\t");
		generatorTimeSerieSigns.append(generateCodeBuffer);
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie Signs : \"+this.listToString(timeSerieSigns));\n");	
		//generateCodeBuffer.append("\t\t}\n");
		
		generatorTimeSerieStates.setIndentation("\t\t");
		generateCodeBuffer.append("\t\tthis.currentValueIndex = 1;\n");	
		generateCodeBuffer.append("\t\twhile(this.currentValueIndex < this.timeSerie.length){\n");	
		generatorTimeSerieStates.append(generateCodeBuffer);
		generateCodeBuffer.append("\t\t\tthis.currentValueIndex ++;\n");	
		generateCodeBuffer.append("\t\t\tthis.currentSignIndex ++;\n");
		generateCodeBuffer.append("\t\t}\n");	
		generateCodeBuffer.append("\t\tthis.currentValueIndex = 0;\n");
		generateCodeBuffer.append("\t\tthis.currentSignIndex = 0;\n");
		generateCodeBuffer.append("\t\tthis.currentState =\"" + seedTemplate.getStartingState() + "\";\n");
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie States : \"+this.listToString(timeSerieStates));\n");	
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie Letters : \"+this.listToString(timeSerieLetters));\n");	

		generatorTimeSerieCounters.setIndentation("\t\t");
		generateCodeBuffer.append("\t\twhile(this.currentSignIndex < this.timeSerie.length-1){\n");	
		generatorTimeSerieCounters.append(generateCodeBuffer);
		generateCodeBuffer.append("\t\t\tthis.currentValueIndex ++;\n");	
		generateCodeBuffer.append("\t\t\tthis.currentSignIndex ++;\n");
		generateCodeBuffer.append("\t\t}\n");	
		generateCodeBuffer.append("\t\tthis.currentValueIndex = this.timeSerie.length-2;\n");
		generateCodeBuffer.append("\t\tthis.currentSignIndex = this.timeSerie.length-2;\n");
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie Counters : \"+this.timeSerieCounters);\n");	

		generatorTimeSerieResults.setIndentation("\t\t");
		generateCodeBuffer.append("\t\twhile(this.currentSignIndex >=0){\n");	
		generatorTimeSerieResults.append(generateCodeBuffer);
		generateCodeBuffer.append("\t\t\tthis.currentValueIndex --;\n");	
		generateCodeBuffer.append("\t\t\tthis.currentSignIndex --;\n");
		generateCodeBuffer.append("\t\t}\n");	
		
		generateCodeBuffer.append("\t\tSystem.out.println(\"TimeSerie Results : \"+this.timeSerieResults);\n");	

		
		generateCodeBuffer.append("\t}\n");		
		GeneratorListToString.append(generateCodeBuffer);
		generateCodeBuffer.append("}");
		
	}
	
	public void seeCodeInConsole(){
		System.out.println(generateCodeBuffer);		
	}
	
	public void saveCodeInFile(String fileName){
		
	}
}
