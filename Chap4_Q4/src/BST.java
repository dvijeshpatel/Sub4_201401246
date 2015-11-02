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
public Node delete(Node node)
{
	if(node.leftChild==null && node.rightChild==null)
	{
		if(node==root)
		{	root = null;
		    return node;
		}
		else if(node ==node.Parent.leftChild)
		{
			node.Parent.leftChild = null;
			return node;
		}
		else if(node == node.Parent.rightChild)
		{
			node.Parent.rightChild = null;
			return node;
		}
	}
	else if(node.leftChild==null)
	{
		if(node==node.Parent.leftChild)
		{
			Node tmp = node.Parent;
			tmp.leftChild = node.rightChild;
			node.rightChild.Parent = tmp;
			node.Parent = null;
			node.rightChild = null;
		}
		else if(node==node.Parent.rightChild)
		{
			Node tmp = node.Parent;
			tmp.rightChild = node.rightChild;
			node.rightChild.Parent = tmp;
			node.Parent = null;
			node.rightChild = null;
		}
		return node;
	}
	else if(node.rightChild==null)
	{
		if(node==node.Parent.leftChild)
		{
			Node tmp = node.Parent;
			tmp.leftChild = node.leftChild;
			node.leftChild.Parent = tmp;
			node.Parent = null;
			node.leftChild = null;
		}
		else if(node==node.Parent.rightChild)
		{
			Node tmp = node.Parent;
			tmp.rightChild = node.leftChild;
			node.leftChild.Parent = tmp;
			node.Parent = null;
			node.leftChild = null;
		}
		return node;
	}
	else 
	{
		Node temp  = this.Successor(node);
		Node x = delete(temp);
		if(node.Parent==null)
			root = x;
		x.Parent = node.Parent;
		node.Parent = null;
		x.leftChild = node.leftChild;
		x.rightChild = node.rightChild;
		node.leftChild = null;
		node.rightChild = null;
		return node;
	}
	return null;
}

public Node Successor(Node node)
{
	if(node.rightChild!=null)
	   return this.Min(node.rightChild);
	else
	{
		while(node.Parent!=null && node != node.Parent.leftChild)
		node = node.Parent;
		if(node.Parent!=null)
		return node.Parent;
		else return null;
	}
	
}
public Node Min(Node node)
{
	Node pre = null;
	while(node!=null)
	{
		
		pre = node;
		node = node.leftChild;
	}
	return pre;
}
}