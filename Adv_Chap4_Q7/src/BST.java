

public class BST 
{
	Node root;
    BST(Node root) 
    {
      this.root = root;
    }
    public void insert(Node node)
    {
    	int count = 0;
        Node temp = root;
        Node pre = null;
        while(temp!=null)
    	{
    		pre = temp;
    		if(temp.key>node.key)
    		{
    			if(count%2==0)
    			temp = temp.leftChild;
    			else
    			temp = temp.rightChild;
    			count++;
    		}
    		else if(temp.key<node.key)
    		{
    			if(count%2==0)
    			temp = temp.rightChild;
    			else
    				temp = temp.leftChild;
    			count++;
    		}
    	}
    	if(pre.key<node.key)
    	{
    		if(count%2==1)
    		{
    		pre.rightChild = node;
    		node.Parent = pre;
    		}
    		else
    		{
    			pre.leftChild = node;
        		node.Parent =pre;
    		}
    	}
    	if(pre.key>node.key)
    	{
    		if(count%2==1)
    		{
    		pre.leftChild = node;
    		node.Parent =pre;
    		}
    		else
    		{
    			pre.rightChild = node;
        		node.Parent = pre;
    		}
    	}
    	
    }
    public Node search(int key)
    {
    	Node temp = root;
    	int count=0;
    	while(temp.key!=key&&temp!=null)
    	{
    		if(temp.key<key)
    		{	
    			if(count%2==0)
    				temp = temp.rightChild;
    			else
    				temp = temp.leftChild;
    			count++;
    		}
    		if(temp.key>key)
    		{
    			if(count%2==0)
    				temp = temp.leftChild;
    			else
    				temp = temp.rightChild;
    			count++;
    		}
    	}
    	return temp;
    }
    public Node max(Node node)
    {
    	Node temp = root;
    	int count = 0;
    	Node pre = null;
    	while(temp!=null)
    	{
    		pre = temp;
    		if(count%2==0)
    			temp = temp.rightChild;
    		else
    			temp = temp.leftChild;
    		count++;
    	}
    	return pre;
    }
    public Node succesor(int key)
    {
    	int level=0;
    	Node temp = root;
    	Node node = null;
    	while(temp!=null && temp.key!=key)
    	{
    		if(level%2==0)
    		{
    			if(key > temp.key)
    				temp = temp.rightChild;
    			else
    				temp = temp.leftChild;
    			level++;
    		}
    		else
    		{
    			if(key>temp.key)
    				temp = temp.leftChild;
    			else
    				temp = temp.rightChild;
    			level++;
    		}
    	}
    	if(level%2==0)
    	{
    		if(temp.rightChild!=null)
    			node = this.min(temp.rightChild, level+1);
    		else
    		{
    			while(temp.Parent!=null)
    			{
    				if(temp.Parent.key>temp.key)
    				{
    					node = temp.Parent;
    					break;
    				}
    				temp = temp.Parent;
    			}
    		}
    	}
    	else
    	{
    		if(temp.leftChild!=null)
    			node =  this.min(temp.leftChild, level+1);
    		else
    			{
    			while(temp.Parent!=null)
    			
			{
				if(temp.Parent.key>temp.key)
				{
					node = temp.Parent;
					break;
				}
				temp = temp.Parent;
			}
    			}
    	}
    	return node;
    }
	public Node min(Node node,int level)
	{
		Node temp = null;
		while(node!=null)
		{
			temp = node;
			if(level%2==0)
				node = node.leftChild;
			else
				node = node.rightChild;
			level++;
		}
		return temp;
	}

}
