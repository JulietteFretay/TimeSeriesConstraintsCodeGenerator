package model.parameters.decorationTable;

public class Guard {
	private String var;
	private String index;
	private String value;
	private Boolean useOther;
	private String indexOther;
	private String addValue;
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
