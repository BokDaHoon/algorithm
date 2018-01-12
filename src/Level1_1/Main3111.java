package Level1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main3111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String inputStr = br.readLine();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int wordLength = word.length();
		int inputStrLength = inputStr.length();
		
		for (int i = 0; i < inputStrLength; i++) {
			for (int j = i; j < i + wordLength; j++) {
				if (j >= inputStrLength || inputStr.charAt(j) != word.charAt(j - i)) {
					break;
				}
				
				if (j == i + wordLength - 1) {
					System.out.println(i);
					deque.push(i);
				}
			}
		}
		
		boolean isFirst = true;
		int startIndex = -1;
		StringBuilder sb = new StringBuilder(inputStr);
		while (!deque.isEmpty()) {
			if (isFirst) {
				startIndex = deque.removeFirst();
			} else {
				startIndex = deque.removeLast();
			}
			
			for (int i = 0; i < wordLength; i++) {
				if (sb.charAt(i) == ' ') {
					break;
				}
				sb.setCharAt(startIndex + i, ' ');			
			}
			
			isFirst = !isFirst;
		}
		
		System.out.println(sb.toString().replaceAll(" ", ""));
	}
}
