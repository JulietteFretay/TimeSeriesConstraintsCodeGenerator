package model.generator;

import java.util.Collections;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
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

		boolean isFirstIf = true;

		generateCodeBuffer.append(this.indentation+"//Code timeSerie results \n");
		for(InstructionTable instruction : this.decorationTable.getInstructionsTable()){

			if (isFirstIf) {
				generateCodeBuffer.append(this.indentation+"\tif(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
				isFirstIf = false;
			} else {
				generateCodeBuffer.append(this.indentation+"\telse if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
			}
			if(instruction.getGuards() != null){
				for(Guard guard : instruction.getGuards()){
					if(guard.getUseOther() != null && guard.getUseOther()){
						generateCodeBuffer.append(this.indentation+"\t\tif(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
						if(guard.getAddValue() != null){
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
						}else{
							generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentValueIndex"+guard.getIndexOther()+")); \n");
						}
						generateCodeBuffer.append(this.indentation+"\t\t} \n");

					}else if(guard.getFunction() != null && guard.getFunction()){
						if(guard.getValue().equals("phi")){
							System.out.println(guard.getFunparam());
						}else{
							if(guard.getAddValue() != null){
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)"+guard.getAddValue()+"); \n");
							}else{
								generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"(feature)); \n");
							}
						}
					}
				}
			}
			generateCodeBuffer.append(this.indentation+"\t} \n");
		}

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
