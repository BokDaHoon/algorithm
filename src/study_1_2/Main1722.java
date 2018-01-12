package study_1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @class Main1722
 * @author DaHoon Bok
 * @description 백준 1722번 순열의 순서
 */
public class Main1722 {
	
	private static final int FIRST_SOLVE = 1;
	private static final int SECOND_SOLVE = 2;
	private static long[] factorial;
	private static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int permutationSize = Integer.parseInt(br.readLine());
		
		factorial = new long[permutationSize];
		num = new int[permutationSize];
		setFactorial(permutationSize);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int command = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[permutationSize + 1];
		
		switch (command) {
			case FIRST_SOLVE:
				long targetNum = Long.parseLong(st.nextToken());
				long total = factorial[permutationSize - 1];
				StringBuilder sb = new StringBuilder();
				
				for (int i = 0; i < permutationSize; i++) {
					for (int j = 1; j <= permutationSize; j++) {
						if (check[j]) {
							continue;
						}
						
						if (targetNum > factorial[permutationSize - 1 - i]) {
							targetNum -= factorial[permutationSize - 1 - i];
						} else {
							check[j] = true;
							sb.append(j).append(" ");
							break;
						}
					}
				}
				System.out.println(sb.toString());
				break;
			case SECOND_SOLVE:
				long result = 1;
				for (int i = 0; i < permutationSize; i++) {
					num[i] = Integer.parseInt(st.nextToken()); 
				}

				for (int i = 0; i < permutationSize; i++) {
					for (int j = 1; j < num[i]; j++) {
						if (check[j] == false) {
							result += factorial[permutationSize - i - 1];
						}
					}
					check[num[i]] = true;
				}
				System.out.println(result);
				break;
		}
	}
	
	private static void setFactorial(int size) {
		factorial[0] = 1;
		for (int i = 1; i < size; i ++) {
			factorial[i] = ((long) i) * factorial[i - 1];
		}
	}
}
