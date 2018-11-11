package model.parameters.decorationTable;

public class Guard {
	private String var;
	private String index;
	private String value;
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
		return "(var=" + var + ", index=" + index + ", value=" + value + ") ";
	}
	
	

}
