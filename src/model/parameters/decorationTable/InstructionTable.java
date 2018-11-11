package model.parameters.decorationTable;

import java.util.ArrayList;

public class InstructionTable {
	private String step;
	private int after;
	private ArrayList<Guard> guards;
	private ArrayList<Update> updates;
	public String getStep() {
		return step;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public int getAfter() {
		return after;
	}
	public void setAfter(int after) {
		this.after = after;
	}
	public ArrayList<Guard> getGuards() {
		return guards;
	}
	public void setGuards(ArrayList<Guard> guards) {
		this.guards = guards;
	}
	public ArrayList<Update> getUpdates() {
		return updates;
	}
	public void setUpdates(ArrayList<Update> updates) {
		this.updates = updates;
	}
	@Override
	public String toString() {
		return "(" + step + ", " + after + ", " + guards + ", " + updates
				+ ")";
	}
	

}
