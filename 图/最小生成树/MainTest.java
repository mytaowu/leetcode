package 图.最小生成树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import 图.最小生成树.Graph.ResulEntry;


public class MainTest {
	
	@SuppressWarnings("unchecked")
	public static void main1(String args[]){
		Vertex v1 = new Vertex("a");
		Vertex v2 = new Vertex("b");
		Vertex v3 = new Vertex("c");
		Vertex v4 = new Vertex("d");
		
		List<Vertex> verList = new ArrayList<Vertex>();
		verList.add(v1);
		verList.add(v2);
		verList.add(v3);
		verList.add(v4);
		
		
		Edge e1 = new Edge(v1, v2, 5);
		Edge e2 = new Edge(v2, v3, 2);
		Edge e3 = new Edge(v3, v4, 6);
		Edge e4 = new Edge(v4, v2, 3);
		Edge e5 = new Edge(v1, v4, 4);
		
		List<Edge> v1List = new ArrayList();
		v1List.add(e1);
		v1List.add(e5);
		
		List<Edge> v2List = new ArrayList();
		v2List.add(e2);
		
		List<Edge> v3List = new ArrayList();
		v3List.add(e3);
		
		List<Edge> v4List = new ArrayList();
		v3List.add(e4);
		
		HashMap<Vertex,List<Edge>> map = new HashMap<Vertex, List<Edge>>();
		map.put(v1, v1List);
		map.put(v2, v2List);
		map.put(v3, v3List);
		map.put(v4, v4List);
		
		Graph graph = new Graph();
		graph.edges = map;
		graph.vertexts = verList;
		
		
		Map<Vertex, Integer> dijkstra = graph.dijkstra(v1);
		Set<Entry<Vertex,Integer>> set = dijkstra.entrySet();
//		set.forEach(e -> {
//			System.out.println("到:["+e.getKey().name+"]顶点的最短路径是:["+e.getValue()+"]");
//		});

	}
	
	public static void main(String args[]){
		Vertex v1 = new Vertex("a");
		Vertex v2 = new Vertex("b");
		Vertex v3 = new Vertex("c");
		Vertex v4 = new Vertex("d");
		
		List<Vertex> verList = new ArrayList<Vertex>();
		verList.add(v1);
		verList.add(v2);
		verList.add(v3);
		verList.add(v4);
		
		
		Edge e1 = new Edge(v1, v2, 5);
		Edge e2 = new Edge(v2, v3, 2);
		Edge e3 = new Edge(v3, v4, 6);
		Edge e4 = new Edge(v4, v2, 3);
		Edge e5 = new Edge(v1, v4, 4);
		
		List<Edge> v1List = new ArrayList();
		v1List.add(e1);
		v1List.add(e5);
		
		List<Edge> v2List = new ArrayList();
		v2List.add(e2);
		
		List<Edge> v3List = new ArrayList();
		v3List.add(e3);
		
		List<Edge> v4List = new ArrayList();
		v4List.add(e4);
		
		HashMap<Vertex,List<Edge>> map = new HashMap<Vertex, List<Edge>>();
		map.put(v1, v1List);
		map.put(v2, v2List);
		map.put(v3, v3List);
		map.put(v4, v4List);
		
		Graph graph = new Graph();
		graph.edges = map;
		graph.vertexts = verList;
		
		Map<Vertex, Integer> dijkstra = graph.dijkstra(v1);
		ResulEntry entry = graph.prim(v1);
		Set<Edge> edegs = entry.getResultEdegs();
		Set<Vertex> vertex = entry.getResultVertex();
		Iterator<Vertex> iterator = vertex.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		Iterator<Edge> iterator2 = edegs.iterator();
		while (iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
	}
	


}
