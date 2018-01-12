package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @class Main2606
 * @author DaHoon Bok
 * @description 백준 2606번 바이러스
 */
public class Main2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countOfComputer = Integer.parseInt(br.readLine());
		int countOfLink = Integer.parseInt(br.readLine());
		
		int[][] map = new int[countOfComputer + 1][countOfComputer + 1];
		boolean[] check = new boolean[countOfComputer + 1];
		
		while (countOfLink-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		check[1] = true;
		int result = 0;
		
		while (!queue.isEmpty()) {
			int start = queue.poll();
			
			for (int end = 1; end <= countOfComputer; end++) {
				if (!check[end] && map[start][end] == 1) {
					queue.add(end);
					check[end] = true;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
