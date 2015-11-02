import java.util.LinkedList;


public class BST 
{
static Node root;
BST(Node root)
{
	BST.root = root;
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
		this.AVLRestore(node);
	}
	if(pre.key>node.key)
	{
		pre.leftChild = node;
		node.Parent =pre;
		this.AVLRestore(node);
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
public Node delete(Node node)
{
	/*if(node.leftChild==null && node.rightChild==null)
	{
		if(node==root)
		{	root = null;
		return;
		}
		else if(node ==node.Parent.leftChild)
			{
			node.Parent.leftChild = null;
			return;
			}
		else if(node == node.Parent.rightChild)
		{
			node.Parent.rightChild = null;
			return;
		}
		this.deleteRestore(node.Parent);
	}
	else if(node.leftChild==null)
	{
		if(node==node.Parent.leftChild)
		{
			Node tmp = node.Parent;
			tmp.leftChild = node.rightChild;
			node.rightChild.Parent = tmp;
		}
		if(node==node.Parent.rightChild)
		{
			Node tmp = node.Parent;
			tmp.rightChild = node.rightChild;
			node.rightChild.Parent = tmp;
		}
		this.deleteRestore(node);
	}
	else if(node.rightChild==null)
	{
		if(node==node.Parent.leftChild)
		{
			Node tmp = node.Parent;
			tmp.leftChild = node.leftChild;
			node.leftChild.Parent = tmp;
		}
		if(node==node.Parent.rightChild)
		{
			Node tmp = node.Parent;
			tmp.rightChild = node.leftChild;
			node.leftChild.Parent = tmp;
		}
	}
	else 
	{
		Node temp  = this.Successor(node);
		delete(temp);
		if(node == node.Parent.leftChild)
			node.Parent.leftChild = temp;
		else
			node.Parent.rightChild = temp;
		if(node.leftChild!=null)
		{node.leftChild.Parent = temp;
			temp.leftChild = node.leftChild;
		}
		if(node.rightChild!=null)
		{
			node.rightChild.Parent = temp;
			temp.rightChild = node.rightChild;
		}
		this.deleteRestore(node);
	}*/
	if(node.leftChild==null && node.rightChild==null)
	{
		Node temp = node.Parent;
		if(node==root)
		{	root = null;
		}
		 
		else if(node ==node.Parent.leftChild)
		{
			node.Parent.leftChild = null;
		}
		else if(node == node.Parent.rightChild)
		{
			node.Parent.rightChild = null;
		}
		if(temp!=null)this.deleteRestore(temp);
		return node;
		
	}
	else if(node.leftChild==null)
	{
		Node temp = node.Parent;
		if(node==node.Parent.leftChild)
		{
			Node tmp = node.Parent;
			tmp.leftChild = node.rightChild;
			node.rightChild.Parent = tmp;
			node.Parent = null;
			node.rightChild = null;
		}
		else	if(node==node.Parent.rightChild)
		{
			Node tmp = node.Parent;
			tmp.rightChild = node.rightChild;
			node.rightChild.Parent = tmp;
			node.Parent = null;
			node.rightChild = null;
		}
		if(temp!=null)this.deleteRestore(temp);
		return node;
	}
	else if(node.rightChild==null)
	{
		Node temp = node.Parent;
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
		if(temp!=null)this.deleteRestore(temp);
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
}public  void deleteRestore(Node x)
{
while(x!=null)
{
		if(this.height(x.rightChild)-this.height(x.leftChild)==-2)
		{
			if(height(x.leftChild.rightChild)-height(x.leftChild.leftChild)==1)
			{
				BST.leftRotate(x.leftChild);
			}
			this.rightRotate(x);
		}
		else if(this.height(x.rightChild)-this.height(x.leftChild)==2)
		{
		
			if(height(x.rightChild.rightChild)-height(x.rightChild.leftChild)==-1)
			{
				this.rightRotate(x.rightChild);
			}
			BST.leftRotate(x);
		}
	x = x.Parent;
}
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

public void AVLRestore(Node x)
{
	//System.out.println(x.key);
	while((x!=null )&& ((this.height(x.rightChild)-this.height(x.leftChild)==1)||(this.height(x.rightChild)-this.height(x.leftChild)==0)||(this.height(x.rightChild)-this.height(x.leftChild)==-1)))
	{
		x = x.Parent;
	}
	if(x!=null)
	{
		if(this.height(x.rightChild)-this.height(x.leftChild)==-2)
		{
			if(height(x.leftChild.rightChild)-height(x.leftChild.leftChild)==1)
			{
				BST.leftRotate(x.leftChild);
			}
			this.rightRotate(x);
		}
		else if(this.height(x.rightChild)-this.height(x.leftChild)==2)
		{
		
			if(height(x.rightChild.rightChild)-height(x.rightChild.leftChild)==-1)
			{
				this.rightRotate(x.rightChild);
			}
			BST.leftRotate(x);
		}
	}
}


}
