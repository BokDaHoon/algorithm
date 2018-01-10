package study_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10950 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int number1, number2;
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());
			sb.append(number1 + number2).append("\n");
		}
		System.out.println(sb.toString());
	}
}
