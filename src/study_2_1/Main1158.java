package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @class Main1158
 * @author DaHoon Bok
 * @description 백준 1158번 조세퍼스
 */
public class Main1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int step = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < size; i++) {
			queue.add(i + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while (!queue.isEmpty()) {
			for (int i = 0; i < step - 1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll());
			
			if (!queue.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
