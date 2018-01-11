package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @class Main10799
 * @author DaHoon Bok
 * @description 백준 10799번 쇠막대기
 */
public class Main10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int length = input.length();
		
		int barCount = 0;
		Stack<Integer> barStack = new Stack<Integer>();
		for (int i = 0; i < length - 1; i++) {
			if (input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
				barStack.push(barCount);
				i++;
				continue;
			}
			
			if (input.charAt(i) == '(') {
				barCount++;
			} else {
				barStack.push(1);
				barCount--;
			}
		}
		
		if (input.charAt(length - 1) == '(') {
			barCount++;
		} else {
			barStack.push(1);
			barCount--;
		}
		
		int result = 0;
		while (!barStack.isEmpty()) {
			result += barStack.pop();
		}
		
		System.out.println(result);
	}
}
