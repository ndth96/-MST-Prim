package Kruskal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Kruskal {
	
	private LinkedList<Edge> listEdge;
	private LinkedList<Edge> result;

	public LinkedList<Edge> getResult() {
		return result;
	}

	public void setResult(LinkedList<Edge> result) {
		this.result = result;
	}

	public Kruskal(LinkedList<Edge> listEdge) {
		super();
		this.listEdge = listEdge;
	}

	public LinkedList<Edge> getListEdge() {
		return listEdge;
	}
		
	public void setListEdge(LinkedList<Edge> listEdge) {
		this.listEdge = listEdge;
	}
	public boolean checkCycle(Edge edge, List<String> listVertex){		
		if(listVertex.contains(edge.getDest()) && listVertex.contains(edge.getSource())){
			return true;
		}
		return false;
	}
	
	public List<String> getVertex(LinkedList<Edge> listEdge){
		List<String> list = new ArrayList<>();
		for(Edge entry : listEdge){
			if(list.isEmpty()){
				list.add(entry.getDest().getVertex());
				list.add(entry.getSource().getVertex());
			}
			else {
				int flag = 0;
				for (String vertex : list) {
					if(vertex.equals(entry.getDest())){
						flag = 0;
						break;
					}
					flag = 1;
				}	
				if(flag == 1) list.add(entry.getDest().getVertex());
				for (String vertex : list) {
					if(vertex.equals(entry.getSource())){
						flag = 0;
						break;
					}
					flag = 1;
				}
				if(flag == 1) list.add(entry.getSource().getVertex());
			}
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	public LinkedList<Edge> getEdge(String vertex, LinkedList<Edge> listEdge){
		LinkedList<Edge> list = new LinkedList<Edge>();
		for(Edge temp: listEdge){
			if(temp.getSource().getVertex().equalsIgnoreCase(vertex) || temp.getDest().getVertex().equalsIgnoreCase(vertex)){
				list.add(temp);
			}
		}
		if(list.isEmpty()) {
			return null;
		}
		Collections.sort(list, new Edge());		
		
		return list;
	}
	public void union(Edge edge1, Edge edge2){
		edge2.getSource().setPrev(edge1.getSource());
	}
	
	public Vertex findSet(Edge edge){
		
		return null;
	}
	
	public static void main(String[] args) {
		
		int numVertex = 5;
		// nhap du lieu
		LinkedList<Edge> list = new LinkedList<Edge>();
		list.add(new Edge("A", "B", 1));
		list.add(new Edge("B", "D", 3));
		list.add(new Edge("A", "E", 4));
		list.add(new Edge("B", "E", 2));
		list.add(new Edge("E", "C", 4));
		list.add(new Edge("E", "D", 6));
		list.add(new Edge("C", "D", 8));
		//khoi chay Kruskal
		Kruskal run = new Kruskal(list);
		Collections.sort(run.getListEdge(), new Edge());
		for(Edge entry : run.getListEdge()){
			System.out.println(entry.getSource().getVertex() + "--" + entry.getDest().getVertex() + " : " +entry.getWeight());
		}
		
		//run.getResult().add(run.getListEdge().pop());
		int num = 1;
		while(num < numVertex - 1){
			
		}
		
		
	}
}
