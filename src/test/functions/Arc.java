package test.functions;
import java.util.ArrayList;

public class Arc {
	
	String from;
	String to;
	ArrayList<String> signs;
	String name;

	public Arc (String from, String to, String signsAbreviation, String name) {
		
		this.from = from;
		this.to= to;
		this.signs = setSigns(signsAbreviation);
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public ArrayList<String> getSigns() {
		return signs;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<String> setSigns(String signsAbreviation) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		switch (signsAbreviation) {
		case "eq":
			list.add("=");
			break;
		case "gt":
			list.add(">");
			break;
		case "lt":
			list.add("<");
			break;
		case "geq":
			list.add("=");
			list.add(">");
			break;
		case "leq":
			list.add("=");
			list.add("<");
			break;
		default:
			list.add("");
			break;
		}
		
		return list;
	}
}
