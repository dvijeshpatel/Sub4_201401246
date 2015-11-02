import java.util.LinkedList;


public class BST 
{
static Node root;
BST(Node root)
{
	BST.root = root;
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
public static void leftRotate(Node x)
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
public void FindNode(Node node)
{
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(node);
	while(!queue.isEmpty())
	{		
		 Node removed = queue.removeFirst();
		 if((height(removed.rightChild)-height(removed.leftChild)>1) || (height(removed.rightChild)-height(removed.leftChild)<-1))
		 {
			 System.out.println("Node found: "+ removed.key);
			 System.out.println("Minimizing difference");
			 this.minimizeDifference(removed);
			 break;
		 }
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		// System.out.print(removed.key+" ");
	}
	LinkedList<Node> queue2 = new LinkedList<Node>();
	queue2.addFirst(this.root);
	System.out.println("Printing resulting tree in level Order");
	while(!queue2.isEmpty())
	{		
		 Node temp = queue2.removeFirst();
		 if(temp.leftChild!=null)
				queue2.addLast(temp.leftChild);
		 if(temp.rightChild!=null)
				queue2.addLast(temp.rightChild);
		 System.out.print(temp.key+" ");
	}
	
}
public void minimizeDifference(Node x)
{
	restore(x.leftChild);
	restore(x.rightChild);
	restore(x);
}
public void restore(Node x)
{
	if(x!=null)
	{
	if(this.height(x.rightChild)-this.height(x.leftChild)<=-2)
	{
		if(height(x.leftChild.rightChild)-height(x.leftChild.leftChild)==1)
		{
			BST.leftRotate(x.leftChild);
		}
		this.rightRotate(x);
	}
	else if(this.height(x.rightChild)-this.height(x.leftChild)>=2)
	{
	
		if(height(x.rightChild.rightChild)-height(x.rightChild.leftChild)==-1)
		{
			this.rightRotate(x.rightChild);
		}
		BST.leftRotate(x);
	}
	}
}
public int height(Node temp)
{
	if(temp==null)
		return -1;
	int hleft = 0 ,hright = 0;
	if(temp.leftChild!=null)
	hleft = 1 + height(temp.leftChild);
	if(temp.rightChild!=null)
	hright = 1 + height(temp.rightChild);
	return Math.max(hleft, hright);
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
