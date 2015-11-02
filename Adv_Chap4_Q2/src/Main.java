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
	root.level=0;
	for(int i=1;i<n;i++)
	{
		Node temp = new Node(s.nextInt());
		bst.insert(temp);
	}
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.add(root);
	System.out.println("Inversion");
	System.out.println(bst.inversion(queue));
}
}