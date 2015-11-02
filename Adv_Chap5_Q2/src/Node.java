
public class Node
{
public Node Parent;
public Node leftChild;
public Node rightChild;
public int key;
public int cost;
public Node(int key,int cost)
{
	this.key = key;
	this.cost = cost;
	Parent = null;
	leftChild = null;
	rightChild = null;
	
}
}
