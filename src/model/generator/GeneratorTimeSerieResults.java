package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
import model.parameters.decorationTable.Update;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieResults {
	private SeedTemplate seedTemplate;
	private String indentation;
	private DecorationTable decorationTable;

	public GeneratorTimeSerieResults(SeedTemplate seedTemplate, DecorationTable decorationTable) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
		this.decorationTable = decorationTable;
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie results \n");
		for(InstructionTable instruction : this.decorationTable.getInstructionsTable()){
			generateCodeBuffer.append(this.indentation+"if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
			for(Guard guard : instruction.getGuards()){
				if(guard.getUseOther()){
					generateCodeBuffer.append(this.indentation+"if(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
					if(guard.getAddValue() != null){
						generateCodeBuffer.append(this.indentation+"this.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
					}else{
						generateCodeBuffer.append(this.indentation+"this.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")); \n");
					}
					generateCodeBuffer.append(this.indentation+"} \n");

				}
			}
			generateCodeBuffer.append(this.indentation+"} \n");
		}

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
