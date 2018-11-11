package model.parameters;

import java.util.ArrayList;

public class SeedTemplate {
	private String name;
	private State startingState;
	private ArrayList<StateOrReturn> states;
	private ArrayList<Arc> links;
	private int nodeDistance;
}
