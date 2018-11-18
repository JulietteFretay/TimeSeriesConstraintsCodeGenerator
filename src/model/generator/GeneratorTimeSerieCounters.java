package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieCounters {
	private SeedTemplate seedTemplate;
	private String indentation;
	private DecorationTable decorationTable;

	public GeneratorTimeSerieCounters(SeedTemplate seedTemplate, DecorationTable decorationTable) {
		this.seedTemplate = seedTemplate;
		this.decorationTable = decorationTable;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie counters \n");
		for(InstructionTable instruction : this.decorationTable.getInstructionsTable()){
			generateCodeBuffer.append(this.indentation+"if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
			for(Guard guard : instruction.getGuards()){
				generateCodeBuffer.append(this.indentation+"this.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex,"+guard.getValue()+"); \n");
			}
			generateCodeBuffer.append(this.indentation+"} \n");
		}
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
