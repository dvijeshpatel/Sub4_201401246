import java.util.ArrayList;
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
	ArrayList<Integer> beforeDepths = bst.visitCalculatedepths(bst.root);
	System.out.println("Enter key of node to Leftrotate");
	int key  = s.nextInt();
	Node x = bst.search(key);
	bst.leftRotate(x);
	ArrayList<Integer>  afterDepths = bst.visitCalculatedepths(bst.root);
	int sum=0;
	System.out.println(beforeDepths.toString());
	System.out.println(afterDepths.toString());
	for(int i=0;i<beforeDepths.size();i++)
		sum = sum+ beforeDepths.get(i);
	float average1 = (float)sum / (float) beforeDepths.size();
	sum = 0;
	for(int i=0;i<afterDepths.size();i++)
		sum = sum+ afterDepths.get(i);
	float average2 = (float) sum / (float) afterDepths.size();
	System.out.println("Average depth difference : "+ (average2 - average1));
}

}
