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
	System.out.println("Enter element for quering");
	int q = s.nextInt();
	Node query = bst.search(q);
	System.out.println("Height: "+bst.height(query));
	System.out.println("Depth: "+bst.depth(query));
	System.out.println("Size subtree: "+bst.TotalElementInSub(query, 0));
	System.out.println("rank: "+bst.rank(query));
	bst.inOrder(root);
	System.out.println("Enter lowRank and HighRank");
	int lr = s.nextInt();
	int hr = s.nextInt();
	System.out.println(bst.TreeExist(lr, hr));
	System.out.println("Enter key of node which root  find range");
	int k = s.nextInt();
	Node key = bst.search(k);
	System.out.println("low rank "+ bst.rank(bst.Min(key))+ " High rank "+ bst.rank(bst.Max(key)));
	}
}
