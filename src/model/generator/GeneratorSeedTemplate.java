package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorSeedTemplate {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorSeedTemplate(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code Seed Template \n");
		for(String state :this.seedTemplate.getStates()) {
			generateCodeBuffer.append(this.indentation+"\t if this.currentState.equals("+state+")");
        };
		
		
	}

	public void setIndentation(String string) {
		this.indentation = string;
	}

}
