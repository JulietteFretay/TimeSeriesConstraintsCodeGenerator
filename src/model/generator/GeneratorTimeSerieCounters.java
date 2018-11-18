package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorTimeSerieCounters {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorTimeSerieCounters(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code timeSerie counters \n");

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
