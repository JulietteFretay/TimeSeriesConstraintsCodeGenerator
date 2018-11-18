package model.generator;

import model.parameters.seedTemplate.SeedTemplate;

public class GeneratorSeedTransducerArcs {
	private SeedTemplate seedTemplate;
	private String indentation;

	public GeneratorSeedTransducerArcs(SeedTemplate seedTemplate) {
		this.seedTemplate = seedTemplate;
		this.indentation="";
	}

	public void append(StringBuffer generateCodeBuffer) {
		generateCodeBuffer.append(this.indentation+"//Code seed transducer arcs \n");

	}

	public void setIndentation(String string) {
		this.indentation = string;
	}
}
