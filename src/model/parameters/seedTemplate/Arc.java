package model.parameters.seedTemplate;

public class Arc {
	private String from;
	private String sig;
	private String to;
	private String letter;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSig() {
		return sig;
	}
	public void setSig(String sig) {
		this.sig = sig;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	@Override
	public String toString() {
		return "arc(from=" + from + ", sig=" + sig + ", to=" + to + ", letter=" + letter + ") \n";
	}
	
	
	
}
