import java.util.Collection;
import java.util.LinkedList;


public class BST 
{
Node root;
BST(Node root)
{
	this.root = root;
}
public void insert(Node node)
{
	Node temp = root;
	Node pre = null;
	while(temp!=null)
	{
		pre = temp;
		if(temp.key>node.key)
			temp = temp.leftChild;
		else if(temp.key<node.key)
			temp = temp.rightChild;
	}
	if(pre.key<node.key)
	{
		pre.rightChild = node;
		node.Parent = pre;
	}
	if(pre.key>node.key)
	{
		pre.leftChild = node;
		node.Parent =pre;
	}
}
public int TotalElementInSub(Node node,int count)
{
	if(node==null)
		return 0;
	int left = TotalElementInSub(node.leftChild,count);
	int right =TotalElementInSub(node.rightChild,count);
	count  = 1 + left+right;
	return count;
}
public void LocateLinks(int brk)
{
	int treeSize = this.TotalElementInSub(root, 0);
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(root);
	BST bst1= null;
	BST bst2 = null;
	int brk1 = this.TotalElementInSub(root, 0)/3;
	int brk2 = this.TotalElementInSub(root, 0)/3;
	while(brk1<=this.TotalElementInSub(root, 0)|| brk2 >=0)
	{	
		if(bst1==null || bst2==null)
		{
		 Node removed = queue.removeFirst();
		 int subsize = this.TotalElementInSub(removed, 0);
		 int parentSubtreeSize = this.TotalElementInSub(removed.Parent,0);
		 if(subsize==brk1 || subsize==brk2)
		 {
			 if(removed == removed.Parent.leftChild)
				 removed.Parent.leftChild = null;
			 if(removed == removed.Parent.rightChild)
				 removed.Parent.rightChild = null;
			 removed.Parent = null;
			// if(bst1==null)
			 //bst1 = new BST(removed);
			 //else if(bst2==null)
				// bst2 = new BST(removed);
			if(bst1==null)
			{
				bst1 = new BST(removed);
				brk1 = this.TotalElementInSub(root, 0);
				brk2 = this.TotalElementInSub(root, 0);
			}
			else if(bst2==null) 
			{
				bst2 = new BST(removed);
				brk1 = this.TotalElementInSub(root, 0);
				brk2 = this.TotalElementInSub(root, 0);
			}
			else
			 break;
			 
		 }
		 else
		 {
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		
		 }
		
		 if(queue.isEmpty())
		 {
			 queue.addLast(root);
			 brk1++;
			 brk2--;
		
		 }
		}
		else 
			break;
		
	}
	/*while(brk2>=0)
	{		
		 Node removed = queue.removeFirst();
		 int subsize = this.TotalElementInSub(removed, 0);
		 int parentSubtreeSize = this.TotalElementInSub(removed.Parent,0);
		 if(subsize==brk2)
		 {
			 if(removed == removed.Parent.leftChild)
				 removed.Parent.leftChild = null;
			 if(removed == removed.Parent.rightChild)
				 removed.Parent.rightChild = null;
			 removed.Parent = null;
			// if(bst1==null)
			 //bst1 = new BST(removed);
			 //else if(bst2==null)
				// bst2 = new BST(removed);
			 bst2 = new BST(removed);
			 break;
			 
		 }
		 else
		 {
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		
		 }
		 if(queue.isEmpty())
		 {
			 queue.addLast(root);
			 brk2--;
		 }
			
	}*/
	System.out.println("Printing Breaked Subtrees in LevelorderTravellsor");
	this.LevelOrder(root);
	System.out.println();
	bst1.LevelOrder(bst1.root);
	System.out.println();
	bst2.LevelOrder(bst2.root);
	

}
public void LevelOrder(Node node)
{
	LinkedList<Node> queue = new LinkedList<Node>();
	queue.addFirst(node);
	while(!queue.isEmpty())
	{		
		 Node removed = queue.removeFirst();
		 if(removed.leftChild!=null)
				queue.addLast(removed.leftChild);
		 if(removed.rightChild!=null)
				queue.addLast(removed.rightChild);
		 System.out.print(removed.key+" ");
	}
	
}

}

