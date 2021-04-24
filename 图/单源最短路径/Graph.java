package 图.单源最短路径;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
}
