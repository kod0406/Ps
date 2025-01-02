import java.util.Scanner;
public class Main {

	public static int[] stack;
	public static int index = 0;
 
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = in.nextInt();
 
		stack = new int[N];
		
		for(int i = 0; i < N; i++) {
        
			String str = in.next();
 
			switch (str) {
            
			case "push":
				push(in.nextInt());
				break;
                
			case "pop":
				sb.append(pop()).append('\n');
				break;
                
			case "size":
				sb.append(size()).append('\n');
				break;
                
			case "empty":
				sb.append(empty()).append('\n');
				break;
                
			case "top":
				sb.append(top()).append('\n');
				break;
			}
 
		}
		System.out.println(sb);
	}
 
	public static void push(int item) {
		stack[index] = item;
		index++;
	}
    
	public static int pop() {
		if(index == 0) {
			return -1;
		}
		else {
			int res = stack[index - 1];
			stack[index - 1] = 0;
			index--;
			return res;
		}
	}
    
	public static int size() {
		return index;
	}
    
	public static int empty() {
		if(index == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
    
	public static int top() {
		if(index == 0) {
			return -1;
		}
		else {
			return stack[index - 1];
		}
	}
	
}