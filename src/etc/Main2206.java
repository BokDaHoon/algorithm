package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @class Main2206
 * @author DaHoon Bok
 * @description 백준 2206번 벽 부수고 이동하기
 */
public class Main2206 {
	
	private static int[][] map;
	private static boolean[][] check;
	private static int rowSize;
	private static int colSize;
	private static int result = Integer.MAX_VALUE;
	private static int[] dx = {0, 0, 1, -1};
	private static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		map = new int[rowSize][colSize];
		check = new boolean[rowSize][colSize];
		
		for (int row = 0; row < rowSize; row++) {
			String input = br.readLine();
			for (int col = 0; col < colSize; col++) {
				map[row][col] = input.charAt(col) - '0';
			}
		}

		solve(false, 1, 0, 0);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void solve(boolean isCrash, int count, int row, int col) {
		if (result <= count) {
			return;
		}
		
		if (row == rowSize - 1 && col == colSize - 1) {
			result = Math.min(result, count);
			return;
		}
		
		check[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int nRow = row + dx[i];
			int nCol = col + dy[i];
			
			if (nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || check[nRow][nCol]) continue;
			
			if (map[nRow][nCol] == 1 && !isCrash) {
				solve(true, count + 1, nRow, nCol);
			} else if (map[nRow][nCol] == 0) {
				solve(isCrash, count + 1, nRow, nCol);
			}
			
		}
		check[row][col] = false;
	}
}
