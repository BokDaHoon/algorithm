package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @class Main1406
 * @author DaHoon Bok
 * @description 백준 1406번 에디터
 */
public class Main1406 {
	
	private static final int COMMAND = 0;
	private static final int VALUE = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String initStr = br.readLine();
		int cmdCount = Integer.parseInt(br.readLine());
		
		Stack<Character> leftStack = new Stack<Character>();
		Stack<Character> rightStack = new Stack<Character>();
		
		int length = initStr.length();
		for (int i = 0; i < length; i++) {
			leftStack.push(initStr.charAt(i));
		}
			
		while (cmdCount-- > 0) {
			String[] input = br.readLine().split(" ");
			
			switch (input[COMMAND]) {
				case "L":
					if (!leftStack.isEmpty()) {
						rightStack.push(leftStack.pop());						
					}
					break;
				case "D":
					if (!rightStack.isEmpty()) {
						leftStack.push(rightStack.pop());						
					}
					break;
				case "B":
					if (!leftStack.isEmpty()) {						
						leftStack.pop();
					}
					break;
				case "P":
					leftStack.push(input[VALUE].charAt(0));
					break;
			}
		}
		
		while (!leftStack.isEmpty()) {
			rightStack.push(leftStack.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}
		
		System.out.println(sb.toString());
	}
}
