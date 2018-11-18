package model.generator;

import model.parameters.seedTemplate.Arc;
import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieStates {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieStates(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		
		boolean isFirstIf = true;
		
		generateCodeBuffer.append(this.indentation+"//Code timeSerie states \n");
		for(Arc arc :this.seedTemplate.getLinks()) {
			if (isFirstIf) {
				generateCodeBuffer.append(this.indentation+"if (this.currentState.equals(\""+arc.getFrom()+"\") && \""+arc.getSigLabel()+"\".contains(this.timeSerieSigns[currentSignIndex])){\n");
				isFirstIf = false;
			} else {
				generateCodeBuffer.append(this.indentation+"else if (this.currentState.equals(\""+arc.getFrom()+"\") && \""+arc.getSigLabel()+"\".contains(this.timeSerieSigns[currentSignIndex])){\n");
			}
			generateCodeBuffer.append(this.indentation+"\tthis.timeSerieStates[currentValueIndex] = \""+arc.getTo()+"\";\n");
			generateCodeBuffer.append(this.indentation+"\tthis.timeSerieLetters[currentSignIndex] = \""+arc.getLetter()+"\";\n");
			generateCodeBuffer.append(this.indentation+"\tthis.currentState = this.timeSerieStates[currentValueIndex] ;\n");
			generateCodeBuffer.append(this.indentation+"}\n");
		};	
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
