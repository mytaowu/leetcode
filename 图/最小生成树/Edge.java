package 图.最小生成树;
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

	
	@Override
	public String toString() {
		return "Edge [from=" + from.name+ ", to=" + to.name + ", value=" + value + "]";
	}



	public Edge(Vertex from, Vertex to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
}
