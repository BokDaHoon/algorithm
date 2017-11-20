package Level1_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘
 * 동전0 문제
 * https://www.acmicpc.net/problem/11047
 *
 */
public class Main11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int countOfCoinType = Integer.parseInt(st.nextToken());
		int goalOfSumCoin = Integer.parseInt(st.nextToken());
		
		int[] coinType = new int[countOfCoinType];
		for (int i = 0; i < countOfCoinType; i++) {
			coinType[i] = Integer.parseInt(br.readLine());
		}
		
		int result = 0;
		int index = countOfCoinType - 1;
		
		while (goalOfSumCoin > 0) {
			result += goalOfSumCoin / coinType[index];
			goalOfSumCoin = goalOfSumCoin % coinType[index];
			index--;
		}
		
		System.out.println(result);
	}
}
