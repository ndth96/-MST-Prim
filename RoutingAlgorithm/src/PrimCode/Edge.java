package PrimCode;

import java.util.Comparator;

public class Edge implements Comparator<Edge>{
	private String source;
	private String dest;
	private int weight;
	
	
	public Edge(String source, String dest, int weight) {
		super();
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int compare(Edge arg0, Edge arg1) {
		// TODO Auto-generated method stub
		if(arg0.getWeight() > arg1.getWeight()){
			return 1;
		}
		else if(arg0.getWeight() < arg1.getWeight()){
			return -1;
		}
		return 0;
	}
	
	
}
