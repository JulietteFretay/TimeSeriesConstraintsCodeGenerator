package model.generator;

import model.parameters.decorationTable.DecorationTable;
import model.parameters.decorationTable.Guard;
import model.parameters.decorationTable.InstructionTable;
import model.parameters.decorationTable.Update;
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
		
		boolean isFirstIf = true;
		
		generateCodeBuffer.append(this.indentation+"//Code timeSerie counters \n");
		for(InstructionTable instruction : this.decorationTable.getInstructionsTable()){
			
			if (isFirstIf) {
				generateCodeBuffer.append(this.indentation+"\tif(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
				isFirstIf = false;
			} else {
				generateCodeBuffer.append(this.indentation+"\telse if(this.timeSerieLetters[currentSignIndex].equals( \""+instruction.getStep()+"\")){ \n");
			}
			
			for(Guard guard : instruction.getGuards()){
				if(guard.getUseOther()){
					//generateCodeBuffer.append(this.indentation+"this.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
					generateCodeBuffer.append(this.indentation+"\t\tif(this.timeSerieResults.get(\""+guard.getValue()+"\") != null ){ \n");
					if(guard.getAddValue() != null){
						generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
					}else{
						generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieResults.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
					}
					generateCodeBuffer.append(this.indentation+"\t\t}else{ \n");
					if(guard.getAddValue() != null){
						generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")"+guard.getAddValue()+"); \n");
					}else{
						generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+",this.timeSerieCounters.get(\""+guard.getValue()+"\").get(this.currentSignIndex"+guard.getIndexOther()+")); \n");
					}
					generateCodeBuffer.append(this.indentation+"\t\t} \n");

				}else{
					if(guard.getAddValue() != null){
						generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+""+guard.getAddValue()+"); \n");
					}else{
						generateCodeBuffer.append(this.indentation+"\t\tthis.timeSerieResults.get(\""+guard.getVar()+"\").set(this.currentValueIndex"+guard.getIndex()+","+guard.getValue()+"); \n");
					}
				}
			}
			if(instruction.getUpdates() != null){
				for(Update update : instruction.getUpdates()){
					generateCodeBuffer.append(this.indentation+"\t\tthis.currentCounters.replace(\""+update.getVar()+"\",this.currentCounters.get(\""+update.getVar()+"\")"+update.getAddValue()+"); \n");
					generateCodeBuffer.append(this.indentation+"\t\tfor(int i=this.currentValueIndex;i<this.timeSerie.length-1;i++){ \n");
					generateCodeBuffer.append(this.indentation+"\t\t\tthis.timeSerieCounters.get(\""+update.getVar()+"\").set(i,this.currentCounters.get(\""+update.getVar()+"\")); \n");
					generateCodeBuffer.append(this.indentation+"\t\t} \n");
				}
			}
			generateCodeBuffer.append(this.indentation+"\t} \n");
		}
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
