package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Baekjoon 1107
 * RemoteController
 * */
public class Main1107 {
	
	private static final int currentChannel = 100;
	private static boolean[] brokenBtn;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int destChannel = Integer.parseInt(br.readLine());
		int brokenBtnCount = Integer.parseInt(br.readLine());
		brokenBtn = new boolean[10];
		
		int result = Math.abs(destChannel - currentChannel);
		
		if (brokenBtnCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < brokenBtnCount; i++) {
				int btnNum = Integer.parseInt(st.nextToken());
				brokenBtn[btnNum] = true;
			}
		}
		
		for (int i = 0; i <= 1000000; i++) {
			int length = check(i);
			
			if (length == 0) {
				continue;
			}
			
			length += Math.abs(destChannel - i);
			
			if (result > length) {
				result = length;
			}
		}
		
		System.out.println(result);
	}
	
	private static int check(int channel) {
		int answer = 0;
		
		if (channel == 0) {
			if (brokenBtn[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		
		while (channel > 0) {
			int temp = channel % 10;
			if (brokenBtn[temp]) {
				return 0;
			}
			answer++;
			channel /= 10;
		}
		
		return answer;
	}
}
