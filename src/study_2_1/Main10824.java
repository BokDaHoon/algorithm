package study_2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @class Main10824
 * @author DaHoon Bok
 * @description 백준 10824번 네 수
 */
public class Main10824 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String num1 = st.nextToken() + st.nextToken();
		String num2 = st.nextToken() + st.nextToken();
		
		System.out.println(Long.parseLong(num1) + Long.parseLong(num2));
	}
}
