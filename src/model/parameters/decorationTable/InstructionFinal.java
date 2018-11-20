package model.parameters.decorationTable;

import java.util.ArrayList;

public class InstructionFinal {
	private String var;
	private String index;
	private String value;
	private Boolean aggreg;
	private ArrayList<String> agVar;
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "(var=" + var + ", index=" + index + ", value=" + value + ")";
	}
	public Boolean getAggreg() {
		return aggreg;
	}
	public void setAggreg(Boolean aggreg) {
		this.aggreg = aggreg;
	}
	public ArrayList<String> getAgVar() {
		return agVar;
	}
	public void setAgVar(ArrayList<String> agVar) {
		this.agVar = agVar;
	}
	
	

}
