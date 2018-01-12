package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13460 {
	public static final int[] dx = {0, 0, 1, -1};
	public static final int[] dy = {1, -1, 0, 0};
	
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static final int DOWN = 2;
	public static final int UP = 3;
	
	static int rowSize;
	static int colSize;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> visit = new HashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();
		String map;

		for (int row = 0; row < rowSize; row++) {
			sb.append(br.readLine().trim());
		}
		
		map = sb.toString();
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(map);
		visit.put(map, 0);
		
		boolean hasAnswer = false;

		while (!queue.isEmpty()) {
			String currentMap = queue.remove();
			
			int redIndex = currentMap.indexOf('R');
			int redRow = redIndex / colSize;
			int redCol = redIndex % colSize;
			
			int blueIndex = currentMap.indexOf('B');
			int blueRow = blueIndex / colSize;
			int blueCol = blueIndex % colSize;
			
			int answer = visit.get(currentMap);
			
			if (answer >= 10) {
				hasAnswer = false;
				break;
			}
			
			if (currentMap.indexOf('F') >= 0) {
				hasAnswer = false;
			}
			
			if (currentMap.indexOf('S') >= 0 && answer < 10) {
				System.out.println(answer);
				hasAnswer = true;
				break;
			}
			
			if (redIndex <= -1 || blueIndex <= -1) {
				hasAnswer = false;
				break;
			}
			

			for (int i = 0; i <= 3; i++) {
				sb = new StringBuilder(currentMap);
				String firstMap = "";
				String secondMap = "";
				if (i == RIGHT) {
					if (currentMap.indexOf('R') < currentMap.indexOf('B')) {
						firstMap = mapAfterMove(currentMap, blueRow, blueCol, i, true);
						secondMap = mapAfterMove(firstMap, redRow, redCol, i, false);
						
					} else {
						firstMap = mapAfterMove(currentMap, redRow, redCol, i, false);
						secondMap = mapAfterMove(firstMap, blueRow, blueCol, i, true);
						
					}
				} else if (i == LEFT) {
					if (currentMap.indexOf('R') < currentMap.indexOf('B')) {
						firstMap = mapAfterMove(currentMap, redRow, redCol, i, false);
						secondMap = mapAfterMove(firstMap, blueRow, blueCol, i, true);
						
					} else {
						firstMap = mapAfterMove(currentMap, blueRow, blueCol, i, true);
						secondMap = mapAfterMove(firstMap, redRow, redCol, i, false);
						
					}
				} else {
					firstMap = mapAfterMove(currentMap, redRow, redCol, i, false);
					secondMap = mapAfterMove(firstMap, blueRow, blueCol, i, true);
				}
				
				if (!visit.containsKey(secondMap)) {
					queue.add(secondMap);
					visit.put(secondMap, visit.get(currentMap) + 1);
				}
			}
			
		}
		
		if (!hasAnswer) {
			System.out.println(-1);
		}
	}
	
	private static String mapAfterMove(String map, int colorRow, int colorCol, int moveIndex, boolean isBlue) {
		StringBuilder sb = new StringBuilder(map);
		
		int weight = 1;
		while (true) {
			// 1. Red
			int tempRow = colorRow + (dx[moveIndex] * weight);
			int tempCol = colorCol + (dy[moveIndex] * weight);
			
			if (tempRow >= 0 && tempRow < rowSize && tempCol >= 0 && tempCol < colSize) {
				if (map.charAt((tempRow * colSize) + tempCol) == '.') {
					weight++;
				} else if (map.charAt((tempRow * colSize) + tempCol) == 'O' || 
						   map.charAt((tempRow * colSize) + tempCol) == 'S') { 
					sb.setCharAt(((colorRow * colSize) + colorCol), '.');
					sb.setCharAt(((tempRow * colSize) + tempCol), (isBlue) ? 'F' : 'S');
					break;
				}else {
					weight--;
					break;
				}
			} else {
				weight--;
				break;
			}
		}
		
		int colorMoveRow = colorRow + (dx[moveIndex] * weight);
		int colorMoveCol = colorCol + (dy[moveIndex] * weight);
		
		if (colorMoveRow >= 0 && colorMoveRow < rowSize && colorMoveCol >= 0 && colorMoveCol < colSize) {
			System.out.println(colorRow + " / " + colorCol);
			if (map.charAt((colorMoveRow * colSize) + colorMoveCol) == '.') {
				char temp =  map.charAt((colorRow * colSize) + colorCol);
				sb.setCharAt(((colorRow * colSize) + colorCol), '.');
				sb.setCharAt(((colorMoveRow * colSize) + colorMoveCol), temp);
			} 
		}
		
		return sb.toString();
	}
	

	/*static void print(String map) {
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				System.out.print(map.charAt((row * colSize) + col));
			}
			System.out.println();
		}
		System.out.println();
	}*/
}
