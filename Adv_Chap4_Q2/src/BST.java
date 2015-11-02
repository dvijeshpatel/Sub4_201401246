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
		node.level = this.depth(node);
	}
	if(pre.key>node.key)
	{
		pre.leftChild = node;
		node.Parent =pre;
		node.level = this.depth(node);
	}
}
public void inOrder(Node node)
{
	if(node==null)
		return;
	inOrder(node.leftChild);
	System.out.print(node.key+" ");
	inOrder(node.rightChild);
}
public void PostOrder(Node node)
{
	if(node==null)
		return;
	PostOrder(node.leftChild);
	PostOrder(node.rightChild);
	System.out.print(node.key+" ");
}
public void PreOrder(Node node)
{
	if(node==null)
		return;
	System.out.print(node.key+" ");
	PreOrder(node.leftChild);
	PreOrder(node.rightChild);
	
}
public void levelOrder(LinkedList<Node> queue)
{
if(queue.isEmpty())
	return;
Node temp = queue.removeFirst();
System.out.print(temp.key+" ");
if(temp.leftChild!=null)
queue.addLast(temp.leftChild);
if(temp.rightChild!=null)
queue.addLast(temp.rightChild);
levelOrder(queue);
}
public int depth(Node temp)
{
	int depth = 0;
	while(temp!=null)
	{
		//System.out.println(temp.key);
		temp = temp.Parent;
		//System.out.println(temp.key);
		depth++;
	}
	depth--;
	return depth;
}
public int height(Node temp)
{
	if(temp.leftChild==null && temp.rightChild==null)
		return 0;
	int hleft = 1 + height(temp.leftChild);
	int hright = 1 + height(temp.rightChild);
	return Math.max(hleft, hright);
}
public int inversion(LinkedList<Node> queue)
{
	int level = 0;
	int inver = 0;
	while(!queue.isEmpty())
	{
		int levelTemp = 0;
		Node pre = null;
		while(true)
		{
		 Node removed = queue.removeFirst();
		 if(pre!=null)
		 levelTemp = levelTemp + this.TotalElementInSub(pre, 0) - 1;
		 inver = inver + levelTemp + this.TotalElementInSub(removed.leftChild,0 );
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		if(queue.isEmpty() || queue.getFirst().level != level)
		{
				level++;
				break;
		}
			pre = removed;
		}
	
	}
	return inver;
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
}
