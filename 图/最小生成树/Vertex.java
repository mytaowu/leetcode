package 图.最小生成树;
/**
 * 定义的顶点;
 * @author 涛宝宝
 *
 */
public class Vertex {
	
	/**
	 * 顶点的名称;
	 */
	String name;

	public Vertex(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}



	/**
	 * 使用map集合，必须重写hashcode和equals方法。
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
