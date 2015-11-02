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
	System.out.println("Inorder recurse");
	bst.inOrder(bst.root);
	System.out.println();
	System.out.println("Inorder Iterative");
	bst.inOrderIter(bst.root);
	System.out.println();

	System.out.println("Preorder recurse");
	bst.PreOrder(bst.root);
	System.out.println();
	System.out.println("Preorder Iterative");
	bst.preOrderIter(bst.root);
	System.out.println();
	

	System.out.println("Postorder recurse");
	bst.PostOrder(bst.root);
	System.out.println();
	System.out.println("Postorder Iterative");
	bst.postOrderIter(bst.root);
	System.out.println();
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(bst.root);
	
	System.out.println("Level order");
	bst.levelOrder(queue);
	System.out.println();
	
	LinkedList<Node> queue2 = new LinkedList<Node>();
	queue2.addFirst(bst.root);
	
	System.out.println("ZigZag order");
	bst.zigzagOrder(bst.root);
	System.out.println();
}
}