package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieResults {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieResults(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie results \n");

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
