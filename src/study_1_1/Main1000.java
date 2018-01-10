package study_1_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		bw.write(number1 + number2);
		bw.flush();
		bw.close();
		br.close();
	}
}
