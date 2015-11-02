import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		BinaryStree bs = new BinaryStree();
		Scanner sc = new Scanner(System.in);
		System.out.println("Write the Value of Height");
		System.out.println(bs.SameLevelZigzag(sc.nextInt()+1));
			
	}
}
