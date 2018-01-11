package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @class Main10845
 * @author DaHoon Bok
 * @description 백준 10845번 Queue
 */
public class Main10845 {
	
	private static final int COMMAND = 0;
	private static final int VALUE = 1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		Deque<String> queue = new ArrayDeque<String>();
		String[] input;
		StringBuilder sb = new StringBuilder();
		
		while (testCase-- > 0) {
			input = br.readLine().split(" ");
			
			switch (input[COMMAND]) {
				case "push":
					queue.add(input[VALUE]);
					break;
				case "pop":
					System.out.println((queue.isEmpty()) ? "-1" : queue.poll());
					break;
				case "size":
					System.out.println(queue.size());
					break;
				case "empty":
					System.out.println((queue.isEmpty()) ? "1" : "0");
					break;
				case "front":
					System.out.println((queue.isEmpty()) ? "-1" : queue.getFirst());
					break;
				case "back":
					System.out.println((queue.isEmpty()) ? "-1" : queue.getLast());
					break;
			}
		}
	}
}
