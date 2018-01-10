package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @class Main10828
 * @author LDCC
 * @description 백준 10828번 스택
 */
public class Main10828 {
	
	private static final int COMMAND = 0;
	private static final int VALUE = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		String[] input;
		Stack<String> stack = new Stack<String>();
		
		while (testCase-- > 0) {
			input = br.readLine().split(" ");
			switch (input[COMMAND]) {
				case "push":
					stack.push(input[VALUE]);
					break;
				case "pop":
					System.out.println((stack.isEmpty() == true) ? "-1" : stack.pop());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println((stack.isEmpty() == true) ? "1" : "0");
					break;
				case "top":
					System.out.println((stack.isEmpty() == true) ? "-1" : stack.peek());
					break;
			}
		}
	}
}
