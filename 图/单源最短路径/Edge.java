package 图.单源最短路径;
/**
 * 边的定义;
 * @author 涛宝宝
 *
 */
public class Edge {
	
	/**
	 * 边的起节点;
	 */
	Vertex from;
	
	/**
	 * 边的终节点;
	 */
	Vertex to;
	
	/**
	 * 该边上的权值；
	 */
	int value;

	public Edge(Vertex from, Vertex to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
}
