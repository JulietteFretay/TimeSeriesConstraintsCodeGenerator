package model.parameters.decorationTable;

public class InstructionInit {
	private String var;
	private String init;
	
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	@Override
	public String toString() {
		return "(var=" + var + ", init=" + init + ")";
	}
	
	
}
