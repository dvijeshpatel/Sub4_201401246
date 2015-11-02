import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class BST 
{
Node root;
BST(Node root)
{
	this.root = root;
}
public void leftRotate(Node x)
{
	Node y = x.rightChild;
	x.rightChild = y.leftChild;
	if(y.leftChild!=null)
		y.leftChild.Parent = x;
	y.Parent = x.Parent;
	if(x.Parent==null)
		root = y;
	else if(x== x.Parent.leftChild)
		x.Parent.leftChild = y;
	else 
		x.Parent.rightChild = y;
	y.leftChild = x;
	x.Parent = y;
}
public void rightRotate(Node x)
{
	Node y= x.leftChild;
	x.leftChild = y.rightChild;
	if(y.rightChild!=null)
		y.rightChild.Parent = x;
	y.Parent = x.Parent;
	if(x.Parent==null)
		root = y;
	else if(x == x.Parent.leftChild)
		x.Parent.leftChild = y;
	else 
		x.Parent.rightChild = y;
	y.rightChild = x;
	x.Parent = y;
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

public ArrayList<Integer> visitCalculatedepths(Node node)
{
	ArrayList<Integer> depths = new ArrayList<Integer>();
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(node);
	while(!queue.isEmpty())
	{
		Node removed = queue.removeFirst();
		depths.add(this.depth(removed));
		if(removed.leftChild!=null)
			queue.addLast(removed.leftChild);
		if(removed.rightChild!=null)
			queue.addLast(removed.rightChild);
	}
	return depths;
}
public void LevelOrder(Node node)
{
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(node);
	while(!queue.isEmpty())
	{		
		 Node removed = queue.removeFirst();
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		 System.out.print(removed.key+" ");
	}
	
}
public int depth(Node node)
{
	int depth = -1;
	while(node!=null)
	{
		depth++;
		node = node.Parent;
	}
	return depth;
}

}

