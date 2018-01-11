package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @class Main10808
 * @author DaHoon Bok
 * @description 백준 10820번 문자열 분석
 */
public class Main10820 {
	
	private static final int SMALL = 0;
	private static final int LARGE = 1;
	private static final int NUMBER = 2;
	private static final int SPACE = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		StringBuilder sb = new StringBuilder();
		while ((input = br.readLine()) != null) {
			int[] result = new int[4];
			int length = input.length();
			
			for (int i = 0; i < length; i++) {
				if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
					result[SMALL] += 1;
				} else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
					result[LARGE] += 1;
				} else if (input.charAt(i) == ' ') {
					result[SPACE] += 1;
				} else {
					result[NUMBER] += 1;
				}
			}
			sb.append(result[SMALL]).append(" ");
			sb.append(result[LARGE]).append(" ");
			sb.append(result[NUMBER]).append(" ");
			sb.append(result[SPACE]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
