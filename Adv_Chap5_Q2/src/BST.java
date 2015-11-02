import java.util.Collection;
import java.util.LinkedList;

import javax.xml.transform.Templates;


public class BST 
{
Node root;
public static int count=0;
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
public void MinHeapify(Node node)
{
	if(node == null)
		return;
	Node min = node;
	if(node.leftChild!=null)
	{
		if(node.leftChild.cost<min.cost)
			min = node.leftChild;
	}
	if(node.rightChild!=null)
	{
		if(node.rightChild.cost<min.cost)
			min= node.rightChild;
	}
	if(min ==  node.rightChild)
	{
		this.leftRotate(node);
	}
	if(min == node.leftChild)
	{
		this.rightRotate(node);
	}
	if(min!=node)
	MinHeapify(min);
	
}
public void levelOrder(Node node)
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
		 System.out.print("key: "+removed.key+" Cost: "+removed.cost);
		 System.out.println();
	}
}
public void buildHeap(Node node)
{
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(node);
	while(!queue.isEmpty())
	{		
		int left = 0,right = 0;
		 Node removed = queue.removeFirst();
		 Node temp = removed.Parent;
		 if(removed==root)
		 {
			 this.MinHeapify(removed);
			 if(root.leftChild!=null)
					queue.addLast(root.leftChild);
			 if(root.rightChild!=null)
					queue.addLast(root.rightChild); 
		 }
		 else
		 {
		 if(temp.leftChild!= null && temp.leftChild == removed)
			 left = 1;
		 if(temp.rightChild!=null && temp.rightChild == removed)
			 right = 1;
		 this.MinHeapify(removed);
		 if(left==1)
		 {
		 if(temp.leftChild.leftChild!=null)
				queue.addLast(temp.leftChild.leftChild);
		 if(temp.leftChild.rightChild!=null)
				queue.addLast(temp.leftChild.rightChild);
		 }
		 if(right ==1 )
		 {
			 if(temp.rightChild.leftChild!=null)
					queue.addLast(temp.rightChild.leftChild);
			 if(temp.rightChild.rightChild!=null)
				queue.addLast(temp.rightChild.rightChild);
		 }
		 }
	}
	
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

public int height(Node temp)
{
	if(temp.leftChild==null && temp.rightChild==null)
		return 0;
	int hleft = 0 ,hright = 0;
	if(temp.leftChild!=null)
	hleft = 1 + height(temp.leftChild);
	if(temp.rightChild!=null)
	hright = 1 + height(temp.rightChild);
	return Math.max(hleft, hright);
}

}