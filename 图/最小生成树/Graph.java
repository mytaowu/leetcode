package 图.最小生成树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * 基础图的表表示法;
 * @author Administrator
 *
 */
public class Graph {
	
	/**
	 * 顶点的集合;
	 */
	List<Vertex> vertexts;
	
	/**
	 * 顶点对应边的集合；
	 */
	Map<Vertex, List<Edge>> edges;
	
	/**
	 * @param v:开始的源顶点。
	 * @return map:key,value源点V到key的最短路径长value;
	 */
	public Map<Vertex,Integer> dijkstra(Vertex v){
		// 定义返回的map集合。
		Map<Vertex,Integer> pathResult = new HashMap<Vertex,Integer>();
		// 定义源点到源点的距离为0;
		pathResult.put(v, 0);
		// 定义遍历过程的current，记录遍历过程中的值。
		Map<Vertex,Integer> current = new HashMap<Vertex,Integer>();
		// 初始化源点。
		current.put(v, 0);
		// 初始化栈，用于保存变量。
		Stack<Vertex> vertextStack = new Stack<Vertex>();
		
		vertextStack.push(v);
		
		while (!vertextStack.isEmpty()){
			List<Edge> list = edges.get(vertextStack.pop());
			for (int i = 0 ; i < list.size() ; i++){
				if (!pathResult.containsKey(list.get(i))){
					// 遍历到元素，加入栈中。
					vertextStack.push(list.get(i).to);
				
					// 获得原始的path;
					Integer path = current.get(list.get(i).to);
					// 定义计算最终的path;
					Integer resultPath = null;
					
					if (path == null){
						// 如果原始的path并未有计算，就吧前一个节点的path加上value值即可。
						resultPath = current.get(list.get(i).from) + list.get(i).value;
					}else{
						// 若是path存在，就取最小值。
						resultPath = Math.min(current.get(list.get(i).from) + list.get(i).value, current.get(list.get(i).to));
					}
					// 存入临时数组。
					current.put(list.get(i).to, resultPath);
				}
			}

			// 遍历临时数组，取出最小的path和对应的节点，加入到我们的resultPath中。
			Set<Entry<Vertex,Integer>> set = current.entrySet();
			Iterator<Entry<Vertex, Integer>> iterator = set.iterator();
			
			Vertex minVerex = null;
			int minPath = Integer.MAX_VALUE;
			
			while (iterator.hasNext()){
				Entry<Vertex, Integer> next = iterator.next();
				// 如果节点在pathResult中，那么我们直接略过。
				if (!pathResult.containsKey(next.getKey())){
					// 更新节点;
					minVerex = minVerex == null ? next.getKey() : next.getValue() < minPath ? next.getKey() : minVerex;
					// 更新path;
					if (minVerex == next.getKey()){
						minPath = next.getValue();
					}
				}
			}
			
			// 定义返回条件。
			if (minVerex == null){
				return pathResult;
			}
			// 加入返回数组中。
			pathResult.put(minVerex, minPath);

			if (pathResult.size() == vertexts.size()){
				return pathResult;
			}
		}
		return pathResult;
	}
	
	/**
	 * @param v:开始的源顶点。
	 * @return map:prim求最小生成树;
	 */
	public ResulEntry prim(Vertex v){
		// 定义返回的顶点集;
		Set<Vertex> resultVertex = new HashSet<Vertex>();
		// 定义返回的边集;
		Set<Edge> resultEdegs = new HashSet<Edge>();
		// 把我们遍历的根节点加入我们的定点集中。
		resultVertex.add(v);
		
		// 在遍历过程中记录边值的优先队列。
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100,cmp);
		List<Vertex> list = new ArrayList<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(v);
		
		while(!stack.isEmpty() && resultVertex.size() < vertexts.size()){
			Vertex vertex = stack.pop();
			// 获取定点对应的边集;
			List<Edge> es = edges.get(vertex);
			// 加入到优先队列中;
			for (Edge edge : es) {
				if (!queue.contains(edge)){
					queue.add(edge);
				}
			}
			// 取出值最小的一个。
			Edge edge = queue.poll();
			resultEdegs.add(edge);
			resultVertex.add(edge.to);
			stack.push(edge.to);
		}
		
		return new ResulEntry(resultVertex, resultEdegs);
	}
	
	
	/**
	 * @param v:开始的源顶点。
	 * @return map:Kruskal求最小生成树;
	 */
	public ResulEntry Kruskal(Vertex v){
		// 定义已经访问的顶点集
		Set<Vertex> resultVertex = new HashSet<Vertex>();
		// 定义未访问的顶点集,使用vertexts进行初始化。用两个set代替并查集的功能。
		Set<Vertex> orgalVertexs = new HashSet(vertexts);
		Set<Edge> resultEdegs = new HashSet<Edge>();
		
		
		resultVertex.add(v);
		orgalVertexs.remove(v);
		
		// 把我们遍历的根节点加入我们的定点集中。
		resultVertex.add(v);
		
		// 在遍历过程中记录边值的优先队列。
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100,cmp);
		List<Vertex> list = new ArrayList<Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		stack.push(v);
		
		while(!stack.isEmpty() && resultVertex.size() < vertexts.size()){
			Vertex vertex = stack.pop();
			// 获取定点对应的边集;
			List<Edge> es = edges.get(vertex);
			// 加入到优先队列中;
			for (Edge edge : es) {
				if (!queue.contains(edge)){
					queue.add(edge);
				}
			}
			// 取出值最小的一个。
			Edge edge = queue.poll();
			resultEdegs.add(edge);
			resultVertex.add(edge.to);
			stack.push(edge.to);
		}
		
		return new ResulEntry(resultVertex, resultEdegs);
	}
	
	
	static Comparator<Edge> cmp = new Comparator<Edge>() {
	      public int compare(Edge e1, Edge e2) {
	        return e1.value - e2.value;
	      }
	};
	
	
	static class ResulEntry{
		Set<Vertex> resultVertex;
		Set<Edge> resultEdegs;
		public ResulEntry(Set<Vertex> resultVertex, Set<Edge> resultEdegs) {
			super();
			this.resultVertex = resultVertex;
			this.resultEdegs = resultEdegs;
		}
		public Set<Vertex> getResultVertex() {
			return resultVertex;
		}
		public void setResultVertex(Set<Vertex> resultVertex) {
			this.resultVertex = resultVertex;
		}
		public Set<Edge> getResultEdegs() {
			return resultEdegs;
		}
		public void setResultEdegs(Set<Edge> resultEdegs) {
			this.resultEdegs = resultEdegs;
		}
	}
}
