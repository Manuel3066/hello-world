package stackFIx;
import java.util.Scanner;

public class stackPostTester {
	public static void main(String[] args) {
		String input, output; 
		Scanner in = new Scanner(System.in);
		while (true) 
		{
			 System.out.println("Enter infix: ");
			 input = in.nextLine();
			 if(input.equals(""))
				 break;
			 fixPost theTrans = new fixPost(input);
			 output = theTrans.transLate();
			 System.out.println("PostFix is " + output + '\n');
			 
		}
		in.close();
	}

}
