package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieLetters {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieLetters(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie letters \n");

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
