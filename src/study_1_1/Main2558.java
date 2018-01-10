package study_1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2558 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number1 = Integer.parseInt(br.readLine());
		int number2 = Integer.parseInt(br.readLine());
		System.out.println(number1 + number2);
	}
}