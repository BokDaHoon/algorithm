package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main11656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		ArrayList<String> arr = new ArrayList<String>();
		
		int length = input.length();
		for (int i = 0; i < length; i++) {
			arr.add(input.substring(i, length));
		}
		
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (String result : arr) {
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}