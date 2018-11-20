package test; 
import java.util.ArrayList; 
import java.util.HashMap; 
public class FOOTPRINT_INCREASING_SEQUENCE { 
	private int[] timeSerie; 
	private HashMap<String, ArrayList<Integer>> timeSerieResults; 
	private String  currentState; 
	private int currentSignIndex; 
	private int currentValueIndex; 
	private String[] timeSerieSigns; 
	private String[] timeSerieStates; 
	private String[] timeSerieLetters; 
	private HashMap<String, ArrayList<Integer>> timeSerieCounters; 
	private HashMap<String, Integer> currentCounters; 
	public void getResultForATimeSerie(int[] timeSerie, String feature, int defaultVal) {
		this.timeSerieResults = new HashMap<String, ArrayList<Integer>>();
		this.timeSerie = timeSerie;
		System.out.println("TimeSerie Values : "+this.listToString(timeSerie));
		this.currentState = "s";
		int nbElements = timeSerie.length;
		currentSignIndex = 0;
		this.timeSerieStates = new String[nbElements];
		this.timeSerieStates[0] = "s";
		this.timeSerieLetters = new String[nbElements-1];
		this.timeSerieCounters = new HashMap<String, ArrayList<Integer>>();
		this.currentCounters = new HashMap<String, Integer>() ;
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length-1; i++) {
			resultList.add(new Integer(0));
		}
		this.timeSerieResults.put("p",resultList);
		ArrayList<Integer> counterList = new ArrayList<Integer>();
		counterList.add(new Integer(0));
		for(int i = 0; i < timeSerie.length-2; i++) {
			counterList.add(new Integer(0));
		}
		this.timeSerieCounters.put("C",counterList);
		this.currentCounters.put("C",0);
		//Code timeSerie signs 
		this.timeSerieSigns = new String[nbElements - 1];
		for (int i = 0; i < nbElements - 1; i++) {
			if (timeSerie[i] == timeSerie[i+1]) {
				timeSerieSigns[i] = "=";
			} else if (timeSerie[i] < timeSerie[i+1]) {
				timeSerieSigns[i] = "<";
			} else {
				timeSerieSigns[i] = ">";
			}
		}
		System.out.println("TimeSerie Signs : "+this.listToString(timeSerieSigns));
		this.currentValueIndex = 1;
		while(this.currentValueIndex < this.timeSerie.length){
		//Code timeSerie states 
			if (this.currentState.equals("s") && ">=".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "s";
				this.timeSerieLetters[currentSignIndex] = "out";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("s") && "<".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "found";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("t") && ">".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "s";
				this.timeSerieLetters[currentSignIndex] = "outA";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("t") && "=".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "maybeA";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			else if (this.currentState.equals("t") && "<".contains(this.timeSerieSigns[currentSignIndex])){
				this.timeSerieStates[currentValueIndex] = "t";
				this.timeSerieLetters[currentSignIndex] = "in";
				this.currentState = this.timeSerieStates[currentValueIndex] ;
			}
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = 0;
		this.currentSignIndex = 0;
		this.currentState ="s";
		System.out.println("TimeSerie States : "+this.listToString(timeSerieStates));
		System.out.println("TimeSerie Letters : "+this.listToString(timeSerieLetters));
		while(this.currentSignIndex < this.timeSerie.length-1){
		//Code timeSerie counters 
			if(this.timeSerieLetters[currentSignIndex].equals( "out")){ 
				this.timeSerieResults.get("p").set(this.currentValueIndex+0,0); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outR")){ 
				this.timeSerieResults.get("p").set(this.currentValueIndex+0,0); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outA")){ 
				this.timeSerieResults.get("p").set(this.currentValueIndex+0,0); 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeB")){ 
				if(this.timeSerieResults.get("p") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("p").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieCounters.get("p").get(this.currentSignIndex+1)); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")){ 
				if(this.timeSerieResults.get("p") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("p").get(this.currentSignIndex+1)); 
				}else{ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieCounters.get("p").get(this.currentSignIndex+1)); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentSignIndex+0)+1); 
				}else{ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieCounters.get("C").get(this.currentSignIndex+0)+1); 
				} 
				this.currentCounters.replace("C",this.currentCounters.get("C")+1); 
				for(int i=this.currentValueIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentSignIndex+0)+1); 
				}else{ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieCounters.get("C").get(this.currentSignIndex+0)+1); 
				} 
				this.currentCounters.replace("C",this.currentCounters.get("C")+1); 
				for(int i=this.currentValueIndex;i<this.timeSerie.length-1;i++){ 
					this.timeSerieCounters.get("C").set(i,this.currentCounters.get("C")); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentSignIndex+0)); 
				}else{ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieCounters.get("C").get(this.currentSignIndex+0)); 
				} 
			} 
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = this.timeSerie.length-2;
		this.currentSignIndex = this.timeSerie.length-2;
		System.out.println("TimeSerie Counters : "+this.timeSerieCounters);
		while(this.currentSignIndex >=0){
		//Code timeSerie results 
			if(this.timeSerieLetters[currentSignIndex].equals( "out")){ 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outR")){ 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "outA")){ 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeB")){ 
				if(this.timeSerieResults.get("p") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("p").get(this.currentValueIndex+1)); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")){ 
				if(this.timeSerieResults.get("p") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("p").get(this.currentValueIndex+1)); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "foundE")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentValueIndex+0)+1); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "found")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentValueIndex+0)+1); 
				} 
			} 
			else if(this.timeSerieLetters[currentSignIndex].equals( "in")){ 
				if(this.timeSerieResults.get("C") != null ){ 
					this.timeSerieResults.get("p").set(this.currentValueIndex+0,this.timeSerieResults.get("C").get(this.currentValueIndex+0)); 
				} 
			} 
			this.currentValueIndex --;
			this.currentSignIndex --;
		}
		System.out.println("TimeSerie Results : "+this.timeSerieResults);
	}
	//Code list to string 
	public String listToString(int[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			if (i < list.length-1) {
				res+=list[i]+", ";
			} else {
				res+=list[i];
			}
		}
		res+="]";
		return res;
	}
	//Code list to string 
	public String listToString(String[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			if (i < list.length-1) {
				res+=list[i]+", ";
			} else {
				res+=list[i];
			}
		}
		res+="]";
		return res;
	}
}