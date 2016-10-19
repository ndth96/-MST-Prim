package Kruskal;

import java.util.Comparator;

public class Edge implements Comparator<Edge>{
	private Vertex source;
	private Vertex dest;
	private int weight;
	
	
	public Edge(String source, String dest, int weight) {
		super();
		this.source = new Vertex(source);
		this.dest = new Vertex(dest);
		this.weight = weight;
	}
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	public void makeSet(){
		this.getDest().setPrev(this.getSource());
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getDest() {
		return dest;
	}
	public void setDest(Vertex dest) {
		this.dest = dest;
	}
	@Override
	public int compare(Edge arg0, Edge arg1) {
		// TODO Auto-generated method stub
		if(arg0.getWeight() > arg1.getWeight()){
			return -1;
		}
		else if(arg0.getWeight() < arg1.getWeight()){
			return 1;
		}
		return 0;
	}
	
	
}
