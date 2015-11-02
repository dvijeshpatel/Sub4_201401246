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
public int TotalElementInSub(Node node,int count)
{
	if(node==null)
		return 0;
	int left = TotalElementInSub(node.leftChild,count);
	int right =TotalElementInSub(node.rightChild,count);
	count  = 1 + left+right;
	return count;
}
public int orderint(Node node)
{
	int count;
	if(node.leftChild==null && node.rightChild==null)
		return 1;
	else
	{
		int total = this.TotalElementInSub(node,0);
		total--;
		int left = this.TotalElementInSub(node.leftChild, 0);
		int right = this.TotalElementInSub(node.rightChild, 0);
		if(node.leftChild!=null)
		{
			cout = (left+right)
		}
	}
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

}

