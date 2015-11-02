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
	//bst.inOrder(root);
	System.out.println("Enter element ");
	int k = s.nextInt();
	Node node = bst.search(k);
	if(node == null)
		System.out.println("Not found");
	else
		System.out.println("Found "+ node.key);
	System.out.println("Successor ");
	bst.Successor(node);
	System.out.println("Predessor ");
	bst.Predessour(node);
	System.out.println("Max ");
	System.out.println(bst.Max(root));
	System.out.println("Min ");
	System.out.println(bst.Min(root));
	}
}
