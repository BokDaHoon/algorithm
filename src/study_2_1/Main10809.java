package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @class Main10808
 * @author DaHoon Bok
 * @description 백준 10808번 알파벳 찾기
 */
public class Main10809 {
	
	private static final int ALP_SIZE = 26;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] check = new int[ALP_SIZE];
		int length = input.length();
		
		Arrays.fill(check, -1);
		
		for (int i = 0; i < length; i++) {
			check[input.charAt(i) - 'a'] = input.indexOf(input.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ALP_SIZE; i++) {
			sb.append(check[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
