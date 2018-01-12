package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Counsel {
	int time;
	int price;
	
	public Counsel(int time, int price) {
		this.time = time;
		this.price = price;
	}
}

public class Main14501 {
	
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countOfDay = Integer.parseInt(br.readLine());
		Counsel[] counsel = new Counsel[countOfDay + 1];
		
		String[] input;
		for (int i = 1; i <= countOfDay; i++) {
			input = br.readLine().split(" ");
			counsel[i] = new Counsel(Integer.parseInt(input[0]), 
									 Integer.parseInt(input[1]));
		}
		
		for (int i = 1; i <= countOfDay; i++) {
			solve(counsel, i, countOfDay, 0);
		}
		
		System.out.println(answer);
	}

	private static void solve(Counsel[] counsel, int startTime, int endTime, int sum) {
		if (startTime == endTime + 1) {
			if (answer < sum) {
				answer = sum;
			}
			return;
		}
		
		if (startTime > endTime) {
			return;
		}
		
		solve(counsel, startTime + counsel[startTime].time, endTime, sum + counsel[startTime].price);
		solve(counsel, startTime + 1, endTime, sum);
	}
}
