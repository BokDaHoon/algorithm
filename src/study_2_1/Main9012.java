package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @class Main9012
 * @author DaHoon Bok
 * @description 백준 9012번 괄호
 */
public class Main9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while (testCase-- > 0) {
			String input = br.readLine();
			int length = input.length();
			int leftParenthesis = 0;
			boolean isVps = true;
			
			for (int i = 0; i < length; i++) {
				if (input.charAt(i) == '(') {
					leftParenthesis++;
					continue;
				}
				
				if (leftParenthesis == 0) {
					isVps = false;
					break;
				}
				
				leftParenthesis--;
			}
			
			if (leftParenthesis != 0) {
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
