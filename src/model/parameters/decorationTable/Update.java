package model.parameters.decorationTable;

public class Update {
	private String var;
	private String value;
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "(var=" + var + ", value=" + value + ") ";
	}
	
	
}
