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
		node.Parent = pre;
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
public int depth(Node temp)
{
	int depth = -1;
	while(temp != null)
	{
		temp= temp.Parent;
		depth++;
	}
	return depth;
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
public int totalE(Node temp,int count)
{
	if(temp==null)
		return 0;
	int left = totalE(temp.leftChild,count);
	int right = totalE(temp.rightChild,count);
	count = 1+ left+right;
	return count;
}
}
