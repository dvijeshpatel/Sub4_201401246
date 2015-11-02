import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;


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
public void inOrder(Node node)
{
	if(node==null)
		return;
	inOrder(node.leftChild);
	System.out.print(node.key+" ");
	inOrder(node.rightChild);
}
public void postOrderIter(Node node)
{
	String horizontal = "left";
	String vertical = "down";
	Node curr = root;
	while(curr!=root || !vertical.equals("up")||!horizontal.equals("left"))
	{
		if(((curr.leftChild==null && curr.rightChild==null)||(horizontal.equals("left")&&vertical.equals("up"))||(horizontal.equals("right")&&vertical.equals("up")&&curr.rightChild==null)))
			System.out.print(curr.key+" ");
		if(curr.leftChild!=null && vertical.equals("down"))
		{
			curr = curr.leftChild;
			vertical = "down";
			horizontal = "left";
		}
		else if(curr.rightChild!=null &&( (horizontal.equals("right")&& vertical.equals("up")||(horizontal.equals("left")&&vertical.equals("down")))))
		{
			vertical = "down";
			horizontal = "right";
			curr = curr.rightChild;
		}
		else if(curr.rightChild==null)
		{
			vertical = "up";
			if(curr.Parent!=null)
			{
			if(curr== curr.Parent.leftChild)
				horizontal = "right";
			else
				horizontal = "left";
			curr= curr.Parent;
			}
		}
		else if(horizontal.equals("left")&&vertical.equals("up"))
		{
			if(curr.Parent!=null)
			{
	
				if(curr == curr.Parent.leftChild)
					horizontal =  "right";
				else
					horizontal = "left";
				vertical = "up";
				curr = curr.Parent;
			}
		}
		
	}
	System.out.print(curr.key+" ");

}
public void preOrderIter(Node node)
{

	String horizontal = "left";
	String vertical = "down";
	Node curr = root;
	while(curr!=root || !vertical.equals("up")||!horizontal.equals("left"))
	{
		if(vertical.equals("down"))
			System.out.print(curr.key+" ");
		if(curr.leftChild!=null && vertical.equals("down"))
		{
			curr = curr.leftChild;
			vertical = "down";
			horizontal = "left";
		}
		else if(curr.rightChild!=null &&( (horizontal.equals("right")&& vertical.equals("up")||(horizontal.equals("left")&&vertical.equals("down")))))
		{
			vertical = "down";
			horizontal = "right";
			curr = curr.rightChild;
		}
		else if(curr.rightChild==null)
		{
			vertical = "up";
			if(curr.Parent!=null)
			{
			if(curr== curr.Parent.leftChild)
				horizontal = "right";
			else
				horizontal = "left";
			curr= curr.Parent;
			}
		}
		else if(horizontal.equals("left")&&vertical.equals("up"))
		{
			if(curr.Parent!=null)
			{
	
				if(curr == curr.Parent.leftChild)
					horizontal =  "right";
				else
					horizontal = "left";
				vertical = "up";
				curr = curr.Parent;
			}
		}
		
	}

}
public void inOrderIter(Node node)
{

	String horizontal = "left";
	String vertical = "down";
	Node curr = root;
	while(curr!=root || !vertical.equals("up")||!horizontal.equals("left"))
	{
		if((vertical.equals("up")&&horizontal.equals("right"))&& curr.rightChild==null)
			System.out.print(curr.key+" ");
		if(curr.leftChild!=null && vertical.equals("down"))
		{
			curr = curr.leftChild;
			vertical = "down";
			horizontal = "left";
		}
		else if(curr.rightChild!=null &&( (horizontal.equals("right")&& vertical.equals("up")||(horizontal.equals("left")&&vertical.equals("down")))))
		{
			System.out.print(curr.key+" ");
			vertical = "down";
			horizontal = "right";
			curr = curr.rightChild;
		}
		else if(curr.rightChild==null)
		{
			if(curr.leftChild==null)
				System.out.print(curr.key+" ");
			vertical = "up";
			if(curr.Parent!=null)
			{
			if(curr== curr.Parent.leftChild)
				horizontal = "right";
			else
				horizontal = "left";
			curr= curr.Parent;
			}
		}
		else if(horizontal.equals("left")&&vertical.equals("up"))
		{
			if(curr.Parent!=null)
			{
	
				if(curr == curr.Parent.leftChild)
					horizontal =  "right";
				else
					horizontal = "left";
				vertical = "up";
				curr = curr.Parent;
			}
		}
		
	}
	
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
public void zigzagOrder(Node node)
{

	Stack<Node> stack1 = new Stack<Node>();
	Stack<Node> stack2 = new Stack<Node>();
	int level = 0;
	stack1.push(node);
while(!stack1.isEmpty() || !stack2.isEmpty())
	{
	if(level%2==0)
	{
		while(!stack1.isEmpty())
		{
			Node temp = stack1.pop();
			System.out.print(temp.key+" ");
			if(temp.leftChild!=null)stack2.push(temp.leftChild);
			if(temp.rightChild!=null)stack2.push(temp.rightChild);
		}
		level++;
	}
	if(level%2==1)
	{
		while(!stack2.isEmpty())
		{
			Node temp = stack2.pop();
			System.out.print(temp.key+" ");
			if(temp.rightChild!=null)stack1.push(temp.rightChild);
			if(temp.leftChild!=null)stack1.push(temp.leftChild);
		}
		level++;
	}
	}
}
public int height(Node temp)
{
	if(temp.leftChild==null && temp.rightChild==null)
		return 0;
	int hleft = 1 + height(temp.leftChild);
	int hright = 1 + height(temp.rightChild);
	return Math.max(hleft, hright);
}
}
