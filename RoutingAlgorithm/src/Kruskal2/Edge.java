package Kruskal2;

import java.util.Comparator;

public class Edge implements Comparator<Edge>{
	private int u ;
	private int v;
	private int weight;
	
	public Edge(int u, int v, int weight) {
		super();
		this.u = u;
		this.v = v;
		this.weight = weight;
	}
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
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
		if(arg0.getWeight() < arg1.getWeight()){
			return -1;
		}
		return 0;
	}
	
}