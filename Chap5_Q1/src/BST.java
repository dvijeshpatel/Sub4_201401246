import java.util.Collection;
import java.util.LinkedList;


public class BST 
{
Node root;
BST(Node root)
{
	this.root = root;
}
public void insert(Node node)
{
	Node temp = root;
	Node pre = null;
	while(temp!=null)
	{
		pre = temp;
		if(temp.key>node.key)
			temp = temp.leftChild;
		else if(temp.key<node.key)
			temp = temp.rightChild;
	}
	if(pre.key<node.key)
	{
		pre.rightChild = node;
		node.Parent = pre;
	}
	if(pre.key>node.key)
	{
		pre.leftChild = node;
		node.Parent =pre;
	}
}
public Node search(int key)
{
	Node temp = root;
	while(temp.key!=key&&temp!=null)
	{
		if(temp.key<key)
			temp = temp.rightChild;
		if(temp.key>key)
			temp = temp.leftChild;
	}
	return temp;
}
public void LevelOrder(Node node)
{
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(root);
	while(!queue.isEmpty())
	{
	 Node temp = queue.removeFirst();
	 System.out.print(temp.key+" ");
	 if(temp.leftChild!=null)queue.addLast(temp.leftChild);
	 if(temp.rightChild!=null)queue.addLast(temp.rightChild);
	}
}


}

