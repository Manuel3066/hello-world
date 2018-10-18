package stackFIx;

/*
 * Manuel Corral Ledezma, mcorralledezma@dmacc.edu, September 24 ,2018
 * This code changes infix to postfix
 * Most of the code is borrowed from the book data structures and algoritims in java second edition by robert lafore
 * I rewrote the variables to show some originality. the book was my only guide throught out this program.
 * As such most of the code is borrowed
 * No plagiarism intended
 * 
 */
public class Stackpostfix {
	int top;
	int capacity = 5;
	private char[] stack;

	public Stackpostfix() {
		top = -1;
		stack = new char[capacity];
	}

	public Stackpostfix(int s) {
		capacity = s;
		stack = new char[capacity];
		top = -1;

	}

	public void print() {
		for (int i = 0; i < capacity; i++) {
			System.out.println("Item number " + i + ": " + stack[i]);
		}
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public void push(char item) {

		stack[++top] = item;
	}

	public int size() {
		return capacity;
	}

	public char pop() {

		return stack[top--];

	}

	public char top() {
		return stack[top];
	}
}

class fixPost {
	private Stackpostfix theStack;
	private String input;
	private String output = "";

	public fixPost(String in) {
		input = in;
		int stackSize = input.length();
		theStack = new Stackpostfix(stackSize);
	}

	public String transLate() {
			for(int j = 0; j< input.length(); j++) {
				
				char ch = input.charAt(j);
				switch(ch)
				{
				case '+': 
				case '-':
				gotOper(ch, 1); 
				break; 
				case '*':
				case '/':
				gotOper(ch, 2);
				break; 
				case '(': 
				theStack.push(ch); 
				break;
				case ')': 
				gotParen(ch); 
				break;
				default: 
				output = output + ch; 
				break;
				} 
				} 
			while(!theStack.isEmpty())
			{
				output = output + theStack.pop();
			}
			return output;	
			}

	public void gotOper(char opThis, int prec1) {
		while (!theStack.isEmpty()) {
			char opTop = theStack.pop();
			if (opTop == '(') {
				theStack.push(opTop);
				break;
			}
			else
			{
				int prec2;
				if(opTop == '+' || opTop == '-')
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2 < prec1) 
				{
					theStack.push(opTop);
					break;
				}
				else 
					output = output + opTop;

			}
		}
		theStack.push(opThis);
	}
	
	public void gotParen(char ch) {
		while(!theStack.isEmpty())
		{
			char chx = theStack.pop();
			if(chx == '(' ) 
				break;
			else
				output = output + chx;
		}
	}

}

