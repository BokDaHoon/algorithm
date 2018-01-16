package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @class Main3085
 * @author DaHoon Bok
 * @description 백준 3085번 사탕게임
 */
public class Main3085 {
	
	private static int[] dRow = {0, 1};
	private static int[] dCol = {1, 0};
	
	private static int arraySize;
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arraySize = Integer.parseInt(br.readLine());
		
		char[][] map = new char[arraySize][arraySize];
		for (int i = 0; i < arraySize; i++) {
			String input = br.readLine();
			for (int j = 0; j < arraySize; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		for (int row = 0; row < arraySize; row++) {
			for (int col = 0; col < arraySize; col++) {
				solve(map, row, col);				
			}
		}
		
		System.out.println(result);
	}
	
	private static void solve(char[][] map, int row, int col) {
		if (row == arraySize - 1 && col == arraySize - 1) {
			return;
		}
		
		for (int i = 0; i < 2; i++) {
			int nRow = row + dRow[i];
			int nCol = col + dCol[i];
			
			if (nRow < 0 || nRow >= arraySize || nCol < 0 || nCol >= arraySize) continue;
			
			char temp = map[row][col];
			map[row][col] = map[nRow][nCol];
			map[nRow][nCol] = temp;
			
			check(map);
			
			temp = map[row][col];
			map[row][col] = map[nRow][nCol];
			map[nRow][nCol] = temp;
		}
		
	}
	
	private static void check(char[][] map) {
		int currentCount = 1, totalMaxCount = 0;
		for (int row = 0; row < arraySize; row++) {
			for (int col = 0; col < arraySize - 1; col++) {
				if (map[row][col] == map[row][col + 1]) {
					currentCount ++;
					continue;
				} 
				
				totalMaxCount = Math.max(totalMaxCount, currentCount);
				currentCount = 1;
			}
			totalMaxCount = Math.max(totalMaxCount, currentCount);
			currentCount = 1;
		}
		
		currentCount = 1;
		for (int col = 0; col < arraySize; col++) {
			for (int row = 0; row < arraySize - 1; row++) {
				if (map[row][col] == map[row + 1][col]) {
					currentCount ++;
					continue;
				} 
				
				totalMaxCount = Math.max(totalMaxCount, currentCount);
				currentCount = 1;
			}
			totalMaxCount = Math.max(totalMaxCount, currentCount);
			currentCount = 1;
		}
		
		result = Math.max(result, totalMaxCount);
	}
}
