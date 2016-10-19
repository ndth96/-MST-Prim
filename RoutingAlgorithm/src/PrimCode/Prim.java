package PrimCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Prim {
	private LinkedList<Edge> listEdge;
	private List<String> listVertex;

	public Prim(LinkedList<Edge> listEdge) {
		super();
		this.listEdge = listEdge;
		this.listVertex = getVertex(listEdge);
	}
	
	public List<String> getListVertex() {
		return listVertex;
	}

	public void setListVertex(List<String> listVertex) {
		this.listVertex = listVertex;
	}

	public LinkedList<Edge> getListEdge() {
		return listEdge;
	}
		
	public void setListEdge(LinkedList<Edge> listEdge) {
		this.listEdge = listEdge;
	}
	
	public LinkedList<Edge> getEdge(String vertex, LinkedList<Edge> listEdge){
		LinkedList<Edge> list = new LinkedList<Edge>();
		for(Edge temp: listEdge){
			if(temp.getSource().equalsIgnoreCase(vertex) || temp.getDest().equalsIgnoreCase(vertex)){
				list.add(temp);
			}
		}
		if(list.isEmpty()) return null;
		Collections.sort(list, new Edge());		
		
		return list;
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
				list.add(entry.getDest());
				list.add(entry.getSource());
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
				if(flag == 1) list.add(entry.getDest());
				for (String vertex : list) {
					if(vertex.equals(entry.getSource())){
						flag = 0;
						break;
					}
					flag = 1;
				}
				if(flag == 1) list.add(entry.getSource());
			}
		}
		if(list.isEmpty()){
			return null;
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numVertex = 5;
		int numEdge = 7;				
		LinkedList<Edge> list = new LinkedList<Edge>();
		list.add(new Edge("A", "B", 1));
		list.add(new Edge("B", "D", 3));
		list.add(new Edge("A", "E", 4));
		list.add(new Edge("B", "E", 2));
		list.add(new Edge("E", "C", 4));
		list.add(new Edge("E", "D", 6));
		list.add(new Edge("C", "D", 8));
		
		Collections.sort(list, new Edge());
		for(Edge temp: list){
			System.out.println(temp.getSource() + "  " + temp.getDest() + "  " + temp.getWeight());
		}

		Prim run = new Prim(list);

		LinkedList<Edge> result = new LinkedList<Edge>();
		
		List<String> listVertexTemp = new ArrayList<String>();
		listVertexTemp.add("A");
		int num = 1;
		while(num != numVertex){
			
			LinkedList<Edge> listEdgeTemp = new LinkedList<Edge>();
			LinkedList<Edge> listTemp = (LinkedList<Edge>) list.clone();
			for(String vertex: listVertexTemp){
				if(run.getEdge(vertex, list) == null){
					continue;
				}

				Edge temp = run.getEdge(vertex, listTemp).getFirst();
				listTemp.removeFirst();
				boolean check = run.checkCycle(temp, listVertexTemp);

				if(check) continue;
				listEdgeTemp.add(temp);
			}
			if(!listEdgeTemp.isEmpty()){
			Collections.sort(listEdgeTemp, new Edge());
			result.add(listEdgeTemp.getFirst());
			listVertexTemp = run.getVertex(result);
			list.remove(listEdgeTemp.getFirst());
			num++;
			}	
		}
		
		System.out.println("Result: ");
		for(Edge temp: result){
			System.out.println(temp.getSource() + "  " + temp.getDest() + "  " + temp.getWeight());
		}

	}
}
