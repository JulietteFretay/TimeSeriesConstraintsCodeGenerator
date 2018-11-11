package model.parameters.decorationTable;

import java.util.ArrayList;

public class Instruction {
	private String step;
	private String after;
	private ArrayList<Guard> guards;
	private ArrayList<Update> updates;
}
