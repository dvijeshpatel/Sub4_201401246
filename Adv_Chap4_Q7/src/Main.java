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
	
	System.out.println("Enter key ");
	int key = s.nextInt();
	Node k = bst.search(key);
	if(k!=null)
		System.out.println("Found "+ k.key);
	else
		System.out.println("Not Found");
	Node succ = bst.succesor(key);
	if(succ!=null)
		System.out.println("Successor "+succ.key);
	else
		System.out.println("No successor found");
	System.out.println("Max "+ bst.max(bst.root).key);
}
}