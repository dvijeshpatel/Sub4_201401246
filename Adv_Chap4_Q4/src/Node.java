
public class Node {
	public int data,level,size,rank;
	public Node right,left,parent;
	
	public Node(int data){
		this.data = data;
		right = left = parent = null;
		this.level = 1;
		this.size = 1;
		this.rank = 0;
	}
}
