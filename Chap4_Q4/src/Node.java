
public class Node
{
public Node Parent;
public Node leftChild;
public Node rightChild;
public int key;
public Node(int key)
{
	this.key = key;
	Parent = null;
	leftChild = null;
	rightChild = null;
	
}
}
