import java.util.Scanner;


public class Main 
{
	public static void main(String args[])
	{
	System.out.println("How many number do you want?");
	Scanner s =new Scanner(System.in);
	int n = s.nextInt();
	System.out.println("Enter element and  cost");
	int key = s.nextInt();
	int cost = s.nextInt();
	Node root= new Node(key,cost);
	BST bst  = new BST(root);
	for(int i=1;i<n;i++)
	{
		System.out.println("Enter element and  cost");
		Node temp = new Node(s.nextInt(),s.nextInt());
		bst.insert(temp);
	}
	bst.buildHeap(bst.root);
	bst.levelOrder(bst.root);
	}
}
