package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9095 {
	
	private static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int subinPosition = Integer.parseInt(st.nextToken());
		int broPosition = Integer.parseInt(st.nextToken());
		
		solve(subinPosition, broPosition, 0);
		
		System.out.println(result);
	}
	
	private static void solve(int posOfCurr, int posOfGoal, int step) {
		if (posOfCurr == posOfGoal) {
			result = step;
			return;
		}
		
		solve(posOfCurr - 1, posOfGoal, step + 1);
		solve(posOfCurr + 1, posOfGoal, step + 1);
		solve(posOfCurr * 2, posOfGoal, step + 1);
	}
	
}
