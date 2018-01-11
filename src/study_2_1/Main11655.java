package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @class Main11655
 * @author DaHoon Bok
 * @description 백준 11655번 ROT13
 */
public class Main11655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int length = sb.length();
		
		for (int i = 0; i < length; i++) {
			sb.setCharAt(i, getRot13(sb.charAt(i)));				
		}
		
		System.out.println(sb.toString());
	}
	
	static char getRot13(char value) {
		if (value >= 'a' && value <= 'z') {
			return (char) ((value + 13 - 'a') % 26 + 'a');			
		} else if (value >= 'A' && value <= 'Z') {
			return (char) ((value + 13 - 'A') % 26 + 'A');
		} else {
			return value;
		}
	}
}
