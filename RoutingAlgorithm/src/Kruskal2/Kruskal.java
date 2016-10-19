package Kruskal2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal{

	private int[] parent;
	private int[][] matrix;
	private int[][] mst;
	private int numVertex;
	private List<Edge> listEdge;
	
	public Kruskal(int[][] matrix) {
		this.matrix = matrix;
		this.numVertex = matrix.length;
		this.parent = new int[numVertex];
		this.listEdge = new ArrayList();
		for(int i = 0; i < numVertex; i++){
			parent[i] = -1;
		}
		for(int i = 0; i < numVertex; i++){
			for(int j = 0; j < numVertex; j++){
				if(matrix[i][j] != 0){
					listEdge.add(new Edge(i, j, matrix[i][j]));

				}
			}
		}
		Collections.sort(listEdge, new Edge());
		
	}

	public void union(int u, int v){
		if(parent[u] > parent[v]){
			parent[v] += parent[u];
			parent[u] = v;
		}else{
			parent[u] += parent[v];
			parent[v] = u;
		}
	}
	
	public int findSet(int x) {
		while(parent[x] > -1){
			x = parent[x];
		}
		return x;
	}
	
	public static void main(String[] args) {
		//int numEdge;
		int[][] dataMatrix = {
				{0, 1, 0, 0, 4}, {1, 0, 0, 3, 8}, {0, 0, 0, 2, 4},
				{0, 3, 2, 0, 6}, {4, 8, 4, 6, 0}
		};
		int numVertex = dataMatrix.length;
		
		int[][] MST = new int[numVertex][numVertex];
		Kruskal run = new Kruskal(dataMatrix);

		for(Edge entry: run.listEdge){
			int u = run.findSet(entry.getU());
			int v = run.findSet(entry.getV());
			if(u != v){
				int x = entry.getU();
				int y = entry.getV();
				MST[x][y] = MST[y][x] = entry.getWeight();
				System.out.println("Step: "+ entry.getU() + " " + entry.getV() +" " + entry.getWeight());
				run.union(u, v);
			}
			
		}
		
		for(int i = 0; i < numVertex; i++){
			for(int j = 0; j < numVertex; j++){
				System.out.print(run.matrix[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("---------- Result ---------");
		for(int i = 0; i < numVertex; i++){
			for(int j = 0; j < numVertex; j++){
				System.out.print(MST[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public int[][] getMst() {
		return mst;
	}

	public void setMst(int[][] mst) {
		this.mst = mst;
	}

	public List<Edge> getListEdge() {
		return listEdge;
	}

	public void setListEdge(List<Edge> listEdge) {
		this.listEdge = listEdge;
	}
	
}
