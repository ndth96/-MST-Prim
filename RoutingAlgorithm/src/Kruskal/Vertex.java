package Kruskal;

public class Vertex {
	private String vertex;
	private Vertex prev;
	public Vertex() {
		// TODO Auto-generated constructor stub
		this.vertex = null;
		this.prev = null;
	}
	public Vertex(String vertex, Vertex prev) {
		super();
		this.vertex = vertex;
		this.prev = prev;
	}
	public Vertex(String vertex) {
		super();
		this.vertex = vertex;
		this.prev = null;
	}

	public String getVertex() {
		return vertex;
	}
	public void setVertex(String vertex) {
		this.vertex = vertex;
	}
	public Vertex getPrev() {
		return prev;
	}
	public void setPrev(Vertex prev) {
		this.prev = prev;
	}
	
}
