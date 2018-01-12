package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main1012 {
	
	static int[][] map;
	static boolean[][] check;
	
	static int max;
	static int rowSize;
	static int colSize;
	
	static int robotRow;
	static int robotCol;
	static int robotDir;
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	static Pair[] dirPos = new Pair[] {
			new Pair(0, 1),  // 0. ��
			new Pair(1, 0),  // 1. ��
			new Pair(0, -1), // 2. ��
			new Pair(-1, 0)  // 3. ��
	};
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		robotRow = Integer.parseInt(st.nextToken());
		robotCol = Integer.parseInt(st.nextToken());
		robotDir = Integer.parseInt(st.nextToken());
		
		map   = new int[rowSize][colSize];
		check = new boolean[rowSize][colSize];
		
		for (int row = 0; row < rowSize; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < colSize; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		answer++;
		check[robotRow][robotCol] = true;
		solve(robotRow, robotCol, robotDir);
		
		System.out.println(answer);
		
		for (int row = 0; row < rowSize; row++) {
			System.out.println(Arrays.toString(map[row]));
		}
	}

	private static void solve(int row, int col, int dir) {
		
		boolean isNotMove = true;
		
		int dirTemp = dir;
		
		for (int i = 0; i < 4; i++) {
			dirTemp = dirTemp - 1;
			
			if (dirTemp < 0) {
				dirTemp = 3;
			}

			int nRow = row + dirPos[dirTemp].x;
			int nCol = col + dirPos[dirTemp].y;
			
			if (nRow >= 0 && nRow < rowSize && nCol >= 0 && nCol < colSize 
						  && !check[nRow][nCol] && map[nRow][nCol] == 0) {
				check[nRow][nCol] = true;
				map[nRow][nCol] = 1;
				answer++;
				isNotMove = false;
				solve(nRow, nCol, dirTemp);
				break;
			}
		}
		
		if (isNotMove) {
			int nRow = (dirPos[dir].x != 0) ? row + (dirPos[dir].x * -1) :  row;
			int nCol = (dirPos[dir].y != 0) ? col + (dirPos[dir].y * -1) :  col;
			
			if (nRow >= 0 && nRow < rowSize && nCol >= 0 && nCol < colSize && map[nRow][nCol] == 1) {
				return;
			}
			
			solve(nRow, nCol, dir);
		}
	}
}

