import java.util.LinkedList;
import java.util.Scanner;
public class Main 
{
public static void main(String args[])
{
	System.out.println("How many number do you want?");
	Scanner s =new Scanner(System.in);
	int n = s.nextInt();
	System.out.println("Enter element ");
	Node root= new Node(s.nextInt());
	BST bst  = new BST(root);
	for(int i=1;i<n;i++)
	{
		Node temp = new Node(s.nextInt());
		bst.insert(temp);
		
	}
	bst.LevelOrder(bst.root);
	System.out.println("Enter key of node to Leftrotate");
	int key  = s.nextInt();
	Node x = bst.search(key);
	leftRotate(bst,x);
	bst.LevelOrder(bst.root);
	System.out.println("Enter key of node to roghtrotate");
	int key2  = s.nextInt();
	Node y = bst.search(key2);
	rightRotate(bst,y);
	bst.LevelOrder(bst.root);
}
public static void leftRotate(BST tree,Node x)
{
	Node y = x.rightChild;
	x.rightChild = y.leftChild;
	if(y.leftChild!=null)
		y.leftChild.Parent = x;
	y.Parent = x.Parent;
	if(x.Parent==null)
		tree.root = y;
	else if(x== x.Parent.leftChild)
		x.Parent.leftChild = y;
	else 
		x.Parent.rightChild = y;
	y.leftChild = x;
	x.Parent = y;
}
public static void rightRotate(BST tree,Node x)
{
	Node y= x.leftChild;
	x.leftChild = y.rightChild;
	if(y.rightChild!=null)
		y.rightChild.Parent = x;
	y.Parent = x.Parent;
	if(x.Parent==null)
		tree.root = y;
	else if(x == x.Parent.leftChild)
		x.Parent.leftChild = y;
	else 
		x.Parent.rightChild = y;
	y.rightChild = x;
	x.Parent = y;
}
}
