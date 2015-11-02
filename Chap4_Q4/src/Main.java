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
	bst.inOrder(root);
	System.out.println();
	System.out.println("Enter element to Insert");
	int k = s.nextInt();	
	Node node = new Node(k);
	bst.insert(node);
	bst.inOrder(bst.root);
	System.out.println();
	System.out.println("Enter element to Delete");
	int d = s.nextInt();
	Node delete = bst.search(d);
	Node deleted = bst.delete(delete);
	if(deleted!=null)
		System.out.println("Deleted : "+ deleted.key);
	else
		System.out.println("No valid deletion");
		bst.inOrder(bst.root);
	}
}
