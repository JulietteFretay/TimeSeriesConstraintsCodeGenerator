package model.parameters.decorationTable;

public class Update {
	private String var;
	private String value;
	private int index;
	private Boolean useOther;
	private String indexOther;
	private String addValue;
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Boolean getUseOther() {
		return useOther;
	}
	public void setUseOther(Boolean useOther) {
		this.useOther = useOther;
	}
	public String getIndexOther() {
		return indexOther;
	}
	public void setIndexOther(String indexOther) {
		this.indexOther = indexOther;
	}
	public String getAddValue() {
		return addValue;
	}
	public void setAddValue(String addValue) {
		this.addValue = addValue;
	}
	
	
}
