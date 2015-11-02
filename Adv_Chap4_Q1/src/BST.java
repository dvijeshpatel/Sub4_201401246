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

public int rank(Node temp)
{
	int rank=0;
	Node node = root;
	while(node!=temp)
	{
		if(node.key>temp.key)
			node = node.leftChild;
		if(node.key<temp.key)
		{
		
			rank = rank + this.TotalElementInSub(node.leftChild,0);
			rank = rank+1;
			node = node.rightChild;
		}
	}
	rank = rank + this.TotalElementInSub(temp.leftChild, 0);
	rank = rank +1;
	return rank;
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
public void inOrder(Node node)
{
	if(node==null)
		return;
	inOrder(node.leftChild);
	System.out.print(node.key+" ");
	inOrder(node.rightChild);
}
public int depth(Node temp)
{
	int depth = 0;
	while(temp!=null)
	{
		temp = temp.Parent;
		depth++;
	}
	depth--;
	return depth;
}
public boolean TreeExist(int lowrank,int heighrank)
{
	Node tmp = root;
	
	while(tmp!=null)
	{	
		int midrank = this.rank(tmp);
		if(lowrank<=midrank&& midrank<=heighrank && this.rank(this.Min(tmp)) == lowrank && this.rank(this.Max(tmp)) ==  heighrank)
		{
			System.out.println("Sub tree Exist: root: "+ tmp.key);
			return true;
		}
		else if(midrank< lowrank && midrank <heighrank)
		{
		tmp = tmp.rightChild;
		}
		else if(midrank > lowrank && midrank > heighrank)
		{
		tmp = tmp.leftChild;
		}
		else
			return false;
	}
	return false;
	
}

public int TotalElementInSub(Node node,int count)
{
	if(node==null)
		return 0;
	int left = TotalElementInSub(node.leftChild,count);
	int right =TotalElementInSub(node.rightChild,count);
	count  = 1 + left+right;
	return count;
}
public Node Min(Node temp)
{
	while(temp.leftChild!=null)
	{
		temp = temp.leftChild;
	}
	return temp;
}
public Node Max(Node temp)
{
	while(temp.rightChild!=null)
	{
		temp = temp.rightChild;
	}
	return temp;
}
}
