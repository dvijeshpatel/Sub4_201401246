
public class BinaryStree {
	Node root;
	public int SameLevelZigzag(int h){
		int op = 0;
		if(h == 1)
			op = 1;
		else if(h == 2)
			op = 2;
		else 
			op = (int)(2 * (Math.pow(8, (h-2)/2)) * (Math.pow(3, (h-2)%2)));
		return op;
	}
	
}
