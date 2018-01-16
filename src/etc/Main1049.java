package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1049 {
	
	private static final int COUNT_OF_PACKAGE = 6;
	private static final int PRICE_PACKAGE = 0;
	private static final int PRICE_NO_PACKAGE = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int countOfLine = Integer.parseInt(st.nextToken());
		int countOfBrand = Integer.parseInt(st.nextToken());
		
		int[][] priceOfLine = new int[countOfBrand][2];
		
		int minPrice = Integer.MAX_VALUE;
		int minPackPrice = Integer.MAX_VALUE;
		for (int i = 0; i < countOfBrand; i++) {
			st = new StringTokenizer(br.readLine());
			priceOfLine[i][PRICE_PACKAGE] = Integer.parseInt(st.nextToken());
			priceOfLine[i][PRICE_NO_PACKAGE] = Integer.parseInt(st.nextToken());
			minPrice = Math.min(minPrice, priceOfLine[i][PRICE_NO_PACKAGE]);
			minPackPrice = Math.min(minPackPrice, priceOfLine[i][PRICE_PACKAGE]);
		}
		
		int result = 0;
		while (true) {
			if (countOfLine >= COUNT_OF_PACKAGE) {
				result += Math.min(minPrice * 6, minPackPrice);
				countOfLine -= 6;
			} else {
				result += Math.min(minPrice * (countOfLine % COUNT_OF_PACKAGE), minPackPrice);
				break;
			}
		}
		
		System.out.println(result);
	}
}
