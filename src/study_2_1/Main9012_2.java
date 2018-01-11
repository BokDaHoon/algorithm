package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @class Main9012
 * @author DaHoon Bok
 * @description 백준 9012번 괄호(스택사용)
 */
public class Main9012_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (testCase-- > 0) {
			String input = br.readLine();
			int length = input.length();
			Stack<Character> leftParenthesis = new Stack<Character>();
			boolean isVps = true;
			
			for (int i = 0; i < length; i++) {
				if (input.charAt(i) == '(') {
					leftParenthesis.push('(');
					continue;
				}
				
				if (leftParenthesis.isEmpty()) {
					isVps = false;
					break;
				}
				
				leftParenthesis.pop();
			}
			
			if (!leftParenthesis.isEmpty()) {
				isVps = false;
			}
			
			if (isVps) {
				sb.append("YES");
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
