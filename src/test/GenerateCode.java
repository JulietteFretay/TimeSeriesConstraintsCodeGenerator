package test;

import java.util.ArrayList; 
import java.util.HashMap; 
public class GenerateCode { 
	private int[] timeSerie; 
	private HashMap<String, ArrayList<Integer>> timeSerieResults; 
	private String  currentState; 
	private int currentSignIndex; 
	private int currentValueIndex; 
	private String[] timeSerieSigns; 
	private String[] timeSerieStates; 
	private String[] timeSerieLetters; 
	private int[] timeSerieCounters; 
	public void getResultForATimeSerie(int[] timeSerie) {
		this.timeSerieResults = new HashMap<String, ArrayList<Integer>>();
		this.timeSerie = timeSerie;
		System.out.println("TimeSerie Values : "+this.listToString(timeSerie));
		this.currentState = "d";
		int nbElements = timeSerie.length;
		currentSignIndex = 0;
		this.timeSerieStates = new String[nbElements];
		this.timeSerieStates[0] = "d";
		this.timeSerieLetters = new String[nbElements-1];
		this.timeSerieCounters = new int[nbElements-1];
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for(int i = 0; i < timeSerie.length; i++) {
			resultList.add(new Integer(0));
		}
		this.timeSerieResults.put("F",resultList);
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
		if (this.currentState.equals("d") && ">=".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "d";
			this.timeSerieLetters[currentSignIndex] = "out";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("d") && "<".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "r";
			this.timeSerieLetters[currentSignIndex] = "out";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("r") && ">".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "t";
			this.timeSerieLetters[currentSignIndex] = "found";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("r") && "<=".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "r";
			this.timeSerieLetters[currentSignIndex] = "maybeB";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("t") && ">".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "t";
			this.timeSerieLetters[currentSignIndex] = "in";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("t") && "=".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "t";
			this.timeSerieLetters[currentSignIndex] = "maybeA";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
		else if (this.currentState.equals("t") && "<".contains(this.timeSerieSigns[currentSignIndex])){
			this.timeSerieStates[currentValueIndex] = "r";
			this.timeSerieLetters[currentSignIndex] = "outA";
			this.currentState = this.timeSerieStates[currentValueIndex] ;
		}
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = 0;
		this.currentSignIndex = 0;
		this.currentState ="d";
		System.out.println("TimeSerie States : "+this.listToString(timeSerieStates));
		//Code timeSerie letters 
		System.out.println("TimeSerie Letters : "+this.listToString(timeSerieLetters));
		while(this.currentSignIndex < this.timeSerie.length-1){
		//Code timeSerie counters 
		if(this.timeSerieLetters[currentSignIndex].equals( "out")){ 
		this.timeSerieResults.get("F").set(this.currentValueIndex,0); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "outR")){ 
		this.timeSerieResults.get("F").set(this.currentValueIndex,0); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "outA")){ 
		this.timeSerieResults.get("F").set(this.currentValueIndex,0); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "maybeB")){ 
		this.timeSerieResults.get("F").set(this.currentValueIndex,1); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "maybeA")){ 
		this.timeSerieResults.get("F").set(this.currentValueIndex,1); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "foundE")){ 
		//this.timeSerieResults.get("F").set(this.currentValueIndex,C+1); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "found")){ 
		//this.timeSerieResults.get("F").set(this.currentValueIndex,C+1); 
		} 
		if(this.timeSerieLetters[currentSignIndex].equals( "in")){ 
		//this.timeSerieResults.get("F").set(this.currentValueIndex,C); 
		} 
			this.currentValueIndex ++;
			this.currentSignIndex ++;
		}
		this.currentValueIndex = 0;
		this.currentSignIndex = 0;
		System.out.println("TimeSerie Counters : "+this.listToString(timeSerieCounters));
		//Code timeSerie results 
		System.out.println("TimeSerie Results : "+this.timeSerieResults);
	}
//Code list to string 
	public String listToString(int[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			res+=list[i]+" ";
		}
		res+="]";
		return res;
	}
//Code list to string 
	public String listToString(String[] list){
		String res="[";
		for(int i=0;i<list.length;i++){
			res+=list[i]+" ";
		}
		res+="]";
		return res;
	}
}