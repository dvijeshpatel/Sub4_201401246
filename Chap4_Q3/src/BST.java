import java.util.Collection;
import java.util.LinkedList;


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
public void inOrder(Node node)
{
	if(node==null)
		return;
	inOrder(node.leftChild);
	System.out.print(node.key+" ");
	inOrder(node.rightChild);
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

public int totalE(Node temp)
{
	int totalE;
	if(temp.leftChild==null && temp.rightChild==null)
		return 0;
	if(temp.leftChild==null && temp.rightChild!=null)
	 totalE = 1 + totalE(temp.rightChild);
	if(temp.leftChild!=null && temp.rightChild==null)
		 totalE = 1 + totalE(temp.leftChild);
	else
		 totalE = 2 + totalE(temp.leftChild);
	return totalE;
}
public void Successor(Node node)
{
	if(node.rightChild!=null)
		System.out.println(Min(node.rightChild));
	else
	{
		while(node.Parent!=null && node != node.Parent.leftChild)
		node = node.Parent;
		if(node.Parent!=null)
		System.out.println(node.Parent.key);
	}
	
}
public void Predessour(Node node)
{
	if(node.leftChild!=null)
		System.out.println(Max(node.leftChild));
	else
	{
		while(node.Parent!=null && node != node.Parent.rightChild)
		{
			node = node.Parent;
		}
		if(node.Parent!=null)
		System.out.println(node.Parent.key);
	}
}
public int Min(Node node)
{
	Node pre = null;
	while(node!=null)
	{
		pre= node;
		node = node.leftChild;
	}
	return pre.key;
}
public int Max(Node node)
{
	Node pre = null;
	while(node!=null)
	{
		pre = node;
		node = node.rightChild;
	}
	return pre.key;
}
}