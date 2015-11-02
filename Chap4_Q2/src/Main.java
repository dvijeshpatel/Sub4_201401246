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
	System.out.println("Enter key value node");
	int key = s.nextInt();
	Node knode = bst.search(key);
	System.out.println("Height");
	System.out.println(bst.height(knode));
	System.out.println("Depth");
	System.out.println(bst.depth(knode));
	System.out.println("Total element in subtree");
	System.out.println(bst.totalE(knode,0));
	
}
}
