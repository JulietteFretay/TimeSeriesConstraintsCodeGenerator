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
		generateCodeBuffer.append(this.indentation+"//Code timeSerie states \n");
		for(Arc arc :this.seedTemplate.getLinks()) {
			generateCodeBuffer.append(this.indentation+"if (this.currentState.equals(\""+arc.getFrom()+"\") & this.timeSerieSigns[currentSignIndex] == \""+arc.getSigLabel()+"\"){\n");
			generateCodeBuffer.append(this.indentation+"}\n");
		};
		
		
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
