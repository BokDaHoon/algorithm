package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @class Main10845
 * @author DaHoon Bok
 * @description 백준 10845번 Deque
 */
public class Main10866 {
	
	private static final int COMMAND = 0;
	private static final int VALUE = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new ArrayDeque<Integer>();
		String[] input;
		while (testCase-- > 0) {
			input = br.readLine().split(" ");
			
			switch (input[COMMAND]) {
				case "push_front":
					deque.addFirst(Integer.valueOf(input[VALUE]));
					break;
				case "push_back":
					deque.addLast(Integer.valueOf(input[VALUE]));
					break;
				case "pop_front":
					System.out.println((deque.isEmpty()) ? "-1" : deque.poll());
					break;
				case "pop_back":
					System.out.println((deque.isEmpty()) ? "-1" : deque.pollLast());
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					System.out.println((deque.isEmpty()) ? "1" : "0");
					break;
				case "front":
					System.out.println((deque.isEmpty()) ? "-1" : deque.getFirst());
					break;
				case "back":
					System.out.println((deque.isEmpty()) ? "-1" : deque.getLast());
					break;
			}
		}
	}
}
