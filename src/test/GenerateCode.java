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
		this.currentState = "s";
		int nbElements = timeSerie.length;
		this.timeSerieStates = new String[nbElements];
		this.timeSerieStates[0] = "s";
		this.timeSerieLetters = new String[nbElements-1];
		this.timeSerieCounters = new int[nbElements-1];
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
		//Code timeSerie states 
		if (this.currentState.equals("s") & this.timeSerieSigns[currentSignIndex] == ">"){
		}
		if (this.currentState.equals("s") & this.timeSerieSigns[currentSignIndex] == "<="){
		}
		System.out.println("TimeSerie States : "+this.listToString(timeSerieStates));
		//Code timeSerie letters 
		System.out.println("TimeSerie Letters : "+this.listToString(timeSerieLetters));
		//Code timeSerie counters 
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